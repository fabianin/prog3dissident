package view.console;

import exceptions.DisciplinaJaCadastradaException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import model.dao.DisciplinaDao;
import model.pojo.Disciplina;

/**
 *
 * @author Fabiano
 */
public class DisciplinaViewConsole {

    public static void cadastraDisciplina(DisciplinaDao disciplinas) {
        System.out.println("∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎");
        System.out.println("∎∎∎∎∎∎∎∎∎∎∎∎∎ CADASTRO DISCIPLINA ∎∎∎∎∎∎∎∎∎∎∎∎∎");
        System.out.println("∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎");
        Scanner sc = new Scanner(System.in);
        String nome;
        String ementa;
        long cargaHoraria;
        System.out.println("Digite o nome da Disciplina: ");
        nome = sc.nextLine();
        System.out.println("Digite a Ementa da disciplina: ");
        ementa = sc.nextLine();
        System.out.println("Digite a carga horaria da disciplina: ");
        cargaHoraria = sc.nextLong();
        Disciplina dis = new Disciplina(nome, ementa, cargaHoraria);
        try {
            disciplinas.addDisciplina(dis);
        } catch (DisciplinaJaCadastradaException | IOException ex) {
            Logger.getLogger(DisciplinaViewConsole.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void imprimiDisciplinas(DisciplinaDao disciplinas) {
        disciplinas.getDisciplinas().stream().forEach((Disciplina x) -> {
            System.out.println(x);
        });
    }

    public static void consultarTurmas(DisciplinaDao disciplinas) {
        int disciplinaId;
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o ID da disciplina que deseja consultar");
        disciplinaId = sc.nextInt();
        Disciplina x;
        x = disciplinas.getDisciplinaById(disciplinaId);
        if (x != null) {
            System.out.println("Existem " + x.getTurmas().size() + " turmas dessa disciplina");
        } else {
            System.out.println("Não existe uma disciplina com esse ID");
        }

    }

}
