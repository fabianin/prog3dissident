/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import model.pojo.Professor;

/**
 *
 * @author Fabiano
 */
public class ProfessorDAO {
    ArrayList<Professor> professores = new ArrayList<>();
    
    public void addProfessor(Professor prof) throws IllegalArgumentException{
        if(professores.contains(prof)){
            throw new IllegalArgumentException("Professor já cadastrado.");
        }
        this.professores.add(prof);
    }
    
}
