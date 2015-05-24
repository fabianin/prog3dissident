/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.console;

import exceptions.ProfessorNaoAptoDisciplinaException;
import exceptions.TurmaJaCadastradaException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import model.dao.DisciplinaDao;
import model.dao.ProfessorDao;
import model.dao.TurmaDao;
import model.pojo.Disciplina;
import model.pojo.Professor;
import model.pojo.Turma;

/**
 *
 * @author Fabiano
 */
public class TurmaViewConsole {

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
            } catch (NullPointerException | IllegalArgumentException | ProfessorNaoAptoDisciplinaException | TurmaJaCadastradaException | IOException ex) {
                Logger.getLogger(TurmaViewConsole.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void imprimiTurmas(TurmaDao turmas) {
        turmas.getTurmas().stream().forEach((x) -> System.out.println(x));
    }

}
