/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.console;

import exceptions.AlunoJaCadastradoException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.AlunoDao;
import model.dao.txt.AlunoDaoTxt;
import model.pojo.Aluno;

/**
 *
 * @author Fabiano
 */
public class AlunoView {

    public AlunoView() {
    }
    public void imprimirAlunos(AlunoDao alunos){
        alunos.getAlunos().stream().forEach((x) -> System.out.println(x));
    }
    private void cadastraAluno(AlunoDao alunos) {

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
            this.alunos.adicionaAluno(aluno);
        } catch (AlunoJaCadastradoException ex) {
            System.out.println("O aluno já está cadastrado e não foi cadastrado.");
        } catch (IOException ex) {
            System.out.println("Não foi possível salvar o aluno ao banco de dados. Poderá ocorrer perda de dados por isso.");
        }

        System.out.println("Fim!");
        System.out.println("");

    }
    
}
