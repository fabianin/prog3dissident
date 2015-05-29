package model.dao;

import exceptions.NotaJaCadastradaException;
import java.io.IOException;
import java.util.ArrayList;
import model.pojo.Nota;

/**
 *
 * @author Elias Júnior
 */
public interface NotaDao {

    /**
     * Obtém todos os registros de notas no banco de dados
     *
     * @return Uma lista de objetos Nota
     */
    public ArrayList<Nota> getNotas();

    /**
     * Obtém uma nota à partir de um ID do aluno
     *
     * @param alunoId ID do aluno
     * @param turmaId ID da turma do aluno
     * @return Um objeto Nota
     */
    public Nota getNotaPorAlunoId(int alunoId, int turmaId);

    /**
     * Obtém uma nota à partir de um ID da nota
     *
     * @param notaId
     * @return Um objeto Nota
     */
    public Nota getNotaPorId(int notaId);

    /**
     * Adiciona uma nota
     *
     * @param nota Nota a ser adicionada
     * @throws exceptions.NotaJaCadastradaException Caso a nota já esteja
     * cadastrada
     * @throws java.io.IOException Caso haja um problema ao salvar o arquivo
     */
    public void adicionaNota(Nota nota) throws NotaJaCadastradaException, IOException;

    /**
     * Salva o arquivo atual
     *
     * @throws IOException Caso haja um problema ao salvar o arquivo
     */
    public void saveFile() throws IOException;

}
