/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import model.pojo.Nota;

/**
 *
 * @author Elias Júnior
 */
public interface NotaDao {
    
    /**
     * Obtém a nota de um aluno recebendo uma matrícula como referência
     * @param matricula
     * @return 
     */
    public Nota getNotaPorMatricula(long matricula);
    
    /**
     * Obtém todos os registros de notas no banco de dados
     * @return notas
     */
    public ArrayList<Nota> getNotas();
    
}
