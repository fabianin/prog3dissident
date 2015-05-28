/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import exceptions.TurmaJaCadastradaException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elias Júnior
 */
public class DisciplinaTest {

    @Test
    public void criaDisciplina() {
        Disciplina disciplina = new Disciplina("Teste", "Teste", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void criaDisciplinaCargaHorariaErrado() {
        Disciplina disciplina1 = new Disciplina("Teste", "Teste", 0);
        Disciplina disciplina2 = new Disciplina("Teste", "Teste", -1);
    }

    @Test
    public void adicionaTurma() throws TurmaJaCadastradaException {
        Disciplina disciplina = new Disciplina("Teste", "Teste", 10);
        disciplina.addTurma(10);
    }

    @Test(expected = TurmaJaCadastradaException.class)
    public void adicionaTurmaRepetida() throws TurmaJaCadastradaException {
        Disciplina disciplina = new Disciplina("Teste", "Teste", 10);
        disciplina.addTurma(10);
        disciplina.addTurma(10);
    }

    @Test
    public void testeEquals() {
        Disciplina disciplina1 = new Disciplina("Teste", "Teste", 10);
        Disciplina disciplina2 = new Disciplina("Teste", "Teste", 10);
        Disciplina disciplina3 = new Disciplina("Teste", "Teste", 11);
        assertEquals(disciplina1, disciplina2);
        assertFalse(disciplina1.equals(disciplina3));
    }

}
