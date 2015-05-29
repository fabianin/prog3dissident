/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
            List<Turma> turmas = turmaDao.getTurmas().stream().filter(turma -> (turma.getAno() == ano && turma.getPeriodo() == periodo && turma.getDisciplina() == disciplinaId)).collect(Collectors.toList());
            if (turmas.size() > 0) {
                System.out.println("Listando turmas encontradas: ");
                for (Turma turma : turmas) {
                    System.out.println("\tExibindos dados da turma " + turma.hashCode());
                    ArrayList<Integer> alunosIds = turma.getAlunos();
                    ArrayList<Integer> atividadesIds = turma.getAtividades();
                    ArrayList<Integer> faltasIds = turma.getFaltas();
                    for (int alunoId : alunosIds) {
                        Aluno aluno = alunoDao.getAlunoById(alunoId);
                        System.out.println("\t\tAluno " + alunoId);
                        System.out.println("\t\t\tFaltas: ");
                        for (int faltaId : faltasIds) {
                            Falta falta = faltaDao.getFaltaById(faltaId);
                            if (falta.getAluno() == alunoId) {
                                System.out.println("\t\t\t\t: " + falta.getFaltas());
                            }
                        }
                        System.out.println("\t\t\tNotas: ");
                        for (int atividadeId : atividadesIds) {
                            System.out.println("\t\t\t\tAtividade: " + atividadeId);
                            Atividade atividade = atividadeDao.getAtividadeById(atividadeId);
                            for (int notaId : atividade.getNotas()) {
                                Nota nota = notaDao.getNotaPorId(notaId);
                                if (nota.getAluno() == alunoId) {
                                    System.out.println("\t\t\t\t" + nota.getValorObtido());
                                }
                            }
                        }
                    }
                }
            } else {
                System.out.println("Não foi encontrado nenhuma disciplina.");
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
