/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elias Júnior
 */
public class ProfessorTest {

    @Test
    public void criaProfessor() {
        Professor professor = new Professor("Nome", 123, "Teste");
    }

    @Test
    public void testeEquals() {
        Professor professor1 = new Professor("Nome", 123, "Teste");
        Professor professor2 = new Professor("Nome", 123, "Teste");
        Professor professor3 = new Professor("", 123, "Teste");
        Professor professor4 = new Professor("Nome", 1, "Teste");
        Professor professor5 = new Professor("Nome", 123, "");
        assertEquals(professor1, professor2);
        assertFalse(professor1.equals(professor3));
        assertFalse(professor1.equals(professor4));
        assertFalse(professor1.equals(professor5));
    }

}
