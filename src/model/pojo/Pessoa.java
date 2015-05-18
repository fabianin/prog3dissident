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
public abstract class Pessoa {

    private final String nome;
    private final long cpf;

    /**
     * Construtor da pessoa
     *
     * @param nome Nome da pessoa
     * @param cpf CPF da pessoa
     * @throws IllegalArgumentException
     */
    public Pessoa(String nome, long cpf) throws IllegalArgumentException, NullPointerException {
        Objects.requireNonNull(nome, "Nome não pode ser null.");
        if (nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode estar vazio.");
        }
        this.nome = nome;
        this.cpf = cpf;
    }

    /**
     * Obtém nome da pessoa
     *
     * @return Nome da pessoa
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém CPFda pessoa
     *
     * @return CPF da pessoa
     */
    public long getCpf() {
        return cpf;
    }

}
