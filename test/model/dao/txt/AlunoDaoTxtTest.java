package model.dao.txt;

import exceptions.AlunoJaCadastradoException;
import java.io.IOException;
import model.dao.AlunoDao;
import model.pojo.Aluno;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elias Júnior
 */
public class AlunoDaoTxtTest {

    private final AlunoDao alunodao;

    public AlunoDaoTxtTest() {
        this.alunodao = new AlunoDaoTxt();
    }

    @Test
    public void testeDao() {
        Aluno aluno = new Aluno(10, "Teste", 10);
        try {
            this.alunodao.adicionaAluno(aluno);
        } catch (AlunoJaCadastradoException ex) {
            System.out.println("Aluno já está cadastrado");
        } catch (IOException ex) {
            System.out.println("Erro ao salvar o arquivo");
        }
        assertTrue(this.alunodao.getAlunos().contains(aluno));
        assertEquals(this.alunodao.getAlunoById(aluno.hashCode()), aluno);
    }

}
