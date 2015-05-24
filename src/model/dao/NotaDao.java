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
     * Obtém todos os registros de notas no banco de dados
     * @return notas
     */
    public ArrayList<Nota> getNotas();
    
    /**
     * Obtém uma nota à partir de um ID do aluno
     * @param alunoId
     * @return 
     */
    public Nota getNotaPorAlunoId(int alunoId);
    
    public Nota getNotaPorId(int notaId);
    
}
