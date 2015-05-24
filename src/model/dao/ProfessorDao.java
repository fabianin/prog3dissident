/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    public Professor getProfessorById(int id);

    public ArrayList<Professor> getProfessores();

    public void adicionaProfessor(Professor professor) throws ProfessorJaCadastradoException, IOException;

    public void saveFile() throws IOException;
    
    public void adicionarTurma(int professorId, int turmaId) throws IllegalArgumentException, NullPointerException, TurmaJaCadastradaException;

}
