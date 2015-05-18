/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.util.Objects;

/**
 *
 * @author Fabiano
 */
public class Nota {

    private final double valorObtido;
    private final Aluno aluno;

    /**
     * Construtor da nota
     *
     * @param valorObtido Valor obtido
     * @param aluno Aluno da nota
     * @throws IllegalArgumentException
     */
    public Nota(double valorObtido, Aluno aluno) throws IllegalArgumentException {
        Objects.requireNonNull(aluno, "Aluno não pode ser null.");
        if (valorObtido < 0 || valorObtido > 10) {
            throw new IllegalArgumentException("Valor obtido deve ser entre 0 e 10.");
        }
        this.valorObtido = valorObtido;
        this.aluno = aluno;
    }

    /**
     * Obtém o valor
     *
     * @return Valor obtido
     */
    public double getValorObtido() {
        return valorObtido;
    }

    @Override
    public String toString() {
        return "valor Obtido = " + valorObtido + "\r\n";
    }

    /**
     * Obtém o aluno
     *
     * @return Aluno
     */
    public Aluno getAluno() {
        return aluno;
    }

}
