/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author Fabiano
 */
class Turma {

    private final int id;
    private final int periodo;
    private final int numeroVagas;
    private final int sala;
    private final Disciplina disciplina;
    private final Calendar ano;
    private final ArrayList<Atividade> atividades = new ArrayList<>();
    private final ArrayList<Aluno> alunos = new ArrayList<>();
    private final ArrayList<Falta> faltas = new ArrayList<>();
    private final ArrayList<Nota> notas = new ArrayList<>();
    private final Professor professor;

    public Turma(Disciplina disciplina, int periodo, int numeroVagas, int sala, Calendar ano, Professor professor)
            throws NullPointerException, IllegalArgumentException {
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
    public final int hashCode() {
        int hash = 3;
        hash = 13 * hash + this.id;
        hash = 13 * hash + this.periodo;
        hash = 13 * hash + this.numeroVagas;
        hash = 13 * hash + this.sala;
        hash = 13 * hash + Objects.hashCode(this.ano);
        hash = 13 * hash + Objects.hashCode(this.professor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) throws NullPointerException, IllegalArgumentException {
        if (obj == null) {
            throw new NullPointerException();
        }
        if (getClass() != obj.getClass()) {
            throw new IllegalArgumentException();
        }
        final Turma other = (Turma) obj;
        return other.getId() == this.getId();
    }

    public int getId() {
        return this.id;
    }

    public int getPeriodo() {
        return this.periodo;
    }

    public int getNumeroVagas() {
        return this.numeroVagas;
    }

    public int getSala() {
        return this.sala;
    }

    public Disciplina getDisciplina() {
        return this.disciplina;
    }

    public Calendar getAno() {
        return this.ano;
    }

    public ArrayList<Atividade> getAtividades() {
        return this.atividades;
    }

    public ArrayList<Aluno> getAlunos() {
        return this.alunos;
    }

    public ArrayList<Falta> getFaltas() {
        return this.faltas;
    }

    public ArrayList<Nota> getNotas() {
        return this.notas;
    }

    public Professor getProfessor() {
        return this.professor;
    }
    

    @Override
    public String toString() {
        return "Turma: "  + this.getId() + "\r\nPeriodo: " + this.getPeriodo() + "\r\nNumero de vagas: "
                + this.getNumeroVagas() + "\r\nSala: " + this.getSala() + "\r\nDisciplina: " + this.getDisciplina() 
                + "\r\nAno: " + this.getAno() + "\r\nAtividades: " + this.getAtividades() + "\r\nAlunos: " +
                this.getAlunos() + "\r\nFaltas: " + this.getFaltas() + "\r\nnotas: " + this.getNotas() +
                "\r\nProfessor=" + this.getProfessor();
    }

}
