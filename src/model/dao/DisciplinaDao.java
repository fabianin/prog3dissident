/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import exceptions.DisciplinaJaCadastradaException;
import java.io.IOException;
import model.pojo.Disciplina;

/**
 *
 * @author Fabiano
 */
public interface DisciplinaDao {

    public void addDisciplina(Disciplina disciplina) throws DisciplinaJaCadastradaException, IOException;

    public Disciplina getDisciplinaById(int id);
    
    public void saveFile() throws IOException;

}
