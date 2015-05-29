package model.pojo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elias Júnior
 */
public class NotaTest {

    @Test
    public void criaNota() {
        Nota nota = new Nota(10, 10, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void criaNotaErrado() {
        Nota nota = new Nota(-1, 10, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void defineNotaErrado() {
        Nota nota = new Nota(10, 10, 10);
        nota.setValorObtido(-10);
    }

    @Test
    public void defineNota() {
        Nota nota = new Nota(10, 10, 10);
        nota.setValorObtido(5);
        assertTrue(nota.getValorObtido() == 5);
    }

    @Test
    public void testeEquals() {
        Nota nota1 = new Nota(10, 10, 10);
        Nota nota2 = new Nota(10, 10, 10);
        Nota nota3 = new Nota(5, 10, 10);
        Nota nota4 = new Nota(10, 5, 10);
        Nota nota5 = new Nota(10, 10, 5);
        assertEquals(nota1, nota2);
        assertFalse(nota1.equals(nota3));
        assertFalse(nota1.equals(nota4));
        assertFalse(nota1.equals(nota5));
    }

}
