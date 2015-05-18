/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import exceptions.AlunoJaCadastradoException;
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

    /** retorna TRUE caso o aluno esteja com a situação de aprovado na turma
     * retorna false caso o aluno não tenha obtido média suficiente ou
     * estrapolou o numero maximo de faltas
     *
     * @param aluno
     * @param turma
     * @return True, False
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

    /** Adiciona um aluno a lista de todos os alunos.
     *
     * @param aluno
     * @throws AlunoJaCadastradoException
     */
    public void addAluno(Aluno aluno)throws AlunoJaCadastradoException{
        if(listaAlunos.contains(aluno)){
            throw new AlunoJaCadastradoException("Esse aluno já existe.");
        }
        else{
            listaAlunos.add(aluno);
        }
    }
    
}
