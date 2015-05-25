/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.console;

import exceptions.AlunoJaCadastradoException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.AlunoDao;
import model.dao.AtividadeDao;
import model.dao.DisciplinaDao;
import model.dao.FaltaDao;
import model.dao.NotaDao;
import model.dao.TurmaDao;
import model.dao.txt.AlunoDaoTxt;
import model.pojo.Aluno;
import model.pojo.Atividade;
import model.pojo.Disciplina;
import model.pojo.Falta;
import model.pojo.Nota;
import model.pojo.Turma;

/**
 *
 * @author Fabiano
 */
public class AlunoViewConsole {

    private Object alunos;

    public AlunoViewConsole() {
    }

    public static void imprimirAlunos(AlunoDao alunos) {
        alunos.getAlunos().stream().forEach((x) -> System.out.println(x));
    }

    public static void cadastraAluno(AlunoDao alunos) {

        Scanner sc = new Scanner(System.in);
        String nome;
        long cpf;
        long matricula;

        System.out.println("∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎");
        System.out.println("∎∎∎∎∎∎∎∎∎∎∎∎∎ CADASTRO ALUNO ∎∎∎∎∎∎∎∎∎∎∎∎∎");
        System.out.println("∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎");

        System.out.println("");
        System.out.println("Digite o nome do aluno: ");
        nome = sc.nextLine();
        System.out.println("Digite o CPF do aluno: ");
        cpf = sc.nextLong();
        System.out.println("Digite a matrícula do aluno");
        matricula = sc.nextLong();
        System.out.println("Tentando cadastrar aluno...");
        Aluno aluno = new Aluno(matricula, nome, cpf);
        try {
            alunos.adicionaAluno(aluno);
        } catch (AlunoJaCadastradoException ex) {
            System.out.println("Esse aluno já está cadastrado no sistema.");
        } catch (IOException ex) {
            Logger.getLogger(AlunoViewConsole.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Fim!");
        System.out.println("");

    }

    public static void consultaAluno(AtividadeDao atividades, NotaDao notas, FaltaDao faltas, TurmaDao turmas, AlunoDao alunos, DisciplinaDao disciplinas) {
        Scanner sc = new Scanner(System.in);
        int alunoId;
        System.out.println("Digite o ID do aluno que deseja consultar");
        alunoId = sc.nextInt();
        Aluno al = alunos.getAlunoById(alunoId);
        ArrayList<Turma> listaTurmas = new ArrayList<>();
        for (int x : al.getTurmas()) {
            listaTurmas.add(turmas.getTurmaById(x));
        }
        for (Turma t : listaTurmas) {
            double total = 0.0;
            ArrayList<Atividade> listaAtividades = new ArrayList<>();
            Disciplina d = disciplinas.getDisciplinaById(t.getDisciplina());
            Falta f = faltas.getFaltaByIdAluno(alunoId);
            for (int a : t.getAtividades()) {
                listaAtividades.add(atividades.getAtividadeById(a));
                ArrayList<Nota> listaNotas = new ArrayList<>();
                for (Atividade z : listaAtividades) {
                    listaNotas.add(notas.getNotaPorAlunoId(alunoId));
                }
                for (Nota m : listaNotas) {
                    total += m.getValorObtido();
                }
                total /= listaNotas.size();
            }
            double pFaltas = f.getFaltas() / d.getCargaHoraria();
            if (total >= 6 && pFaltas < 0.25) {
                System.out.println("O aluno está aprovado na turma: " + t.getId());
            } else {
                System.out.println("O aluno está reprovado na turma: " + t.getId());
            }
        }
    }

}
