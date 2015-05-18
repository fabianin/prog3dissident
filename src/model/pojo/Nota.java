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
public class Nota {

    private final long matricula;
    private final float nota;

    public Nota(long matricula, float nota) {
        if (matricula < 0) {
            throw new IllegalArgumentException("Matrícula deve ser um valor positivo.");
        } else if (nota < 0) {
            throw new IllegalArgumentException("Nota deve ser um valor positivo.");
        }
        this.matricula = matricula;
        this.nota = nota;
    }

    public long getMatricula() {
        return this.matricula;
    }

    public float getNota() {
        return this.nota;
    }

}
