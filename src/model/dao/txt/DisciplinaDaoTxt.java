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
public class DisciplinaDaoTxt {

    private final String filePath;
    private final File file;
    private List<String> fileContent;
    private ArrayList<Disciplina> disciplinas;

    public DisciplinaDaoTxt() throws IOException {
        this.filePath = "txtdatabase/disciplinas.txt";
        this.file = new File(this.filePath);
        this.fileContent = FileUtils.readLines(this.file, "UTF-8");
    }

    private boolean addDisciplina(Disciplina disc) {
        if (this.disciplinas.contains(disc)) {
            return false;
        } else {
            this.disciplinas.add(disc);
            return true;
        }
    }

}
