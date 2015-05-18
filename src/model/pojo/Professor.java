/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

/**
 *
 * @author Fabiano
 */
public class Professor extends Pessoa {

    private final String departamento;

    public Professor(String nome, long cpf, String departamento) {
        super(nome, cpf);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return this.departamento;
    }

}
