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

    public static void main(String[] args) throws AlunoJaCadastradoException, IOException {
        TelaPricipalConsole tp = new TelaPricipalConsole();
        AlunoView.imprimirAlunos(tp.getAlunos());
        Aluno al = new Aluno(1231, "Fabiano", 20);
        tp.getAlunos().adicionaAluno(al);
    }

    public AlunoDao getAlunos() {
        return alunos;
    }

    public AtividadeDao getAtividades() {
        return atividades;
    }

    public DisciplinaDao getDisciplinas() {
        return disciplinas;
    }

    public FaltaDao getFaltas() {
        return faltas;
    }

    public NotaDao getNotas() {
        return notas;
    }

    public ProfessorDao getProfessores() {
        return professores;
    }

    public TurmaDao getTurmas() {
        return turmas;
    }
    
}
