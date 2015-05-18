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
public class Falta {

    private final Aluno aluno;
    private final int faltas;

    public Falta(Aluno aluno, int faltas) throws IllegalArgumentException, NullPointerException {
        if (faltas < 0) {
            throw new IllegalArgumentException("Faltas deve ser um valor positivo.");
        } else if (aluno == null) {
            throw new NullPointerException("Aluno não pode ser null.");
        }
        this.aluno = aluno;
        this.faltas = faltas;
    }

    public int getFaltas() {
        return this.faltas;
    }

    @Override
    public String toString() {
        return "Nome: " + aluno.getNome() +"\r\nfaltas=" + faltas +"\r\n";
    }

    public Aluno getAluno() {
        return aluno;
    }

}
