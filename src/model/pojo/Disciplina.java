/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

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

    public Disciplina(String nome, String ementa, long cargaHoraria) throws IllegalArgumentException {
        Objects.requireNonNull(nome, "Nome não pode ser vazio");
        Objects.requireNonNull(ementa, "Ementa não pode ser vazio.");
        if (cargaHoraria < 1) {
            throw new IllegalArgumentException("Carga horária não pode ser menor que 1.");
        }
        cont++;
        this.id = String.valueOf(cont);
        this.nome = nome;
        this.ementa = ementa;
        this.cargaHoraria = cargaHoraria;
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

    public long getCargaHoraria() {
        return cargaHoraria;
    }

}
