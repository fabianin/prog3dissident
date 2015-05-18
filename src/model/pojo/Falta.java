/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

/**
 *
 * @author Fabiano
 */
public class Falta {

    private final Aluno aluno;
    private final long numFaltas;

    public Falta(Aluno aluno, long numFaltas) {
        this.aluno = aluno;
        this.numFaltas = numFaltas;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public long getNumFaltas() {
        return numFaltas;
    }

}
