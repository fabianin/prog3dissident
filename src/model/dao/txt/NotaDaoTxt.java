/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.txt;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.NotaDao;
import model.pojo.Aluno;
import model.pojo.Nota;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Elias Júnior
 */
public class NotaDaoTxt implements NotaDao {

    private String filePath = "txtdatabase/notas.txt";
    private File file;
    private ArrayList<Nota> notas;

    public NotaDaoTxt() {
        this.notas = new ArrayList<>();
        this.file = new File(this.filePath);
    }

    private void initDao() {
        try {
            List<String> conteudo = FileUtils.readLines(this.file, "UTF-8");
            conteudo.stream().filter(str -> !str.isEmpty()).forEach(str -> {
                try {

                    // JSON
                    JSONObject linha = new JSONObject(str);
                    JSONObject objAluno = linha.getJSONObject("aluno");

                    // Dados Aluno
                    String nome = objAluno.getString("nome");
                    long cpf = objAluno.getLong("cpf");
                    long matricula = objAluno.getLong("matricula");

                    // Dados Nota
                    double valorObtido = linha.getDouble("valorObtido");
                    Aluno aluno = new Aluno(matricula, nome, cpf);
                    Nota nota = new Nota(valorObtido, aluno);   
                    
                    // Adiciona nota
                    this.notas.add(nota);

                } catch (JSONException ex) {
                    Logger.getLogger(NotaDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        } catch (IOException e) {
            System.out.println("Houve um erro: " + e.getMessage());
        }
    }

    @Override
    public Nota getNotaPorMatricula(long matricula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Nota> getNotas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}