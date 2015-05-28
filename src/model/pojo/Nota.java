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

    private final int id;

    private double valorObtido;
    private final int aluno;
    private final int turma;

    /**
     * Construtor da nota
     *
     * @param valorObtido Valor obtido
     * @param aluno Aluno da nota
     * @param turma ID da turma
     * @throws IllegalArgumentException
     */
    public Nota(double valorObtido, int aluno, int turma) throws IllegalArgumentException {
        if (valorObtido < 0 || valorObtido > 10) {
            throw new IllegalArgumentException("Valor obtido deve ser entre 0 e 10.");
        }
        this.valorObtido = valorObtido;
        this.aluno = aluno;
        this.id = this.hashCode();
        this.turma = turma;
    }

    /**
     * Obtém o valor
     *
     * @return Valor obtido
     */
    public double getValorObtido() {
        return valorObtido;
    }

    public void setValorObtido(double valorObtido) throws IllegalArgumentException {
        if (valorObtido < 0 || valorObtido > 10) {
            throw new IllegalArgumentException("Valor obtido deve ser entre 0 e 10.");
        }
        this.valorObtido = valorObtido;
    }

    public int getTurma() {
        return turma;
    }

    @Override
    public String toString() {
        return "valor Obtido = " + valorObtido + "\r\n";
    }

    @Override
    public final int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.valorObtido) ^ (Double.doubleToLongBits(this.valorObtido) >>> 32));
        hash = 67 * hash + Objects.hashCode(this.aluno);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Nota other = (Nota) obj;
        if (Double.doubleToLongBits(this.valorObtido) != Double.doubleToLongBits(other.valorObtido)) {
            return false;
        }
        if (this.aluno != other.aluno) {
            return false;
        }
        if (this.turma != other.turma) {
            return false;
        }
        return true;
    }

    /**
     * Obtém o aluno
     *
     * @return Aluno
     */
    public int getAluno() {
        return aluno;
    }

}
