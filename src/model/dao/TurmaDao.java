/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.io.IOException;
import java.util.ArrayList;
import model.pojo.Turma;

/**
 *
 * @author Elias Júnior
 */
public interface TurmaDao {

    public Turma getTurmaById(int id);

    public ArrayList<Turma> getTurmas();

    public void saveFile() throws IOException;

}
