/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.console;

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

/**
 *
 * @author Elias Júnior
 */
public class TelaPrincipalConsole {

    private final AlunoDao alunos;
    private final AtividadeDao atividades;
    private final DisciplinaDao disciplinas;
    private final FaltaDao faltas;
    private final NotaDao notas;
    private final ProfessorDao professores;
    private final TurmaDao turmas;

    public TelaPrincipalConsole() {
        this.alunos = new AlunoDaoTxt();
        this.atividades = new AtividadeDaoTxt();
        this.disciplinas = new DisciplinaDaoTxt();
        this.faltas = new FaltaDaoTxt();
        this.notas = new NotaDaoTxt();
        this.professores = new ProfessorDaoTxt();
        this.turmas = new TurmaDaoTxt();
    }

    public static void main(String[] args) {
        TelaPrincipalConsole tpc = new TelaPrincipalConsole();
    }

}
