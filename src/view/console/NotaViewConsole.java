/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.console;

import exceptions.NotaJaCadastradaException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.AlunoDao;
import model.dao.NotaDao;
import model.dao.TurmaDao;
import model.pojo.Aluno;
import model.pojo.Nota;
import model.pojo.Turma;

/**
 *
 * @author Elias Júnior
 */
public class NotaViewConsole {

    public static void cadastrarNota(NotaDao notaDao, AlunoDao alunoDao, TurmaDao turmaDao) {

        Scanner sc = new Scanner(System.in);
        double valorObtido;
        int alunoId, turmaId;

        System.out.println("∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎");
        System.out.println("∎∎∎∎∎∎∎∎∎∎∎ CADASTRO ATIVIDADE ∎∎∎∎∎∎∎∎∎∎∎");
        System.out.println("∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎");

        System.out.println("");
        System.out.print("Digite o valor obtido: ");
        valorObtido = sc.nextDouble();
        System.out.print("Digite o ID do aluno: ");
        alunoId = sc.nextInt();
        System.out.print("Digite o ID da turma: ");
        turmaId = sc.nextInt();

        try {
            Nota nota = new Nota(valorObtido, alunoId, turmaId);
            Aluno aluno = alunoDao.getAlunoById(alunoId);
            Turma turma = turmaDao.getTurmaById(turmaId);

            if (aluno == null) {
                System.out.println("Aluno inválido.");
            } else if (turma == null) {
                System.out.println("Turma inválida");
            } else {
                try {
                    notaDao.adicionaNota(nota);
                } catch (NotaJaCadastradaException ex) {
                    System.out.println("Nota já está cadastrada.");
                } catch (IOException ex) {
                    System.out.println("Houve um erro ao adicionar ao banco de dados");
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("");
        }

    }

}
