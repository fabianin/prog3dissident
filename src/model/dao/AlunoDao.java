/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import model.pojo.Aluno;

/**
 *
 * @author Elias Júnior
 */
public interface AlunoDao {

    public Aluno getAlunoByID(Integer id);

    public Integer adicionaAluno(Aluno aluno);

    public ArrayList<Aluno> getAlunos();

    public boolean removeAluno(Integer id);

}
