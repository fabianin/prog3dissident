/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.console;

import exceptions.ProfessorNaoAptoDisciplinaException;
import exceptions.TurmaJaCadastradaException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.DisciplinaDao;
import model.dao.ProfessorDao;
import model.dao.TurmaDao;
import model.pojo.Turma;

/**
 *
 * @author Fabiano
 */
public class TurmaViewConsole {

    public boolean cadastraTurma(TurmaDao turmas, DisciplinaDao disc, ProfessorDao professores) {
        long periodo;
        long numeroVagas;
        long sala;
        int disciplina;
        long ano;
        int professor;
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o peridoo: ");
        periodo = sc.nextLong();
        System.out.println("Digite o numero de vagas: ");
        numeroVagas = sc.nextLong();
        System.out.println("Digite o numero da sala: ");
        sala = sc.nextInt();
        System.out.println("Digite o ID da disciplina: ");
        disciplina = sc.nextInt();
        if(!disc.getDisciplinas().contains(disciplina)){
            System.out.println("Essa disciplina não existe");
            return false;
        }
        System.out.println("Digite o ano: ");
        ano = sc.nextInt();
        System.out.println("Digite o ID do professor: ");
        professor = sc.nextInt();
        if(!professores.getProfessores().contains(professor)){
            System.out.println("professor não cadastrado no sistema");
            return false;
        }
        try {
            Turma turma = new Turma(disciplina, periodo, numeroVagas, sala, ano, professor);
            turmas.adicionarTurma(turma);
        } catch (NullPointerException | IllegalArgumentException | ProfessorNaoAptoDisciplinaException | TurmaJaCadastradaException | IOException ex) {
            Logger.getLogger(TurmaViewConsole.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

}
