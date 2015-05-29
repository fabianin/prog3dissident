package model.pojo;

import exceptions.TurmaJaCadastradaException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elias Júnior
 */
public class AlunoTest {

    @Test
    public void criaAluno() {
        Aluno aluno = new Aluno(10, "Teste", 34123421);
    }

    @Test(expected = IllegalArgumentException.class)
    public void criaAlunoMatriculaNegativa() {
        Aluno aluno = new Aluno(-1, "Teste", 1241421);
    }

    @Test
    public void alunosIguais() {
        Aluno aluno1 = new Aluno(10, "Teste", 12345);
        Aluno aluno2 = new Aluno(10, "Teste", 12345);
        Aluno aluno3 = new Aluno(11, "Teste", 12345);
        assertTrue(aluno1.equals(aluno2));
        assertFalse(aluno2.equals(aluno3));
        assertFalse(aluno1.equals(aluno3));
    }

    @Test
    public void adicionaTurma() throws TurmaJaCadastradaException {
        Aluno aluno = new Aluno(10, "Teste", 12345);
        aluno.addTurma(10);
    }

    @Test(expected = TurmaJaCadastradaException.class)
    public void adicionaTurmaRepetida() throws TurmaJaCadastradaException {
        Aluno aluno = new Aluno(10, "Teste", 12345);
        aluno.addTurma(10);
        aluno.addTurma(10);
    }

}
