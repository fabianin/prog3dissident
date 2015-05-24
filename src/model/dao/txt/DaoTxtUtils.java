package model.dao.txt;

import java.util.ArrayList;
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
public abstract class DaoTxtUtils {

    public static Aluno createAlunoFromJSON(JSONObject obj) throws JSONException {

        String nome = obj.getString("nome");
        Long cpf = obj.getLong("cpf");
        Long matricula = obj.getLong("matricula");

        JSONObject turmas = obj.getJSONObject("turmas");

        Aluno aluno = new Aluno(matricula, nome, cpf);

        return aluno;

    }

    public static ArrayList<Turma> createTurmaFromJSON(JSONObject obj) throws JSONException {
        ArrayList<Turmas> turmas;
        JSONArray arr = obj.getJSONArray("turmas");
        for (int i = 0; i < arr.length(); i++) {
            long periodo = arr.getJSONObject(i).getLong("periodo");
            long numeroVagas = arr.getJSONObject(i).getLong("numeroVagas");
            long sala = arr.getJSONObject(i).getLong("sala");
            long ano;
        }
        return null;
    }

    public static Disciplina createDisciplinaFromJSON(JSONObject obj) throws JSONException {
        return null;
    }

    public static Falta createFaltaFromJSON(JSONObject obj) throws JSONException {
        return null;
    }

    public static Nota createNotaFromJSON(JSONObject obj) throws JSONException {
        return null;
    }

    public static Professor createProfessorFromJSON(JSONObject obj) throws JSONException {
        return null;
    }

    public static Atividade createAtividadeFromJSON(JSONObject obj) throws JSONException {
        return null;
    }

}
