/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.console;

import model.dao.AlunoDao;
import model.dao.txt.AlunoDaoTxt;
import model.pojo.Aluno;

/**
 *
 * @author Fabiano
 */
public class AlunoView {

    public AlunoView() {
    }
    public static void imprimirAlunos(AlunoDao alunos){
        alunos.getAlunos().stream().forEach((x) -> System.out.println(x));
    }
    
}
