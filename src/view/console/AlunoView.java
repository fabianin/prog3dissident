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
    public static void imprimirAlunos(AlunoDao alunos){
        alunos.getAlunos().stream().forEach((x) -> System.out.println(x));
    }
    public static void cadastraAluno(AlunoDao alunos) throws IOException{
        Aluno al;
        Scanner sci = new Scanner(System.in);
        String nome;
        long cpf;
        long matricula;
        System.out.println("Digite o nome do aluno: ");
        nome = sci.nextLine();
        System.out.println("Digite o CPF do aluno: ");
        cpf = sci.nextLong();
        System.out.println("Digite a matricula do ALuno: ");
        matricula = sci.nextInt();
        al = new Aluno(matricula, nome, cpf);
        try {
            alunos.adicionaAluno(al);
        } catch (AlunoJaCadastradoException ex) {
            System.out.println("Esse aluno já foi cadastrado no sistema, por favor tente novamente");
        }
    }
    
}
