package model.dao.txt;

import exceptions.AlunoJaCadastradoException;
import exceptions.AtividadeJaCadastradaException;
import exceptions.DisciplinaJaCadastradaException;
import exceptions.FaltaJaCadastradaException;
import exceptions.NotaJaCadastradaException;
import exceptions.ProfessorNaoAptoDisciplinaException;
import exceptions.TurmaJaCadastradaException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.pojo.Aluno;
import model.pojo.Atividade;
import model.pojo.Disciplina;
import model.pojo.Falta;
import model.pojo.Nota;
import model.pojo.Professor;
import model.pojo.Turma;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Elias Júnior
 */
public class DaoTxtUtils {

    public static Aluno createAlunoFromJSON(JSONObject obj) throws JSONException, TurmaJaCadastradaException {

        String nome = obj.getString("nome");
        Long cpf = obj.getLong("cpf");
        Long matricula = obj.getLong("matricula");

        Aluno aluno = new Aluno(matricula, nome, cpf);

        JSONArray arrayTurmas = obj.getJSONArray("turmas");

        for (int i = 0; i < arrayTurmas.length(); i++) {
            int turmaId = arrayTurmas.getInt(i);
            aluno.addTurma(turmaId);
        }

        return aluno;

    }

    public static Turma createTurmaFromJSON(JSONObject obj) throws JSONException, NullPointerException, IllegalArgumentException, ProfessorNaoAptoDisciplinaException, FaltaJaCadastradaException, AlunoJaCadastradoException, AtividadeJaCadastradaException {

        long periodo = obj.getLong("periodo");
        long numeroVagas = obj.getLong("numeroVagas");
        long sala = obj.getLong("sala");
        long ano = obj.getLong("ano");
        int disciplina = obj.getInt("disciplina");
        int professor = obj.getInt("professor");

        Turma turma = new Turma(disciplina, periodo, numeroVagas, sala, ano, professor);

        JSONArray arrayAtividades = obj.getJSONArray("atividades");
        JSONArray arrayAlunos = obj.getJSONArray("alunos");
        JSONArray arrayFaltas = obj.getJSONArray("faltas");

        for (int i = 0; i < arrayAtividades.length(); i++) {
            int atividadeId = arrayAtividades.getInt(i);
            turma.addAtividade(atividadeId);
        }

        for (int i = 0; i < arrayAlunos.length(); i++) {
            int alunoId = arrayAlunos.getInt(i);
            turma.addAluno(alunoId);
        }

        for (int i = 0; i < arrayFaltas.length(); i++) {
            int faltaId = arrayFaltas.getInt(i);
            turma.addFalta(faltaId);
        }

        return turma;

    }

    public static Disciplina createDisciplinaFromJSON(JSONObject obj) throws JSONException, TurmaJaCadastradaException {

        String nome = obj.getString("nome");
        String ementa = obj.getString("ementa");
        long cargaHoraria = obj.getLong("cargaHoraria");

        JSONArray arrayTurmas = obj.getJSONArray("turmas");

        Disciplina disciplina = new Disciplina(nome, ementa, cargaHoraria);

        for (int i = 0; i < arrayTurmas.length(); i++) {
            int turmaId = arrayTurmas.getInt(i);
            disciplina.addTurma(turmaId);
        }

        return disciplina;

    }

    public static Falta createFaltaFromJSON(JSONObject obj) throws JSONException {

        int faltas = obj.getInt("faltas");

        int aluno = obj.getInt("aluno");
        int turma = obj.getInt("turma");

        Falta falta = new Falta(aluno, faltas, turma);

        return falta;

    }

    public static Nota createNotaFromJSON(JSONObject obj) throws JSONException {

        double valorObtido = obj.getDouble("valorObtido");

        int aluno = obj.getInt("aluno");
        int turma = obj.getInt("turma");

        Nota nota = new Nota(valorObtido, aluno, turma);

        return nota;

    }

    public static Professor createProfessorFromJSON(JSONObject obj) throws JSONException, TurmaJaCadastradaException, IllegalArgumentException, NullPointerException, DisciplinaJaCadastradaException {

        String nome = obj.getString("nome");
        long cpf = obj.getLong("cpf");
        String departamento = obj.getString("departamento");

        JSONArray arrayDisciplinasApto = obj.getJSONArray("disciplinasApto");
        JSONArray arrayTurmasLecionando = obj.getJSONArray("turmasLecionando");

        Professor professor = new Professor(nome, cpf, departamento);

        for (int i = 0; i < arrayDisciplinasApto.length(); i++) {
            int disciplinaAptoId = arrayDisciplinasApto.getInt(i);
            professor.addDisciplinaApto(disciplinaAptoId);
        }

        for (int i = 0; i < arrayTurmasLecionando.length(); i++) {
            int turmaLecionandoId = arrayTurmasLecionando.getInt(i);
            professor.addTurmaLecionando(turmaLecionandoId);
        }

        return professor;

    }

