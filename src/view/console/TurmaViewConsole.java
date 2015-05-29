package view.console;

import exceptions.ProfessorNaoAptoDisciplinaException;
import exceptions.TurmaJaCadastradaException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import model.dao.AlunoDao;
import model.dao.AtividadeDao;
import model.dao.DisciplinaDao;
import model.dao.FaltaDao;
import model.dao.NotaDao;
import model.dao.ProfessorDao;
import model.dao.TurmaDao;
import model.pojo.Aluno;
import model.pojo.Atividade;
import model.pojo.Disciplina;
import model.pojo.Falta;
import model.pojo.Nota;
import model.pojo.Professor;
import model.pojo.Turma;

/**
 *
 * @author Fabiano
 */
public class TurmaViewConsole {

    public static void consultaTurma(TurmaDao turmaDao, NotaDao notaDao, FaltaDao faltaDao, AlunoDao alunoDao, DisciplinaDao disciplinaDao, AtividadeDao atividadeDao) {

        Scanner sc = new Scanner(System.in);

        int disciplinaId;
        long ano;
        long periodo;

        System.out.print("Digite o ID da disciplina: ");
        disciplinaId = sc.nextInt();
        System.out.print("Digite o ano: ");
        ano = sc.nextLong();
        System.out.print("Digite o período: ");
        periodo = sc.nextLong();

        Disciplina disciplina = disciplinaDao.getDisciplinaById(disciplinaId);

        if (disciplina == null) {
            System.out.println("Disciplina inválida.");
        } else {
            List<Turma> turmas = turmaDao.getTurmas().stream().filter(t -> t.getDisciplina() == disciplinaId && t.getAno() == ano && t.getPeriodo() == periodo).collect(Collectors.toList());
            if (turmas.isEmpty()) {
                System.out.println("Não foi encontrado nenhuma disciplina.");
            } else {
                turmas.stream().forEach((turma) -> {
                    System.out.println("Informações da turma " + turma.hashCode());
                    turma.getAlunos().stream().forEach((alunoId) -> {
                        Aluno aluno = alunoDao.getAlunoById(alunoId);
                        Nota nota = notaDao.getNotaPorAlunoId(alunoId, turma.hashCode());
                        Falta falta = faltaDao.getFaltaByIdAluno(alunoId, turma.hashCode());
                        System.out.println("Aluno " + aluno.hashCode() + "(" + aluno.getNome() + "):");
                        if (nota == null) {
                            System.out.println("- Não há nota registrada");
                        } else {
                            System.out.println("- Nota: " + nota.getValorObtido());
                        }
                        if (falta == null) {
                            System.out.println("- Não há falta registrada");
                        } else {
                            System.out.println("- Faltas: " + falta.getFaltas());
                        }
                    });
                    if (turma.getAlunos().isEmpty()) {
                        System.out.println("Não há alunos matriculados");
                    }
                });
            }
        }

    }

    public static void cadastraTurma(TurmaDao turmas, DisciplinaDao disc, ProfessorDao professores) {

        long periodo, numeroVagas, sala, ano;
        int disciplina, professor;

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o peridoo: ");
        periodo = sc.nextLong();
        System.out.print("Digite o numero de vagas: ");
        numeroVagas = sc.nextLong();
        System.out.print("Digite o numero da sala: ");
        sala = sc.nextInt();
        System.out.print("Digite o ID da disciplina: ");
        disciplina = sc.nextInt();
        System.out.print("Digite o ano: ");
        ano = sc.nextInt();
        System.out.print("Digite o ID do professor: ");
        professor = sc.nextInt();

        Disciplina dd = disc.getDisciplinaById(disciplina);
        Professor pf = professores.getProfessorById(professor);

        if (dd == null) {
            System.out.println("Disciplina não cadastrada.");
        } else if (pf == null) {
            System.out.println("Professor não cadastrado.");
        } else {
            try {
                Turma turma = new Turma(disciplina, periodo, numeroVagas, sala, ano, professor);
                turmas.adicionarTurma(turma);
                professores.adicionarTurma(professor, turma.hashCode());
                professores.saveFile();
                System.out.println("Cadastrado com sucesso.");
            } catch (IOException ex) {
                System.out.println("Erro ao salvar o arquivo. Você poderá perder os dados.");
            } catch (TurmaJaCadastradaException ex) {
                System.out.println("Turma já cadastrada.");
            }
        }

    }

    public static void imprimiTurmas(TurmaDao turmas) {
        turmas.getTurmas().stream().forEach((x) -> System.out.println(x));
    }

}
