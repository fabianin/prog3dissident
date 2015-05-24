/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

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
    private final Disciplina disciplina;
    private final long ano;
    private final ArrayList<Atividade> atividades = new ArrayList<>();
    private final ArrayList<Aluno> alunos = new ArrayList<>();
    private final ArrayList<Falta> faltas = new ArrayList<>();
    private final Professor professor;

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
    public Turma(Disciplina disciplina, long periodo, long numeroVagas, long sala, long ano, Professor professor)
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
        } else if (!professor.getDisciplinasApto().contains(disciplina)) {
            throw new ProfessorNaoAptoDisciplinaException("Este professor não está apto a dar essa disciplina.");
        }
        this.disciplina = disciplina;
        this.periodo = periodo;
        this.numeroVagas = numeroVagas;
        this.sala = sala;
        this.ano = ano;
        this.professor = professor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
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
        if (!Objects.equals(this.professor, other.professor)) {
            return false;
        }
        return true;
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
    public Disciplina getDisciplina() {
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
    public ArrayList<Atividade> getAtividades() {
        return this.atividades;
    }

    /**
     * Obtém alunos matriculados na turma
     *
     * @return lista de aluno
     */
    public ArrayList<Aluno> getAlunos() {
        return this.alunos;
    }

    /**
     * Obtém lista de faltas
     *
     * @return lista de falta
     */
    public ArrayList<Falta> getFaltas() {
        return this.faltas;
    }

    /**
     * Recebe um aluno e retorna o numero de falta desse aluno na referida turma
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

    /**
     * Obtém o professor da turma
     *
     * @return professor
     */
    public Professor getProfessor() {
        return this.professor;
    }

    @Override
    public String toString() {
        return "Turma: \r\nPeriodo: " + this.getPeriodo() + "\r\nNumero de vagas: "
                + this.getNumeroVagas() + "\r\nSala: " + this.getSala() + "\r\nDisciplina: " + this.getDisciplina()
                + "\r\nAno: " + this.getAno() + "\r\nAtividades: " + this.getAtividades() + "\r\nAlunos: "
                + this.getAlunos() + "\r\nFaltas: " + this.getFaltas() + "\r\nProfessor=" + this.getProfessor();
    }

    /**
     * Retorna a média do aluno na turma
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

    /** @brief método que formata o objeto para ser salvo em arquivo
     *
     * @return na sequencia Alunos, Ano, Atividades, Disciplina, Faltas, Numero de vagas, Periodo, Professor, Sala
     */
    public String toFile() {
        String str = "";
        str = this.getAlunos().stream().map((x) -> x.toFile()+"#").reduce(str, String::concat);
        str+=this.getAno()+";";
        str = this.getAtividades().stream().map((x) -> x.toFile()+"#").reduce(str, String::concat);
        str+=this.getDisciplina()+";";
        str = this.getFaltas().stream().map((x) -> x.toFile()+"#").reduce(str, String::concat);
        str+= this.getNumeroVagas()+";"+this.getPeriodo()+";"+this.getProfessor().toFile()+";"+this.getSala()+"%";
        return str;
    }

}
