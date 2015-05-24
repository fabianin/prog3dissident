/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.txt;

import exceptions.FaltaJaCadastradaException;
import exceptions.TurmaJaCadastradaException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.pojo.Disciplina;
import model.pojo.Falta;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Fabiano
 */
public class FaltaDaoTxt {

    private final String filePath = "txtdatabase/faltas.txt";
    private final File file;
    private final ArrayList<Falta> faltas;

    public FaltaDaoTxt() throws IOException {
        this.file = new File(this.filePath);
        this.faltas = new ArrayList<>();
        this.initDao();
    }

    private void initDao() {
        try {
            List<String> conteudo = FileUtils.readLines(this.file, "UTF-8");
            conteudo.stream().filter(str -> !str.isEmpty()).forEach((String str) -> {
                try {
                    JSONObject objFalta = new JSONObject(str);
                    Falta falta;
                    falta = DaoTxtUtils.createFaltaFromJSON(objFalta);
                    this.faltas.add(falta);
                } catch (JSONException ex) {
                    Logger.getLogger(NotaDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(DisciplinaDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Falta> getFaltas() {
        return faltas;
    }

    public void addFalta(Falta falta) throws FaltaJaCadastradaException, IOException {
        if (this.faltas.contains(falta)) {
            throw new FaltaJaCadastradaException();
        } else {
            this.faltas.add(falta);
            this.saveFile();
        }
    }

    public void saveFile() throws IOException {
        File f = new File(this.filePath);
        if (f.isFile()) {
            FileUtils.forceDelete(f);
        }
        this.faltas.stream().forEach(item -> {
            try {
                FileUtils.writeStringToFile(f, DaoTxtUtils.toJSON(item) + "\r\n", "UTF-8", true);
            } catch (IOException ex) {
                Logger.getLogger(DaoTxtUtils.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(NotaDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    public Falta getFaltaById(int id) {
        List<Falta> falta = (List<Falta>) this.faltas.stream().filter(fal -> fal.hashCode() == id);
        if (falta.size() > 0) {
            return falta.get(0);
        } else {
            return null;
        }
    }

}
