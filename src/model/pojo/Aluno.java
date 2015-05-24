/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import exceptions.TurmaJaCadastradaException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Essa classe representa a entidade aluno e o ID de cada objeto será a própria
 * matrícula do aluno
 *
 * @author Fabiano
 */
public class Aluno extends Pessoa {

    private final long matricula;   
    private final ArrayList<Integer> turmas;

    /**
     * Construtor do aluno
     *
     * @param matricula Número da matrícula
     * @param nome Nome do aluno
     * @param cpf CPF do aluno
     * @throws IllegalArgumentException
     * @throws NullPointerException
     */
    public Aluno(long matricula, String nome, long cpf) throws IllegalArgumentException {
        super(nome, cpf);
        if (matricula < 0) {
            throw new IllegalArgumentException("Matrícula deve ser positivo.");
        }
        this.matricula = matricula;
        this.turmas = new ArrayList<>();
    }

    /**
     * Obtém a matrícula do aluno
     *
     * @return Matrícula do aluno
     */
    public long getMatricula() {
        return matricula;
    }

    /**
     * Obtém uma lista de turma
     *
     * @return Lista de turmas
     */
    public ArrayList<Integer> getTurmas() {
        return this.turmas;
    }

    /**
     * Adicionar turma em um aluno
     *
     * @param turma turma a ser cadastrado
     * @throws TurmaJaCadastradaException
     */
    public void addTurma(Integer turma) throws TurmaJaCadastradaException {
        if (!this.turmas.contains(turma)) {
            this.turmas.add(turma);
        } else {
            throw new TurmaJaCadastradaException("Turma já está cadastrada.");
        }
    }

    @Override
    public String toString() {
        String str = "Aluno: \n " + "matricula: " + this.getMatricula() + "\n nome: " + this.getNome() + "\n cpf: " + this.getCpf();
        return str;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (int) (this.matricula ^ (this.matricula >>> 32));
        hash = 19 * hash + Objects.hashCode(this.turmas);
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
        if (this.hashCode() != other.hashCode()) {
            return false;
        }
        return true;
    }

}
