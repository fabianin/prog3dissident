/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.txt;

import java.util.ArrayList;
import model.pojo.Aluno;
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
public class AlunoDaoTxtTest {

    public AlunoDaoTxtTest() {
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
     * Test of getAlunoByID method, of class AlunoDaoTxt.
     */
    @Test(expected = NullPointerException.class)
    public void testGetAlunoByID() {
        System.out.println("getAlunoByID");
        Integer id = null;
        AlunoDaoTxt instance = new AlunoDaoTxt();
        Aluno expResult = null;
        Aluno result = instance.getAlunoByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adicionaAluno method, of class AlunoDaoTxt.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAdicionaAluno() {
        System.out.println("adicionaAluno");
        Aluno aluno = null;
        AlunoDaoTxt instance = new AlunoDaoTxt();
        Class<IllegalArgumentException> expResult = IllegalArgumentException.class;
        instance.adicionaAluno(aluno);
    }

    /**
     * Test of getAlunos method, of class AlunoDaoTxt.
     */
    @Test
    public void testGetAlunos() {
        System.out.println("getAlunos");
        AlunoDaoTxt instance = new AlunoDaoTxt();
        ArrayList<Aluno> expResult = null;
        ArrayList<Aluno> result = instance.getAlunos();
        assertEquals(expResult, result);
    }

    /**
     * Test of removeAluno method, of class AlunoDaoTxt.
     */
    @Test
    public void testRemoveAluno() {
        System.out.println("removeAluno");
        Integer id = null;
        AlunoDaoTxt instance = new AlunoDaoTxt();
        boolean expResult = false;
        boolean result = instance.removeAluno(id);
        assertEquals(expResult, result);
    }

}
