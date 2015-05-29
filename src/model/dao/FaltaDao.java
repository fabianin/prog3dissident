package model.dao;

import exceptions.FaltaJaCadastradaException;
import java.io.IOException;
import java.util.ArrayList;
import model.pojo.Falta;

/**
 *
 * @author Fabiano
 */
public interface FaltaDao {

    /**
     * Obtém uma falta à partir do ID
     *
     * @param id ID a ser buscado
     * @return Um objeto Falta
     */
    public Falta getFaltaById(int id);

    /**
     * Salva arquivo
     *
     * @throws IOException Caso haja um erro ao salvar o arquivo
     */
    public void saveFile() throws IOException;

    /**
     * Adiciona uma falta no DAO
     *
     * @param falta Falta a ser cadastrada
     * @throws FaltaJaCadastradaException Caso já tenha sido cadastrada
     * @throws IOException Caso haja um erro ao salvar o arquivo
     */
    public void addFalta(Falta falta) throws FaltaJaCadastradaException, IOException;

    /**
     * Obtém todas as faltas
     *
     * @return Lista de objetos Falta
     */
    public ArrayList<Falta> getFaltas();

    /**
     * Obtém uma Falta à partir de um aluno e uma turma
     *
     * @param alunoId ID do aluno
     * @param turmaId ID da turma do aluno
     * @return Um objeto Falta
     */
    public Falta getFaltaByIdAluno(int alunoId, int turmaId);

}
