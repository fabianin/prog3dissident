package model.pojo;

import exceptions.NotaJaCadastradaException;
import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elias Júnior
 */
public class AtividadeTest {

    @Test
    public void criaAtividade() {
        Atividade atividade = new Atividade("Elias", Calendar.getInstance(), "Teste");
    }

    @Test
    public void adicionarNota() throws NotaJaCadastradaException {
        Atividade atividade = new Atividade("Elias", Calendar.getInstance(), "Teste");
        atividade.addNota(10);
    }

    @Test(expected = NotaJaCadastradaException.class)
    public void adicionarNotaRepetida() throws NotaJaCadastradaException {
        Atividade atividade = new Atividade("Elias", Calendar.getInstance(), "Teste");
        atividade.addNota(10);
        atividade.addNota(10);
    }

    @Test
    public void testeEquals() {
        Atividade atividade1 = new Atividade("Teste", Calendar.getInstance(), "Teste");
        Atividade atividade2 = new Atividade("Teste", Calendar.getInstance(), "Teste");
        Atividade atividade3 = new Atividade("Algo", Calendar.getInstance(), "Teste");
        assertEquals(atividade1, atividade2);
        assertFalse(atividade1.equals(atividade3));
        assertFalse(atividade2.equals(atividade3));
    }

}
