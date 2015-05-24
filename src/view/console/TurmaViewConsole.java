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
        List<Disciplina> dd = disc.getDisciplinas().stream().filter(x -> x.getId()==disciplina).collect(Collectors.toList());
        if(dd.size()<1){
            System.out.println("Disciplina não existente...");
            return false;
        }
        System.out.println("Digite o ano: ");
        ano = sc.nextInt();
        System.out.println("Digite o ID do professor: ");
        professor = sc.nextInt();
        List<Professor> pp;
        pp = professores.getProfessores().stream().filter(x -> x.getId()==professor).collect(Collectors.toList());
        if(pp.size()<1){
            System.out.println("professor não cadastrado no sistema");
            return false;
        }
        try {
            Turma turma = new Turma(disciplina, periodo, numeroVagas, sala, ano, professor);
            turmas.adicionarTurma(turma);
            pp = professores.getProfessores().stream().filter(x -> x.getId()==professor).collect(Collectors.toList());
            pp.get(0).addTurmaLecionando(turma.getId());
        } catch (NullPointerException | IllegalArgumentException | ProfessorNaoAptoDisciplinaException | TurmaJaCadastradaException | IOException ex) {
            Logger.getLogger(TurmaViewConsole.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

}
