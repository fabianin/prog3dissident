/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.console;

import java.util.ArrayList;
import java.util.Scanner;
import model.dao.DisciplinaDao;
import model.pojo.Disciplina;

/**
 *
 * @author Fabiano
 */
public class DisciplinaViewConsole {
    public void cadastraDisciplina(DisciplinaDao disciplinas){
        System.out.println("∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎");
        System.out.println("∎∎∎∎∎∎∎∎∎∎∎∎∎ CADASTRO DISCIPLINA ∎∎∎∎∎∎∎∎∎∎∎∎∎");
        System.out.println("∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎");
        Scanner sc = new Scanner(System.in);
        String nome;
        String ementa;
        long cargaHoraria;
        System.out.println("Digite o nome da Disciplina: ");
        nome = sc.nextLine();
        System.out.println("Digite a Ementa da disciplina: ");
        ementa = sc.nextLine();
        System.out.println("Digite a carga horaria da disciplina: ");
        cargaHoraria = sc.nextLong();
        Disciplina dis = new Disciplina(nome, ementa, cargaHoraria);
        
    }
    
}
