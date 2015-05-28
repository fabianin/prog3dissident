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
    private final String nome;
    private final String ementa;
    private final long cargaHoraria;
    private final ArrayList<Integer> turmas;
    private int id;

    /**
     * Construtor da disciplina
     *
     * @param nome Nome da disciplina
     * @param ementa Ementa da disciplina
     * @param cargaHoraria Carga horária da disciplina
     * @throws IllegalArgumentException
     */
    public Disciplina(String nome, String ementa, long cargaHoraria) throws IllegalArgumentException {
        if (cargaHoraria < 1) {
            throw new IllegalArgumentException("Carga horária não pode ser menor que 1.");
        }
        cont++;
        this.turmas = new ArrayList<>();
        this.nome = nome;
        this.ementa = ementa;
        this.cargaHoraria = cargaHoraria;
        this.id = this.hashCode();
    }

    /**
     * Adiciona uma turma na lista de turma
     *
     * @param turma Turma a ser adicionada
     * @throws exceptions.TurmaJaCadastradaException
     */
    public void addTurma(int turma) throws TurmaJaCadastradaException {
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
    public ArrayList<Integer> getTurmas() {
        return this.turmas;
    }

    @Override
    public String toString() {
        return "Disciplina{" + "\nNome: " + nome + "\nementa: " + ementa + "\ncargaHoraria: " + cargaHoraria + "\nturmas ID: " + turmas + "\nid: " + id + '}';
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

    /**
     * Obtém carga horária
     *
     * @return carga horária
     */
    public long getCargaHoraria() {
        return this.cargaHoraria;
    }

    @Override
    public final int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.ementa);
        hash = 67 * hash + (int) (this.cargaHoraria ^ (this.cargaHoraria >>> 32));
        hash = 67 * hash + Objects.hashCode(this.turmas);
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
        return this.getId() == other.getId();
    }

    public int getId() {
        return id;
    }

}
