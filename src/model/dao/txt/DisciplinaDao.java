/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.txt;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Fabiano
 */
public class DisciplinaDao {

    private final String filePath;
    private final File file;
    private List<String> fileContent;

    public DisciplinaDaoTxt() {
        this.filePath = "txtdatabase/alunos.txt";
        this.file = new File(this.filePath);
        this.lastId = 0;
        try {
            this.fileContent = FileUtils.readLines(this.file, "UTF-8");
        } catch (IOException e) {
            System.out.println("Não encontrado");
        }
    }

}