    public static Atividade createAtividadeFromJSON(JSONObject obj) throws JSONException, NotaJaCadastradaException {

        String nome = obj.getString("nome");
        String dataStr = obj.getString("data");
        Calendar data = new GregorianCalendar();
        String tipo = obj.getString("tipo");

        JSONArray arrayNotas = obj.getJSONArray("notas");

        Atividade atividade = new Atividade(nome, data, tipo);

        for (int i = 0; i < arrayNotas.length(); i++) {
            int notaId = arrayNotas.getInt(i);
            atividade.addNota(notaId);
        }

        return atividade;

    }

    public static String toJSON(Nota nota) throws JSONException {
        JSONObject notaJson = new JSONObject();
        notaJson.put("valorObtido", nota.getValorObtido());
        notaJson.put("aluno", nota.getAluno());
        notaJson.put("id", nota.hashCode());
        notaJson.put("turma", nota.getTurma());
        return notaJson.toString();
    }

    public static String toJSON(Aluno aluno) throws JSONException {
        JSONObject alunoJson = new JSONObject();
        alunoJson.put("matricula", aluno.getMatricula());
        alunoJson.put("nome", aluno.getNome());
        alunoJson.put("cpf", aluno.getCpf());
        JSONArray turmasJson = new JSONArray();
        aluno.getTurmas().stream().forEach((id) -> turmasJson.put(id));
        alunoJson.put("turmas", turmasJson);
        alunoJson.put("id", aluno.hashCode());
        return alunoJson.toString();
    }

    public static String toJSON(Atividade atividade) throws JSONException {
        JSONObject atividadeJson = new JSONObject();
        atividadeJson.put("nome", atividade.getNome());
        atividadeJson.put("data", "");
        atividadeJson.put("tipo", atividade.getTipo());
        JSONArray notasJson = new JSONArray();
        atividade.getNotas().stream().forEach((id) -> notasJson.put(id));
        atividadeJson.put("notas", notasJson);
        atividadeJson.put("id", atividade.hashCode());
        return atividadeJson.toString();
    }

    public static String toJSON(Disciplina disciplina) throws JSONException {
        JSONObject disciplinaJson = new JSONObject();
        disciplinaJson.put("nome", disciplina.getNome());
        disciplinaJson.put("ementa", disciplina.getEmenta());
        disciplinaJson.put("cargaHoraria", disciplina.getCargaHoraria());
        JSONArray turmasJson = new JSONArray();
        disciplina.getTurmas().stream().forEach((id) -> turmasJson.put(id));
        disciplinaJson.put("turmas", turmasJson);
        disciplinaJson.put("id", disciplina.hashCode());
        return disciplinaJson.toString();
    }

    public static String toJSON(Falta falta) throws JSONException {
        JSONObject faltaJson = new JSONObject();
        faltaJson.put("faltas", falta.getFaltas());
        faltaJson.put("aluno", falta.getAluno());
        faltaJson.put("id", falta.hashCode());
        faltaJson.put("turma", falta.getTurma());
        return faltaJson.toString();
    }

    public static String toJSON(Professor professor) throws JSONException {
        JSONObject professorJson = new JSONObject();
        professorJson.put("departamento", professor.getDepartamento());
        professorJson.put("nome", professor.getNome());
        professorJson.put("cpf", professor.getCpf());
        JSONArray disciplinasAptoJson = new JSONArray();
        JSONArray turmasLecionandoJson = new JSONArray();
        professor.getDisciplinasApto().stream().forEach((id) -> disciplinasAptoJson.put(id));
        professor.getTurmasLecionando().stream().forEach((id) -> turmasLecionandoJson.put(id));
        professorJson.put("disciplinasApto", disciplinasAptoJson);
        professorJson.put("turmasLecionando", turmasLecionandoJson);
        professorJson.put("id", professor.hashCode());
        return professorJson.toString();
    }

    public static String toJSON(Turma turma) throws JSONException {
        JSONObject turmaJson = new JSONObject();
        turmaJson.put("periodo", turma.getPeriodo());
        turmaJson.put("numeroVagas", turma.getNumeroVagas());
        turmaJson.put("sala", turma.getSala());
        turmaJson.put("disciplina", turma.getDisciplina());
        turmaJson.put("ano", turma.getAno());
        turmaJson.put("professor", turma.getProfessor());
        JSONArray atividadesJson = new JSONArray();
        JSONArray alunosJson = new JSONArray();
        JSONArray faltasJson = new JSONArray();
        turma.getAtividades().stream().forEach((id) -> atividadesJson.put(id));
        turma.getAlunos().stream().forEach((id) -> alunosJson.put(id));
        turma.getFaltas().stream().forEach((id) -> faltasJson.put(id));
        turmaJson.put("atividades", atividadesJson);
        turmaJson.put("alunos", alunosJson);
        turmaJson.put("faltas", faltasJson);
        turmaJson.put("id", turma.hashCode());
        return turmaJson.toString();
    }

}
