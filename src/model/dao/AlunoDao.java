package model.dao;

import exceptions.AlunoJaCadastradoException;
import java.io.IOException;
import java.util.ArrayList;
import model.pojo.Aluno;

/**
 *
 * @author Elias Júnior
 */
public interface AlunoDao {

    /**
     * Obtém um aluno à partir do seu ID
     *
     * @param alunoId ID do aluno que deseja obter
     * @return Objeto do aluno
     */
    public Aluno getAlunoById(int alunoId);

    /**
     * Obtém uma lista com todos os alunos
     *
     * @return Lista de objetos Aluno
     */
    public ArrayList<Aluno> getAlunos();

    /**
     * Obtém um aluno à partir da sua matrícula
     *
     * @param matricula Matrícula do Aluno que deseja obter
     * @return Objeto do Aluno
     */
    public Aluno getAlunoByMatricula(long matricula);

    /**
     * Adiciona um novo aluno
     *
     * @param aluno Objeto aluno a ser adicionado
     * @throws exceptions.AlunoJaCadastradoException Caso o aluno já esteja
     * cadastrado
     * @throws java.io.IOException Caso não seja possível salvar no banco de
     * dados
     */
    public void adicionaAluno(Aluno aluno) throws AlunoJaCadastradoException, IOException;

    /**
     * Salva arquivo
     *
     * @throws java.io.IOException Caso não seja possível salvar o arquivo
     */
    public void saveFile() throws IOException;

}
