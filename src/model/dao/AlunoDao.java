/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
     * @param alunoId
     * @return
     */
    public Aluno getAlunoById(int alunoId);

    /**
     * Obtém uma lista com todos os alunos
     *
     * @return
     */
    public ArrayList<Aluno> getAlunos();

    /**
     * Obtém um aluno à partir da sua matrícula
     *
     * @param matricula
     * @return
     */
    public Aluno getAlunoByMatricula(long matricula);

    /**
     * Adiciona um novo aluno
     *
     * @param aluno
     */
    public void adicionaAluno(Aluno aluno) throws AlunoJaCadastradoException;

    /**
     * Salva arquivo
     */
    public void saveFile() throws IOException;

}
