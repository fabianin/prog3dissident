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
public class FaltaTest {
    
    @Test
    public void criaFalta() {
        Falta falta = new Falta(10, 10, 10);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void criaFaltaErrada() {
        Falta falta = new Falta(10, -10, 10);
    }
    
    @Test
    public void testeEquals() {
        Falta falta1 = new Falta(10, 10, 10);
        Falta falta2 = new Falta(10, 10, 10);
        Falta falta3 = new Falta(10, 5, 10);
        Falta falta4 = new Falta(10, 10, 5);
        Falta falta5 = new Falta(5, 10, 10);
        assertEquals(falta1, falta2);
        assertFalse(falta1.equals(falta3));
        assertFalse(falta1.equals(falta4));
        assertFalse(falta1.equals(falta5));
    }
    
}
