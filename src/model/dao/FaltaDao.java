/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import exceptions.FaltaJaCadastradaException;
import java.io.IOException;
import java.util.ArrayList;
import model.pojo.Falta;

/**
 *
 * @author Fabiano
 */
public interface FaltaDao {

    public Falta getFaltaById(int id);

    public void saveFile() throws IOException;

    public void addFalta(Falta falta) throws FaltaJaCadastradaException, IOException;

    public ArrayList<Falta> getFaltas();
    
    public Falta getFaltaByIdAluno(int AlunoId);

}
