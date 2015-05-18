/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.util.ArrayList;

/**
 * Essa classe representa a entidade aluno e o ID de cada objeto será a prórpria
 * matircula do aluno
 *
 * @author Fabiano
 */
public class Aluno extends Pessoa {

    private final long matricula;
    private final ArrayList<Turma> turmas = new ArrayList<>();

    public Aluno(long matricula, String nome, long cpf) {
        super(nome, cpf);
        this.matricula = matricula;
    }

    public long getMatricula() {
        return matricula;
    }

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    @Override
    public String toString() {
        return "Aluno: " + this.getNome() + " CPF: " + this.getCpf() + " Matricula: " + this.getMatricula()
                + " Turmas: " + this.getTurmas() + "\r\n";
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Aluno other = (Aluno) obj;
        if (this.matricula != other.matricula) {
            return false;
        }
        return true;
    }
    

}
