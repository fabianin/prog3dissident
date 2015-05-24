/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.txt;

import exceptions.TurmaJaCadastradaException;
import exceptions.DisciplinaJaCadastradaException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.DisciplinaDao;
import model.pojo.Disciplina;
import model.pojo.Turma;
import org.apache.commons.io.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Fabiano
 */
public class DisciplinaDaoTxt implements DisciplinaDao {

    private final String filePath;
    private final File file;
    private List<String> fileContent;
    private ArrayList<Disciplina> disciplinas;

    public DisciplinaDaoTxt() throws IOException {
        this.filePath = "txtdatabase/disciplinas.txt";
        this.file = new File(this.filePath);
        this.fileContent = FileUtils.readLines(this.file, "UTF-8");
    }

    private void initDao() {
        try {
            List<String> conteudo = FileUtils.readLines(this.file, "UTF-8");
            conteudo.stream().filter(str -> !str.isEmpty()).forEach((String str) -> {
                try {
                    JSONObject objDisciplina = new JSONObject(str);
                    Disciplina disciplina;
                    disciplina = DaoTxtUtils.createDisciplinaFromJSON(objDisciplina);
                    this.disciplinas.add(disciplina);
                } catch (JSONException ex) {
                    Logger.getLogger(NotaDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
                } catch (TurmaJaCadastradaException ex) {
                    Logger.getLogger(DisciplinaDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        } catch (IOException e) {
            System.out.println("Houve um erro: " + e.getMessage());
        }
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    @Override
    public void addDisciplina(Disciplina disciplina) throws DisciplinaJaCadastradaException{
        if(this.disciplinas.contains(disciplina)){
            throw new DisciplinaJaCadastradaException();
        }else{
            this.disciplinas.add(disciplina);
        }
    }

    @Override
    public Disciplina getDisciplinaById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
