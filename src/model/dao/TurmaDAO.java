/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import exceptions.TurmaJaCadastradaException;
import java.util.ArrayList;
import java.util.Objects;
import model.pojo.Atividade;
import model.pojo.Disciplina;
import model.pojo.Turma;

/**
 *
 * @author Fabiano
 */
public class TurmaDAO {

    private final ArrayList<Turma> turmas;

    public TurmaDAO() {
        this.turmas = new ArrayList<>();
    }

    public void addTurma(Turma turma) throws IllegalArgumentException, NullPointerException, TurmaJaCadastradaException {
        Objects.requireNonNull(turma, "Tem de ser passado uma turma pro método");
        if (this.turmas.contains(turma)) {
            throw new IllegalArgumentException("Turma já cadastrada");

        } else {
            this.turmas.add(turma);
            turma.getProfessor().addTurma(turma);
            turma.getDisciplina().addTurma(turma);
        }
    }

    public void listarTurma(Disciplina disciplina, long ano, long periodo) {
        for (Turma x : turmas) {
            if (x.getDisciplina().equals(disciplina) && x.getAno() == ano && x.getPeriodo() == periodo) {
                System.out.println(x.getFaltas());
                for (Atividade k : x.getAtividades()) {
                    System.out.println(k.getNome());
                    System.out.println(k.getNotas());
                }
            }
        }
    }

}
