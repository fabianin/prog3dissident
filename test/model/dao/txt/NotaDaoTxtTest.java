package model.dao.txt;

import exceptions.NotaJaCadastradaException;
import java.io.IOException;
import model.dao.NotaDao;
import model.pojo.Nota;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elias Júnior
 */
public class NotaDaoTxtTest {

    private final NotaDao notadao;

    public NotaDaoTxtTest() {
        this.notadao = new NotaDaoTxt();
    }

    @Test
    public void testeDao() {
        Nota nota = new Nota(10, 10, 10);
        try {
            this.notadao.adicionaNota(nota);
        } catch (NotaJaCadastradaException ex) {
            System.out.println("Nota ja cadastrada");
        } catch (IOException ex) {
            System.out.println("Erro ao salvar arquivo");
        }
        assertTrue(this.notadao.getNotas().contains(nota));
        assertEquals(this.notadao.getNotaPorId(nota.hashCode()), nota);
        assertEquals(this.notadao.getNotaPorAlunoId(10, 10), nota);
    }

}
