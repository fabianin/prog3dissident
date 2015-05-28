/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.txt;

import exceptions.DisciplinaJaCadastradaException;
import exceptions.TurmaJaCadastradaException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.DisciplinaDao;
import model.pojo.Disciplina;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elias Júnior
 */
public class DisciplinaDaoTxtTest {

    private final DisciplinaDao disciplinadao;

    public DisciplinaDaoTxtTest() {
        this.disciplinadao = new DisciplinaDaoTxt();
    }

    @Test
    public void testeDao() {
        Disciplina disciplina = new Disciplina("Nome", "Ementa", 100);
        try {
            this.disciplinadao.addDisciplina(disciplina);
        } catch (DisciplinaJaCadastradaException ex) {
            System.out.println("Disciplina já cadastrada");
        } catch (IOException ex) {
            System.out.println("Erro ao salvar o arquivo");
        }
        assertTrue(this.disciplinadao.getDisciplinas().contains(disciplina));
        assertEquals(this.disciplinadao.getDisciplinaById(disciplina.hashCode()), disciplina);
    }

}
