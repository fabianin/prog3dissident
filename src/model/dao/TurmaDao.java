/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import model.pojo.Turma;

/**
 *
 * @author Elias Júnior
 */
public interface TurmaDao {

    public Turma getTurmaByID(Integer id);

    public ArrayList<Turma> getTurmasDeAluno(Integer id);

    public Integer adicionaTurma(Turma turma);

    public boolean removeTurma(Integer id);

}
