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
import java.util.stream.Collectors;
import java.util.stream.Stream;
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
                    JSONObject objNota = new JSONObject(str);
                    Nota nota = DaoTxtUtils.createNotaFromJSON(objNota);
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
    public ArrayList<Nota> getNotas() {
        return this.notas;
    }

    @Override
    public Nota getNotaPorAlunoId(int alunoId) {
        List<Nota> notas = this.notas.stream().filter(nota -> nota.getAluno() == alunoId).collect(Collectors.toList());
        if (notas.size()) {
            return notas.get(0);
        }
        return null;
    }

    @Override
    public Nota getNotaPorId(int notaId) {
        List<Nota> notas = this.notas.stream().filter(nota -> nota.hashCode() == notaId).collect(Collectors.toList());
        if (notas.size()) {
            return notas.get(0);
        }
        return null;
    }

}
