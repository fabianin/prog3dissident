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
import model.dao.TurmaDao;
import model.pojo.Turma;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Elias Júnior
 */
public class TurmaDaoTxt implements TurmaDao {
    
    private Integer lastId;
    private final String filePath;
    private final File file;
    private List<String> fileContent;

    public TurmaDaoTxt() {
        this.filePath = "txtdatabase/turmas.txt";
        this.file = new File(this.filePath);
        this.lastId = 0;
        try {
            this.fileContent = FileUtils.readLines(this.file, "UTF-8");
            this.defLastId();
        } catch (IOException e) {
            System.out.println("Não encontrado");
        }
    }
    
    private void defLastId() {
        this.fileContent.stream().filter(str -> !str.isEmpty()).forEach((String str) -> this.setLastId(getLineIndex(str, 0)));
    }
    
    private void setLastId(String id) {
        this.lastId = new Integer(id);
    }
    
    private String getLineIndex(String line, int index) {
        String[] colunas = line.split(";");
        if (colunas.length > index) {
            return colunas[index];
        } else {
            return null;
        }
    }

    @Override
    public Turma getTurmaByID(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Turma> getTurmasDeAluno(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer adicionaTurma(Turma turma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeTurma(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
