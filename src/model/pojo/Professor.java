/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Fabiano
 */
public class Professor extends Pessoa {

    private final String departamento;
    private ArrayList<Disciplina> disciplinasApto;

    public Professor(String nome, long cpf, String departamento) {
        super(nome, cpf);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return this.departamento;
    }
    public void addDisciplinaApto(Disciplina disciplina)throws IllegalArgumentException, NullPointerException{
        Objects.requireNonNull(disciplina,"Não pode ser NULL");
        if(this.disciplinasApto.contains(disciplina)){
            throw new IllegalArgumentException("Disciplina já cadastrada nesse professor");
        }
        this.disciplinasApto.add(disciplina);
        
    }

}
