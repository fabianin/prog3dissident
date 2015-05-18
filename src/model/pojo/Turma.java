/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author Fabiano
 */
public class Turma {

    private final String id;
    private final int periodo;
    private final int numeroVagas;
    private final int sala;
    private final Disciplina disciplina;
    private final Calendar ano;
    private final ArrayList<Atividade> atividades = new ArrayList<>();
    private final ArrayList<Aluno> alunos = new ArrayList<>();
    private final ArrayList<Falta> faltas = new ArrayList<>();
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
        this.id = UUID.randomUUID().toString();
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + this.periodo;
        hash = 97 * hash + this.sala;
        hash = 97 * hash + Objects.hashCode(this.disciplina);
        hash = 97 * hash + Objects.hashCode(this.ano);
        hash = 97 * hash + Objects.hashCode(this.professor);
        return hash;
    }

    public String getId() {
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

    /** Recebe um aluno e retorna o numero de falta desse aluno
     * na referida turma
     *
     * @param aluno
     * @return
     * @throws IllegalArgumentException
     */
    public long getFaltas(Aluno aluno) throws IllegalArgumentException {
        for (Falta falta : this.getFaltas()) {
            if (aluno.equals(falta.getAluno())) {
                return falta.getFaltas();
            }
        }
        throw new IllegalArgumentException("Aluno não existe.");
    }

    public Professor getProfessor() {
        return this.professor;
    }

    @Override
    public String toString() {
        return "Turma: " + this.getId() + "\r\nPeriodo: " + this.getPeriodo() + "\r\nNumero de vagas: "
                + this.getNumeroVagas() + "\r\nSala: " + this.getSala() + "\r\nDisciplina: " + this.getDisciplina()
                + "\r\nAno: " + this.getAno() + "\r\nAtividades: " + this.getAtividades() + "\r\nAlunos: "
                + this.getAlunos() + "\r\nFaltas: " + this.getFaltas() + "\r\nProfessor=" + this.getProfessor();
    }

    /** Retorna a média do aluno na turma
     *
     * @param aluno
     * @return média do aluno na turma
     */
    public double getMedia(Aluno aluno) throws IllegalArgumentException {
        double total = 0.0;
        if (this.getAlunos().contains(aluno)) {
            for (Atividade atividade : this.getAtividades()) {
                for (Nota nota : atividade.getNotas()) {
                    if (nota.getAluno().equals(aluno)) {
                        total += nota.getValorObtido();
                    }
                }
            }
            return total / this.getAtividades().size();
        }
        throw new IllegalArgumentException("Aluno não encontrado");
    }

}
