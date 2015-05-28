/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import exceptions.DisciplinaJaCadastradaException;
import exceptions.TurmaJaCadastradaException;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Fabiano
 */
public class Professor extends Pessoa {

    private final int id;
    private final String departamento;
    private final ArrayList<Integer> disciplinasApto;
    private final ArrayList<Integer> turmasLecionando;

    /**
     * Construtor do professor
     *
     * @param nome Nome do professor
     * @param cpf CPF do professor
     * @param departamento Departamento do professor
     */
    public Professor(String nome, long cpf, String departamento) {
        super(nome, cpf);
        this.departamento = departamento;
        this.id = this.hashCode();
        this.disciplinasApto = new ArrayList<>();
        this.turmasLecionando = new ArrayList<>();
    }

    /**
     * Obtém departamento do professor
     *
     * @return Departamento do professor
     */
    public String getDepartamento() {
        return this.departamento;
    }

    @Override
    public final int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.nome);
        hash = 41 * hash + Objects.hashCode(this.departamento);
        hash = 41 * hash + Objects.hashCode(this.disciplinasApto);
        hash = 41 * hash + Objects.hashCode(this.turmasLecionando);
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
        final Professor other = (Professor) obj;
        if (!Objects.equals(this.departamento, other.departamento)) {
            return false;
        }
        if (!Objects.equals(this.getNome(), other.getNome())) {
            return false;
        }
        if (this.getCpf() != other.getCpf()) {
            return false;
        }
        return true;
    }

    /**
     * Adiciona uma disciplina que o professor pode lecionar
     *
     * @param disciplina Disciplina que poderá lecionar
     * @throws IllegalArgumentException
     * @throws NullPointerException
     * @throws DisciplinaJaCadastradaException
     */
    public void addDisciplinaApto(Integer disciplina) throws IllegalArgumentException, NullPointerException, DisciplinaJaCadastradaException {
        if (this.disciplinasApto.contains(disciplina)) {
            throw new DisciplinaJaCadastradaException("Você não pode adicionar duas disciplinas iguais a um mesmo professor.");
        }
        this.disciplinasApto.add(disciplina);
    }

    /**
     * Adiciona uma turma ao professor
     *
     * @param turma Turma a ser adicionada
     * @throws IllegalArgumentException
     * @throws NullPointerException
     */
    public void addTurma(Integer turma) throws IllegalArgumentException, NullPointerException, TurmaJaCadastradaException {
        if (this.turmasLecionando.contains(turma)) {
            throw new TurmaJaCadastradaException("Você não pode adicionar duas turmas em um mesmo professor");
        } else {
            this.turmasLecionando.add(turma);
        }
    }

    /**
     * Obtém o número de disciplinas que esse professor leciona
     *
     * @return número de disciplinas
     */
    public int numDisciplinaLecionadas() {
        return this.turmasLecionando.size();
    }

    /**
     * Obtém as turmas apto
     *
     * @return lista de turma
     */
    public ArrayList<Integer> getDisciplinasApto() {
        return disciplinasApto;
    }

    /**
     * Obtém as turmas que leciona
     *
     * @return lista de turma
     */
    public ArrayList<Integer> getTurmasLecionando() {
        return turmasLecionando;
    }

    public void addTurmaLecionando(int turmaLecionandoId) throws TurmaJaCadastradaException {
        if (this.turmasLecionando.contains(turmaLecionandoId)) {
            throw new TurmaJaCadastradaException();
        } else {
            this.turmasLecionando.add(turmaLecionandoId);
        }
    }

    public int getId() {
        return this.id;
    }

}
