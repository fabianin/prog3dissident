/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.console;

import exceptions.AlunoJaCadastradoException;
import exceptions.ProfessorJaCadastradoException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.ProfessorDao;
import model.pojo.Aluno;
import model.pojo.Professor;

/**
 *
 * @author Elias Júnior
 */
public class ProfessorViewConsole {

    public static void imprimirProfessores(ProfessorDao dao) {
        System.out.println("imprimir professores aqui");
    }

    public static void cadastraProfessor(ProfessorDao dao) {

        Scanner sc = new Scanner(System.in);
        String nome;
        long cpf;
        String departamento;

        System.out.println("∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎");
        System.out.println("∎∎∎∎∎∎∎∎∎∎∎∎∎ CADASTRO ALUNO ∎∎∎∎∎∎∎∎∎∎∎∎∎");
        System.out.println("∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎");

        System.out.println("");
        System.out.println("Digite o nome do professor: ");
        nome = sc.nextLine();
        System.out.println("Digite o CPF do professor: ");
        cpf = sc.nextLong();
        System.out.println("Digite o departamento do professor");
        departamento = sc.nextLine();

        System.out.println("Tentando cadastrar aluno...");

        Professor professor = new Professor(nome, cpf, departamento);

        try {
            dao.adicionaProfessor(professor);
            System.out.println("Professor cadastrado com sucesso.");
        } catch (IOException ex) {
            System.out.println("Não foi possível salvar o aluno ao banco de dados. Poderá ocorrer perda de dados por isso.");
        } catch (ProfessorJaCadastradoException ex) {
            System.out.println("O professor já está cadastrado.");
        }

        System.out.println("Fim!");
        System.out.println("");

    }

}
