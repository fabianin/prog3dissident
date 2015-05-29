package model.dao.txt;

import exceptions.ProfessorJaCadastradoException;
import exceptions.TurmaJaCadastradaException;
import java.io.IOException;
import model.dao.ProfessorDao;
import model.pojo.Professor;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elias Júnior
 */
public class ProfessorDaoTxtTest {

    private final ProfessorDao professordao;

    public ProfessorDaoTxtTest() {
        this.professordao = new ProfessorDaoTxt();
    }

    @Test
    public void testeDao() {
        Professor professor = new Professor("Nome", 100, "Departamento");
        try {
            this.professordao.adicionaProfessor(professor);
        } catch (ProfessorJaCadastradoException ex) {
            System.out.println("Professor já cadastrado");
        } catch (IOException ex) {
            System.out.println("Erro ao salvar o arquivo");
        }
        assertTrue(this.professordao.getProfessores().contains(professor));
        assertEquals(this.professordao.getProfessorById(professor.hashCode()), professor);
        try {
            this.professordao.adicionarTurma(professor.hashCode(), 10);
        } catch (TurmaJaCadastradaException ex) {
            System.out.println("Turma já cadastrada");
        } catch (IOException ex) {
            System.out.println("Erro ao salvar o arquivo");
        }
        assertTrue(this.professordao.getProfessorById(professor.hashCode()).getTurmasLecionando().contains(10));
    }

}
