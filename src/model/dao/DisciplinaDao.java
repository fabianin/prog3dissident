package model.dao;

import exceptions.DisciplinaJaCadastradaException;
import java.io.IOException;
import java.util.ArrayList;
import model.pojo.Disciplina;

/**
 *
 * @author Fabiano
 */
public interface DisciplinaDao {

    /**
     * Adiciona uma disciplina ao DAO
     *
     * @param disciplina Disciplina a ser adicionada
     * @throws DisciplinaJaCadastradaException Caso a disciplina já esteja
     * cadastrada
     * @throws IOException Caso haja problema ao salvar o arquivo
     */
    public void addDisciplina(Disciplina disciplina) throws DisciplinaJaCadastradaException, IOException;

    /**
     * Obtém uma disciplina à partir do ID
     *
     * @param id ID da disciplina a ser buscada
     * @return Objeto Disciplina
     */
    public Disciplina getDisciplinaById(int id);

    /**
     * Salva o DAO
     *
     * @throws IOException Caso haja problema ao salvar o arquivo
     */
    public void saveFile() throws IOException;

    /**
     * Obtém todas as disciplinas cadastradas
     *
     * @return Uma lista de objeto Disciplina
     */
    public ArrayList<Disciplina> getDisciplinas();

}
