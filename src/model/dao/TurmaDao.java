/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import exceptions.AtividadeJaCadastradaException;
import exceptions.FaltaJaCadastradaException;
import exceptions.TurmaJaCadastradaException;
import exceptions.TurmaNaoEncontradaException;
import java.io.IOException;
import java.util.ArrayList;
import model.pojo.Atividade;
import model.pojo.Turma;

/**
 *
 * @author Elias Júnior
 */
public interface TurmaDao {

    public Turma getTurmaById(int id);

    public ArrayList<Turma> getTurmas();

    public void saveFile() throws IOException;

    public void adicionarTurma(Turma turma) throws TurmaJaCadastradaException, IOException;

    public void adicionarAtividade(int turmaId, int atividadeId) throws AtividadeJaCadastradaException, TurmaNaoEncontradaException, IOException;
    
    public void adicionarFalta(int turmaId, int faltaId) throws FaltaJaCadastradaException, TurmaNaoEncontradaException, IOException;

}
