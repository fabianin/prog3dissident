/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.pojo.Turma;
import java.util.ArrayList;
import model.pojo.Aluno;

/**
 *
 * @author Fabiano
 */
public class AlunoDAO {
    ArrayList<Aluno> listaAlunos = new ArrayList<>();

    public AlunoDAO() {
    }

    /**
     *
     * @param aluno
     * @param turma
     * @return
     */
    public boolean aprovado(Aluno aluno,Turma  turma){
        if(!listaAlunos.contains(aluno)){
            throw new IllegalArgumentException("Aluno não cadastrado");
        } else{
            for(Aluno x : this.listaAlunos){
                if(x.equals(aluno)){
                    if(turma.getMedia(x) >= 7 && (turma.getFaltas(aluno)/turma.getDisciplina().getCargaHoraria())<0.25){
                        return true;
                    }
                }
            }
            return false;
        }
    }
    
}
