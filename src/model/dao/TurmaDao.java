package model.dao;

import exceptions.AtividadeJaCadastradaException;
import exceptions.FaltaJaCadastradaException;
import exceptions.TurmaJaCadastradaException;
import exceptions.TurmaNaoEncontradaException;
import java.io.IOException;
import java.util.ArrayList;
import model.pojo.Turma;

/**
 *
 * @author Elias Júnior
 */
public interface TurmaDao {

    /**
     * Obtém uma turma à partir de um ID
     *
     * @param id ID a ser buscado
     * @return Um objeto Turma
     */
    public Turma getTurmaById(int id);

    /**
     * Obtém uma lista de Turma
     *
     * @return Lista de objeto Turma
     */
    public ArrayList<Turma> getTurmas();

    /**
     * Salva em um arquivo
     *
     * @throws IOException Caso haja um problema ao salvar o arquivo
     */
    public void saveFile() throws IOException;

    /**
     * Adiciona uma turma ao DAO
     *
     * @param turma Turma a ser adicionada
     * @throws TurmaJaCadastradaException Caso a turma já tenha sido cadastrada
     * @throws IOException Caso haja um problema ao salvar o arquivo
     */
    public void adicionarTurma(Turma turma) throws TurmaJaCadastradaException, IOException;

    /**
     * Adiciona uma atividade em uma Turma
     *
     * @param turmaId ID Turma que receberá a atividade
     * @param atividadeId ID da atividade a ser adicionado
     * @throws AtividadeJaCadastradaException Caso a atividade já tenha sido
     * cadastrada
     * @throws TurmaNaoEncontradaException Caso a turma não tenha sido
     * encontrada
     * @throws IOException Caso haja um erro ao salvar o arquivo
     */
    public void adicionarAtividade(int turmaId, int atividadeId) throws AtividadeJaCadastradaException, TurmaNaoEncontradaException, IOException;

    /**
     * Adiciona uma falta em uma turma
     *
     * @param turmaId ID da turma que receberá a falta
     * @param faltaId ID da falta a ser adicionado
     * @throws FaltaJaCadastradaException Caso a falta já tenha sido cadastrada
     * @throws TurmaNaoEncontradaException Caso a turma não tenha sido
     * encontrada
     * @throws IOException Caso haja um erro ao salvar o arquivo
     */
    public void adicionarFalta(int turmaId, int faltaId) throws FaltaJaCadastradaException, TurmaNaoEncontradaException, IOException;

}
