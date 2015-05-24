/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.txt;

import exceptions.NotaJaCadastradaException;
import model.pojo.Nota;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elias Júnior
 */
public class NotaDaoTxtTest {

    public NotaDaoTxtTest() {
    }

    @Test
    public void testes() throws NotaJaCadastradaException {
        NotaDaoTxt teste = new NotaDaoTxt();
        Nota nota1 = new Nota(1, 300);
        Nota nota2 = new Nota(2, 200);
        Nota nota3 = new Nota(3, 100);
        //teste.adicionaNota(nota1);
        //teste.adicionaNota(nota2);
        //teste.adicionaNota(nota3);
        teste.getNotas().stream().forEach(nota -> System.out.println(nota.getValorObtido()));
    }

}
