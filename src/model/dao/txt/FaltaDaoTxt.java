/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.txt;

import exceptions.FaltaJaCadastradaException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.FaltaDao;
import model.pojo.Falta;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Fabiano
 */
public class FaltaDaoTxt implements FaltaDao {

    private final String filePath = "txtdatabase/faltas.txt";
    private final File file;
    private final ArrayList<Falta> faltas;

    public FaltaDaoTxt() {
        this.file = new File(this.filePath);
        this.faltas = new ArrayList<>();
        this.initDao();
    }

    private void initDao() {
        if (this.file.canRead()) {
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
    }

    @Override
    public ArrayList<Falta> getFaltas() {
        return faltas;
    }

    /**
     * Lança uma falta
     *
     * @param falta
     * @throws FaltaJaCadastradaException
     * @throws IOException
     */
    @Override
    public void addFalta(Falta falta) throws FaltaJaCadastradaException, IOException {
        if (this.faltas.contains(falta)) {
            throw new FaltaJaCadastradaException();
        } else {
            this.faltas.add(falta);
            this.saveFile();
        }
    }

    /**
     * Salva a lista de objetos em txt
     *
     * @throws IOException
     */
    @Override
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

    /**
     *
     * @param id
     * @return Passado um ID retorna o objeto falta que contem aquele ID
     */
    @Override
    public Falta getFaltaById(int id) {
        List<Falta> falta = (List<Falta>) this.faltas.stream().filter(fal -> fal.hashCode() == id);
        if (falta.size() > 0) {
            return falta.get(0);
        } else {
            return null;
        }
    }
    public Falta getFaltaByIdAluno(int AlunoId) {
        List<Falta> falta;
        falta = (List<Falta>) this.faltas.stream().filter(fal -> fal.getAluno() == AlunoId);
        if (falta.size() > 0) {
            return falta.get(0);
        } else {
            return null;
        }
    }

}
