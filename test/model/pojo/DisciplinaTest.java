/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fabiano
 */
public class DisciplinaTest {
    
    public DisciplinaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addTurma method, of class Disciplina.
     */
    @Test
    public void testAddTurma() throws Exception {
        System.out.println("addTurma");
        Turma turma = null;
        Disciplina instance = null;
        instance.addTurma(turma);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTurmas method, of class Disciplina.
     */
    @Test
    public void testGetTurmas() {
        System.out.println("getTurmas");
        Disciplina instance = null;
        ArrayList<Turma> expResult = null;
        ArrayList<Turma> result = instance.getTurmas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNome method, of class Disciplina.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Disciplina instance = null;
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmenta method, of class Disciplina.
     */
    @Test
    public void testGetEmenta() {
        System.out.println("getEmenta");
        Disciplina instance = null;
        String expResult = "";
        String result = instance.getEmenta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Disciplina.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Disciplina instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Disciplina.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Disciplina instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCargaHoraria method, of class Disciplina.
     */
    @Test
    public void testGetCargaHoraria() {
        System.out.println("getCargaHoraria");
        Disciplina instance = null;
        long expResult = 0L;
        long result = instance.getCargaHoraria();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
