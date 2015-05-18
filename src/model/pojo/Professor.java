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
public class Professor extends Pessoa {

    private final String departamento;

    /**
     * Construtor do professor
     *
     * @param nome Nome do professor
     * @param cpf CPF do professor
     * @param departamento Departamento do professor
     */
    public Professor(String nome, long cpf, String departamento) {
        super(nome, cpf);
        Objects.requireNonNull(departamento, "Departamento não pode ser null.");
        if (departamento.isEmpty()) {
            throw new IllegalArgumentException("Departamento não pode estar vazio.");
        }
        this.departamento = departamento;
    }

    /**
     * Obtém departamento do professor
     *
     * @return Departamento do professor
     */
    public String getDepartamento() {
        return this.departamento;
    }

}
