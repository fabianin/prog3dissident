/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.Objects;
import model.pojo.Turma;

/**
 *
 * @author Fabiano
 */
public class TurmaDAO {

    private final ArrayList<Turma> turmas;

    public TurmaDAO() {
        this.turmas = new ArrayList<>();
    }
    
    public void addTurma(Turma turma) throws IllegalArgumentException, NullPointerException{
        Objects.requireNonNull(turma,"Tem de ser passado uma turma pro método");
        if(this.turmas.contains(turma)){
            throw new IllegalArgumentException("Turma já cadastrada");
            
        }
        else{
            this.turmas.add(turma);
        }
    }

}
