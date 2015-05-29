package view.console;

import exceptions.FaltaJaCadastradaException;
import exceptions.TurmaNaoEncontradaException;
import java.io.IOException;
import java.util.Scanner;
import model.dao.AlunoDao;
import model.dao.FaltaDao;
import model.dao.TurmaDao;
import model.pojo.Aluno;
import model.pojo.Falta;
import model.pojo.Turma;

/**
 *
 * @author Elias Júnior
 */
public class FaltasViewConsole {

    /**
     * Cadastra uma falta
     *
     * @param faltaDao DAO falta
     * @param turmaDao DAO turma
     * @param alunoDao DAO aluno
     */
    public static void cadastraFalta(FaltaDao faltaDao, TurmaDao turmaDao, AlunoDao alunoDao) {

        Scanner sc = new Scanner(System.in);
        int alunoId, turmaId, faltas;

        System.out.println("∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎");
        System.out.println("∎∎∎∎∎∎∎∎∎∎∎ CADASTRO ATIVIDADE ∎∎∎∎∎∎∎∎∎∎∎");
        System.out.println("∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎");

        System.out.println("");
        System.out.print("Digite a quantidade de faltas: ");
        faltas = sc.nextInt();
        System.out.print("Digite o ID do aluno: ");
        alunoId = sc.nextInt();
        System.out.print("Digite o ID da turma: ");
        turmaId = sc.nextInt();

        try {
            Falta falta = new Falta(alunoId, faltas, turmaId);
            Aluno aluno = alunoDao.getAlunoById(alunoId);
            Turma turma = turmaDao.getTurmaById(turmaId);
            if (aluno == null) {
                System.out.println("Aluno inválido.");
            } else if (turma == null) {
                System.out.println("Turma inválida");
            } else {
                faltaDao.addFalta(falta);
                turmaDao.adicionarFalta(turmaId, falta.hashCode());
                turmaDao.saveFile();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (FaltaJaCadastradaException ex) {
            System.out.println("Falta já está cadastrada.");
        } catch (IOException ex) {
            System.out.println("Houve um erro ao salvar o arquivo.");
        } catch (TurmaNaoEncontradaException ex) {
            System.out.println("Turma não encontrada");
        }

    }

}
