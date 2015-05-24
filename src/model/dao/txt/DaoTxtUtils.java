package model.dao.txt;

import exceptions.DisciplinaJaCadastradaException;
import exceptions.NotaJaCadastradaException;
import exceptions.ProfessorNaoAptoDisciplinaException;
import exceptions.TurmaJaCadastradaException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import model.pojo.Aluno;
import model.pojo.Atividade;
import model.pojo.Disciplina;
import model.pojo.Falta;
import model.pojo.Nota;
import model.pojo.Professor;
import model.pojo.Turma;
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

    public static Turma createTurmaFromJSON(JSONObject obj) throws JSONException, NullPointerException, IllegalArgumentException, ProfessorNaoAptoDisciplinaException {

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

        Falta falta = new Falta(aluno, faltas);

        return falta;

    }

    public static Nota createNotaFromJSON(JSONObject obj) throws JSONException {

        double valorObtido = obj.getDouble("valorObtido");

        int aluno = obj.getInt("aluno");

        Nota nota = new Nota(valorObtido, aluno);

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

}
