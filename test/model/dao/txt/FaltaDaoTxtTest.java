/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.txt;

import exceptions.FaltaJaCadastradaException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.FaltaDao;
import model.pojo.Falta;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elias Júnior
 */
public class FaltaDaoTxtTest {

    private final FaltaDao faltadao;

    public FaltaDaoTxtTest() {
        this.faltadao = new FaltaDaoTxt();
    }

    @Test
    public void testeDao() {
        Falta falta = new Falta(10, 10, 10);
        try {
            this.faltadao.addFalta(falta);
        } catch (FaltaJaCadastradaException ex) {
            System.out.println("Falta ja cadastrada");
        } catch (IOException ex) {
            System.out.println("Erro ao salvar arquivo");
        }
        assertTrue(this.faltadao.getFaltas().contains(falta));
        assertEquals(this.faltadao.getFaltaById(falta.hashCode()), falta);
        assertEquals(this.faltadao.getFaltaByIdAluno(10, 10), falta);
    }

}
