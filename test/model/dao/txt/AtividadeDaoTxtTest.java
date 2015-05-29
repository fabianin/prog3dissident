package model.dao.txt;

import exceptions.AtividadeJaCadastradaException;
import java.io.IOException;
import java.util.Calendar;
import model.dao.AtividadeDao;
import model.pojo.Atividade;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elias Júnior
 */
public class AtividadeDaoTxtTest {

    private final AtividadeDao atividadedao;

    public AtividadeDaoTxtTest() {
        this.atividadedao = new AtividadeDaoTxt();
    }

    @Test
    public void testeDao() {
        Atividade atividade = new Atividade("Nome", Calendar.getInstance(), "Tipo");
        try {
            this.atividadedao.adicionarAtividade(atividade);
        } catch (AtividadeJaCadastradaException ex) {
            System.out.println("Atividade já cadastrada");
        } catch (IOException ex) {
            System.out.println("Problema ao salvar o arquivo");
        }
        assertTrue(this.atividadedao.getAtividades().contains(atividade));
        assertEquals(this.atividadedao.getAtividadeById(atividade.hashCode()), atividade);
    }

}
