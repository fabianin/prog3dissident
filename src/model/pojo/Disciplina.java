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
 *
 * @author Fabiano
 */
public class Disciplina {

    private static long cont;
    private final String id;
    private final String nome;
    private final String ementa;
    private final long cargaHoraria;
    private final ArrayList<Turma> turmas;

    /**
     * Construtor da disciplina
     *
     * @param nome Nome da disciplina
     * @param ementa Ementa da disciplina
     * @param cargaHoraria Carga horária da disciplina
     * @throws IllegalArgumentException
     */
    public Disciplina(String nome, String ementa, long cargaHoraria) throws IllegalArgumentException {
        Objects.requireNonNull(nome, "Nome não pode ser vazio");
        Objects.requireNonNull(ementa, "Ementa não pode ser vazio.");
        if (cargaHoraria < 1) {
            throw new IllegalArgumentException("Carga horária não pode ser menor que 1.");
        }
        cont++;
        this.turmas = new ArrayList<>();
        this.id = String.valueOf(cont);
        this.nome = nome;
        this.ementa = ementa;
        this.cargaHoraria = cargaHoraria;
    }

    /**
     * Adiciona uma turma na lista de turma
     *
     * @param turma Turma a ser adicionada
     * @throws exceptions.TurmaJaCadastradaException
     */
    public void addTurma(Turma turma) throws TurmaJaCadastradaException {
        Objects.requireNonNull(turma, "Turma não pode ser null.");
        if (!this.turmas.contains(turma)) { // caso a turma não exista nesta disciplina
            this.turmas.add(turma);
        } else {
            throw new TurmaJaCadastradaException("Você não pode cadastrar duas turmas em uma mesma disciplina.");
        }
    }

    /**
     * Obtém a lista de turmas
     *
     * @return lista de turmas
     */
    public ArrayList<Turma> getTurmas() {
        return this.turmas;
    }

    /**
     * Obtém ID
     *
     * @return obtém id
     */
    public String getId() {
        return this.id;
    }

    /**
     * Obtém nome
     *
     * @return nome
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Obtém ementa
     *
     * @return ementa
     */
    public String getEmenta() {
        return this.ementa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Disciplina other = (Disciplina) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.ementa, other.ementa)) {
            return false;
        }
        if (this.cargaHoraria != other.cargaHoraria) {
            return false;
        }
        return true;
    }

    /**
     * Obtém carga horária
     *
     * @return carga horária
     */
    public long getCargaHoraria() {
        return this.cargaHoraria;
    }

}
