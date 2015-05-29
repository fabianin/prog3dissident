package model.pojo;

import exceptions.DisciplinaJaCadastradaException;
import exceptions.ProfessorNaoAptoDisciplinaException;
import exceptions.TurmaJaCadastradaException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elias Júnior
 */
public class ProfessorTest {

    @Test
    public void criaProfessor() {
        Professor professor = new Professor("Nome", 123, "Teste");
    }

    @Test
    public void testeEquals() {
        Professor professor1 = new Professor("Nome", 123, "Teste");
        Professor professor2 = new Professor("Nome", 123, "Teste");
        Professor professor3 = new Professor("", 123, "Teste");
        Professor professor4 = new Professor("Nome", 1, "Teste");
        Professor professor5 = new Professor("Nome", 123, "");
        assertEquals(professor1, professor2);
        assertFalse(professor1.equals(professor3));
        assertFalse(professor1.equals(professor4));
        assertFalse(professor1.equals(professor5));
    }

    @Test
    public void adicionaDisciplina() throws IllegalArgumentException, DisciplinaJaCadastradaException {
        Professor professor = new Professor("Nome", 123, "Teste");
        professor.addDisciplinaApto(10);
        professor.addDisciplinaApto(11);
        assertTrue(professor.getDisciplinasApto().contains(10));
        assertTrue(professor.getDisciplinasApto().contains(11));
        assertFalse(professor.getDisciplinasApto().contains(12));
    }

    @Test(expected = DisciplinaJaCadastradaException.class)
    public void adicionaDisciplinaRepetida() throws IllegalArgumentException, DisciplinaJaCadastradaException {
        Professor professor = new Professor("Nome", 123, "Teste");
        professor.addDisciplinaApto(10);
        professor.addDisciplinaApto(10);
    }

    @Test(expected = TurmaJaCadastradaException.class)
    public void adicionaTurmaLecionandoIgual() throws TurmaJaCadastradaException, ProfessorNaoAptoDisciplinaException, IllegalArgumentException, DisciplinaJaCadastradaException {
        Professor professor = new Professor("Nome", 123, "Teste");
        professor.addTurmaLecionando(10);
        professor.addTurmaLecionando(10);
    }

}
