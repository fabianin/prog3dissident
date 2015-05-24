/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import exceptions.AlunoJaCadastradoException;
import exceptions.AtividadeJaCadastradaException;
import exceptions.FaltaJaCadastradaException;
import exceptions.ProfessorNaoAptoDisciplinaException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author Fabiano
 */
public class Turma {

    private final long periodo;
    private final long numeroVagas;
    private final long sala;
    private final int disciplina;
    private final long ano;
    private final ArrayList<Integer> atividades = new ArrayList<>();
    private final ArrayList<Integer> alunos = new ArrayList<>();
    private final ArrayList<Integer> faltas = new ArrayList<>();
    private final int professor;
    private final int id;

    /**
     * Construtor de uma turma
     *
     * @param disciplina Disciplina para a turma
     * @param periodo Período da turma
     * @param numeroVagas Número de vagas da turma
     * @param sala Sala da turma
     * @param ano Ano da turma
     * @param professor Professor da turma
     * @throws NullPointerException
     * @throws IllegalArgumentException
     */
    public Turma(int disciplina, long periodo, long numeroVagas, long sala, long ano, int professor)
            throws NullPointerException, IllegalArgumentException, ProfessorNaoAptoDisciplinaException {
        Objects.requireNonNull(ano, "Ano não pode ser null");
        Objects.requireNonNull(professor, "Professor não pode ser null");
        Objects.requireNonNull(disciplina, "Disciplina não pode ser NULL");
        if (periodo < 1) {
            throw new IllegalArgumentException("Período não pode ser menor que 1");
        } else if (numeroVagas < 0) {
            throw new IllegalArgumentException("Numero de vagas não pode ser negativo");
        } else if (sala < 1) {
            throw new IllegalArgumentException("Sala não pode ser menor que 1");
        } else if (numeroVagas < 1) {
            throw new IllegalArgumentException("Numero de vagas não pode ser 0 ou negativo");
        }
        this.disciplina = disciplina;
        this.periodo = periodo;
        this.numeroVagas = numeroVagas;
        this.sala = sala;
        this.ano = ano;
        this.professor = professor;
        this.id = this.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Turma other = (Turma) obj;
        if (this.periodo != other.periodo) {
            return false;
        }
        if (this.numeroVagas != other.numeroVagas) {
            return false;
        }
        if (this.sala != other.sala) {
            return false;
        }
        if (!Objects.equals(this.disciplina, other.disciplina)) {
            return false;
        }
        if (this.ano != other.ano) {
            return false;
        }
        return (this.hashCode() == other.hashCode());
    }

    /**
     * Obtém o período da turma
     *
     * @return período da turma
     */
    public long getPeriodo() {
        return this.periodo;
    }

    /**
     * Obtém o número de vagas da turma
     *
     * @return número de vagas da turma
     */
    public long getNumeroVagas() {
        return this.numeroVagas;
    }

    /**
     * Obtém o número da sala
     *
     * @return número da sala
     */
    public long getSala() {
        return this.sala;
    }

    /**
     * Obtém a disciplina da turma
     *
     * @return disciplina
     */
    public Integer getDisciplina() {
        return this.disciplina;
    }

    /**
     * Obtém o ano da turma
     *
     * @return ano
     */
    public long getAno() {
        return this.ano;
    }

    /**
     * Obtém atividades da turma
     *
     * @return lista de atividade
     */
    public ArrayList<Integer> getAtividades() {
        return this.atividades;
    }

    /**
     * Obtém alunos matriculados na turma
     *
     * @return lista de aluno
     */
    public ArrayList<Integer> getAlunos() {
        return this.alunos;
    }

    /**
     * Obtém lista de faltas
     *
     * @return lista de falta
     */
    public ArrayList<Integer> getFaltas() {
        return this.faltas;
    }

    /**
     * Obtém o professor da turma
     *
     * @return professor
     */
    public Integer getProfessor() {
        return this.professor;
    }

    @Override
    public final int hashCode() {
        int hash = 5;
        hash = 13 * hash + (int) (this.periodo ^ (this.periodo >>> 32));
        hash = 13 * hash + (int) (this.numeroVagas ^ (this.numeroVagas >>> 32));
        hash = 13 * hash + (int) (this.sala ^ (this.sala >>> 32));
        hash = 13 * hash + Objects.hashCode(this.disciplina);
        hash = 13 * hash + (int) (this.ano ^ (this.ano >>> 32));
        hash = 13 * hash + Objects.hashCode(this.professor);
        return hash;
    }

    /**
     * MODIFICAR DEPOIS O THROWS
     *
     * @param faltaId
     */
    public void addFalta(int faltaId) throws FaltaJaCadastradaException {
        if (this.faltas.contains(faltaId)) {
            throw new FaltaJaCadastradaException();
        } else {
            this.faltas.add(faltaId);
        }
    }

    /**
     * MODIFICAR DEPOIS O THROWS
     *
     * @param alunoId
     */
    public void addAluno(int alunoId) throws AlunoJaCadastradoException {
        if (this.alunos.contains(alunoId)) {
            throw new AlunoJaCadastradoException();
        } else {
            this.alunos.add(alunoId);
        }
    }

    /**
     * MODIFICAR DEPOIS O THROWS
     *
     * @param atividadeId
     */
    public void addAtividade(int atividadeId) throws AtividadeJaCadastradaException {
        if (this.atividades.contains(atividadeId)) {
            throw new AtividadeJaCadastradaException();
        } else {
            this.atividades.add(atividadeId);
        }
    }

}
