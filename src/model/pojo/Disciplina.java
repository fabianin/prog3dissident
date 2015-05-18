/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

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

    public void addTurma(Turma turma) {
        this.turmas.add(turma);
    }

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmenta() {
        return ementa;
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

    public long getCargaHoraria() {
        return cargaHoraria;
    }

}
