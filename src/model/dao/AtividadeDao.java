/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import exceptions.AtividadeJaCadastradaException;
import java.io.IOException;
import java.util.ArrayList;
import model.pojo.Atividade;

/**
 *
 * @author Elias Júnior
 */
public interface AtividadeDao {

    public Atividade getAtividadeById(int id);

    public ArrayList<Atividade> getAtividades();

    public void saveFile() throws IOException;
    
    public void adicionarAtividade(Atividade atividade) throws AtividadeJaCadastradaException, IOException;

}
