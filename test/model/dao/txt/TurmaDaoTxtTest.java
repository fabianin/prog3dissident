/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.txt;

import exceptions.AtividadeJaCadastradaException;
import exceptions.FaltaJaCadastradaException;
import exceptions.TurmaJaCadastradaException;
import exceptions.TurmaNaoEncontradaException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.TurmaDao;
import model.pojo.Turma;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elias Júnior
 */
public class TurmaDaoTxtTest {

    private final TurmaDao turmadao;

    public TurmaDaoTxtTest() {
        this.turmadao = new TurmaDaoTxt();
    }

    @Test
    public void testeDao() {
        Turma turma = new Turma(10, 10, 10, 1, 10, 10);
        try {
            try {
                this.turmadao.adicionarTurma(turma);
            } catch (TurmaJaCadastradaException ex) {
                System.out.println("Turma já cadastrada");
            } catch (IOException ex) {
                System.out.println("Erro ao salvar");
            }
            this.turmadao.adicionarAtividade(turma.hashCode(), 100);
        } catch (AtividadeJaCadastradaException ex) {
            System.out.println("Atividade já cadastrada");
        } catch (TurmaNaoEncontradaException ex) {
            System.out.println("Turma não encontrada");
        } catch (IOException ex) {
            System.out.println("Erro ao salvar");
        }
        try {
            this.turmadao.adicionarFalta(turma.hashCode(), 100);
        } catch (FaltaJaCadastradaException ex) {
            System.out.println("Falta já cadastrada");
        } catch (TurmaNaoEncontradaException ex) {
            System.out.println("Turma não encontrada");
        } catch (IOException ex) {
            System.out.println("Erro ao salvar");
        }
        assertTrue(this.turmadao.getTurmas().contains(turma));
        assertEquals(this.turmadao.getTurmaById(turma.hashCode()), turma);
    }

}
