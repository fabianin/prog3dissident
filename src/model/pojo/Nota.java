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
public class Nota {
    private final double valorObtido;
    private final Aluno aluno;

    public Nota(double valorObtido, Aluno aluno) throws IllegalArgumentException {
        if(valorObtido<0 || valorObtido >10){
            throw new IllegalArgumentException();
        }
        this.valorObtido = valorObtido;
        this.aluno = aluno;
    }

    public double getValorObtido() {
        return valorObtido;
    }

    public Aluno getAluno() {
        return aluno;
    }
    
    
}
