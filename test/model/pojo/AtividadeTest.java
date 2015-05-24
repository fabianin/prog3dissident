/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.util.ArrayList;
import java.util.Calendar;
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
public class AtividadeTest {

    public AtividadeTest() {
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
     * Test of addNota method, of class Atividade.
     */
    @Test
    public void testAddNota() throws Exception {
        System.out.println("addNota");
        Nota nota = null;
        Atividade instance = null;
        if (instance != null) {
            instance.addNota(nota);
        }
    }

    /**
     * Test of getNotas method, of class Atividade.
     */
    @Test
    public void testGetNotas() {
        System.out.println("getNotas");
        Atividade instance = null;
        if (instance != null) {
            ArrayList<Nota> expResult = null;
            ArrayList<Nota> result = instance.getNotas();
            assertEquals(expResult, result);
        }
    }

    /**
     * Test of getNome method, of class Atividade.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Atividade instance = null;
        if (instance != null) {
            String expResult = "";
            String result = instance.getNome();
            assertEquals(expResult, result);
        }
    }

    /**
     * Test of getData method, of class Atividade.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        Atividade instance = null;
        if (instance != null) {
            Calendar expResult = null;
            Calendar result = instance.getData();
            assertEquals(expResult, result);
        }
    }

    /**
     * Test of getTipo method, of class Atividade.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        Atividade instance = null;
        if (instance != null) {
            String expResult = "";
            String result = instance.getTipo();
            assertEquals(expResult, result);
        }
    }

    /**
     * Test of hashCode method, of class Atividade.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Atividade instance = null;
        int expResult = 0;
        if (instance != null) {
            int result = instance.hashCode();
            assertEquals(expResult, result);
        }
    }

    /**
     * Test of equals method, of class Atividade.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Atividade instance = null;
        if (instance != null && obj != null) {
            boolean expResult = false;
            boolean result = instance.equals(obj);
            assertEquals(expResult, result);
        }
    }

    private void If(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
