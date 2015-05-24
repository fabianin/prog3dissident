/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.console;

import exceptions.AlunoJaCadastradoException;
import java.io.IOException;
import model.dao.AlunoDao;
import model.dao.AtividadeDao;
import model.dao.DisciplinaDao;
import model.dao.FaltaDao;
import model.dao.NotaDao;
import model.dao.ProfessorDao;
import model.dao.TurmaDao;
import model.dao.txt.AlunoDaoTxt;
import model.dao.txt.AtividadeDaoTxt;
import model.dao.txt.DisciplinaDaoTxt;
import model.dao.txt.FaltaDaoTxt;
import model.dao.txt.NotaDaoTxt;
import model.dao.txt.ProfessorDaoTxt;
import model.dao.txt.TurmaDaoTxt;
import model.pojo.Aluno;

/**
 *
 * @author Elias Júnior
 */
public class TelaPricipalConsole {

    private final AlunoDao alunos = new AlunoDaoTxt();
    private final AtividadeDao atividades = new AtividadeDaoTxt();
    private final DisciplinaDao disciplinas = new DisciplinaDaoTxt();
    private final FaltaDao faltas = new FaltaDaoTxt();
    private final NotaDao notas = new NotaDaoTxt();
    private final ProfessorDao professores = new ProfessorDaoTxt();
    private final TurmaDao turmas = new TurmaDaoTxt();

    public static void main(String[] args) throws IOException {
        TelaPricipalConsole tpc = new TelaPricipalConsole();
        AlunoView av = new AlunoView();
        tpc.showMenu();
        av.cadastraAluno(tpc.alunos);
    }

    private void showMenu() {
        System.out.println("▊▊▊▊▊▊▊▊▊▊▊▊▊▊▊▊▊▊▊▊▊▊▊▊▊▊");
        System.out.println("▊▊▊▊▊▊▊▊ MENU PRINCIPAL ▊▊▊▊▊▊▊▊");
        System.out.println("▊▊▊▊▊▊▊▊▊▊▊▊▊▊▊▊▊▊▊▊▊▊▊▊▊▊");
        System.out.println("");
        System.out.println("Escolha uma das opções: ");
        System.out.println("1) Cadastrar aluno");
        System.out.println("2) Cadastrar professor");
        System.out.println("3) Cadastrar disciplina");
        System.out.println("4) Cadastrar turma");
        System.out.println("5) Cadastrar atividade");
        System.out.println("6) Lançar nota");
        System.out.println("7) Lançar faltas");
        System.out.println("8) Consultar turmas");
        System.out.println("9) Consultar situação de aluno em uma disciplina");
        System.out.println("10) Consu11ltar o número de turmas já oferecidas por disciplina");
        System.out.println("11) Consultar o número de disciplinas já lecionadas por um professor");
    }

}
