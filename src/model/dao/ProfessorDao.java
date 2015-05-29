package model.dao;

import exceptions.ProfessorJaCadastradoException;
import exceptions.TurmaJaCadastradaException;
import java.io.IOException;
import java.util.ArrayList;
import model.pojo.Professor;

/**
 *
 * @author Elias Júnior
 */
public interface ProfessorDao {

    /**
     * Obtém um professor à partir de um ID
     *
     * @param id ID a ser buscado
     * @return Um objeto Professor
     */
    public Professor getProfessorById(int id);

    /**
     * Obtém todos os professores do DAO
     *
     * @return Uma lista de objetos Professor
     */
    public ArrayList<Professor> getProfessores();

    /**
     * Adiciona um professor no DAO
     *
     * @param professor Professor a ser adicionado
     * @throws ProfessorJaCadastradoException Caso o professor já tenha sido
     * adicionado
     * @throws IOException Caso haja um problema ao salvar o arquivo
     */
    public void adicionaProfessor(Professor professor) throws ProfessorJaCadastradoException, IOException;

    /**
     * Salva arquivo
     *
     * @throws IOException Caso haja um problema ao salvar o arquivo
     */
    public void saveFile() throws IOException;

    /**
     * Adiciona uma turma em um professor
     *
     * @param professorId ID do professor a receber a turma
     * @param turmaId ID da turma a ser adicionada
     * @throws TurmaJaCadastradaException Caso a turma já tenha sido cadastrada
     * @throws IOException Caso haja um erro ao salvar o arquivo
     */
    public void adicionarTurma(int professorId, int turmaId) throws TurmaJaCadastradaException, IOException;

}
