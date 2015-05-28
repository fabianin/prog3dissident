/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import exceptions.AlunoJaCadastradoException;
import exceptions.AtividadeJaCadastradaException;
import exceptions.FaltaJaCadastradaException;
import exceptions.ProfessorNaoAptoDisciplinaException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elias Júnior
 */
public class TurmaTest {

    @Test
    public void criaTurma() throws IllegalArgumentException, ProfessorNaoAptoDisciplinaException {
        Turma turma = new Turma(10, 10, 10, 10, 10, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void criaTurmaErrado() {
        Turma turma = new Turma(-1, -1, -1, -1, -1, -1);
    }

    @Test
    public void testeEquals() {
        Turma turma1 = new Turma(10, 10, 10, 10, 10, 10);
        Turma turma2 = new Turma(10, 10, 10, 10, 10, 10);
        Turma turma3 = new Turma(1, 10, 10, 10, 10, 10);
        Turma turma4 = new Turma(10, 1, 10, 10, 10, 10);
        Turma turma5 = new Turma(10, 10, 1, 10, 10, 10);
        Turma turma6 = new Turma(10, 10, 10, 1, 10, 10);
        Turma turma7 = new Turma(10, 10, 10, 10, 1, 10);
        Turma turma8 = new Turma(10, 10, 10, 10, 10, 1);
        assertEquals(turma1, turma2);
        assertFalse(turma1.equals(turma3));
        assertFalse(turma1.equals(turma4));
        assertFalse(turma1.equals(turma5));
        assertFalse(turma1.equals(turma6));
        assertFalse(turma1.equals(turma7));
        assertFalse(turma1.equals(turma8));
    }

    @Test
    public void addFalta() throws FaltaJaCadastradaException {
        Turma turma = new Turma(10, 10, 10, 10, 10, 10);
        turma.addFalta(10);
    }

    @Test(expected = FaltaJaCadastradaException.class)
    public void addFaltaRepetida() throws FaltaJaCadastradaException {
        Turma turma = new Turma(10, 10, 10, 10, 10, 10);
        turma.addFalta(10);
        turma.addFalta(10);
    }

    @Test
    public void addAluno() throws AlunoJaCadastradoException {
        Turma turma = new Turma(10, 10, 10, 10, 10, 10);
        turma.addAluno(10);
    }

    @Test(expected = AlunoJaCadastradoException.class)
    public void addAlunoRepetida() throws AlunoJaCadastradoException {
        Turma turma = new Turma(10, 10, 10, 10, 10, 10);
        turma.addAluno(10);
        turma.addAluno(10);
    }

    @Test
    public void addAtividade() throws AtividadeJaCadastradaException {
        Turma turma = new Turma(10, 10, 10, 10, 10, 10);
        turma.addAtividade(10);
    }

    @Test(expected = AtividadeJaCadastradaException.class)
    public void addAtividadeRepetida() throws AtividadeJaCadastradaException {
        Turma turma = new Turma(10, 10, 10, 10, 10, 10);
        turma.addAtividade(10);
        turma.addAtividade(10);
    }

}
