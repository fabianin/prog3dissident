package view.console;

import exceptions.ProfessorJaCadastradoException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import model.dao.DisciplinaDao;
import model.dao.ProfessorDao;
import model.pojo.Disciplina;
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
        String departamento;
        long cpf;

        System.out.println("∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎");
        System.out.println("∎∎∎∎∎∎∎∎∎∎∎∎∎ CADASTRO ALUNO ∎∎∎∎∎∎∎∎∎∎∎∎∎");
        System.out.println("∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎");

        System.out.println("");
        System.out.print("Digite o nome do professor: ");
        nome = sc.nextLine();
        System.out.print("Digite o departamento do professor: ");
        departamento = sc.nextLine();
        System.out.print("Digite o CPF do professor: ");
        cpf = sc.nextLong();

        System.out.println("Tentando cadastrar professor...");

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

    public static void numDisciplinaLecionada(ProfessorDao professores) {
        Scanner sc = new Scanner(System.in);
        int profId;
        System.out.println("Digite o ID do professor que deseja consultar: ");
        profId = sc.nextInt();
        Professor x = professores.getProfessorById(profId);
        if (x != null) {
            System.out.println("Esse professor já lecionou " + x.getTurmasLecionando().size() + " turmas.");
        } else {
            System.out.println("Esse professor ainda não existe no sistema. Verifique o ID");
        }
    }

}
