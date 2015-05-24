package model.dao.txt;


import exceptions.NotaJaCadastradaException;
import exceptions.TurmaJaCadastradaException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.AtividadeDao;
import model.dao.txt.DaoTxtUtils;
import model.dao.txt.DisciplinaDaoTxt;
import model.dao.txt.NotaDaoTxt;
import model.pojo.Atividade;
import model.pojo.Disciplina;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Elias Júnior
 */
public class AtividadeDaoTxt implements AtividadeDao {

    private final String filePath = "txtdatabase/atividades.txt";
    private final File file;
    private ArrayList<Atividade> atividades;

    public AtividadeDaoTxt() {
        this.file = new File(this.filePath);
        this.atividades = new ArrayList<>();
        this.initDao();
    }

    private void initDao() {
        try {
            List<String> conteudo = FileUtils.readLines(this.file, "UTF-8");
            conteudo.stream().filter(str -> !str.isEmpty()).forEach((String str) -> {
                try {
                    JSONObject objAtividade = new JSONObject(str);
                    Atividade atividade;
                    atividade = DaoTxtUtils.createAtividadeFromJSON(objAtividade);
                    this.atividades.add(atividade);
                } catch (JSONException ex) {
                    Logger.getLogger(NotaDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotaJaCadastradaException ex) {
                    Logger.getLogger(AtividadeDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(DisciplinaDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Atividade getAtividadeById(int id) {
        List<Atividade> atividades = (List<Atividade>) this.atividades.stream().filter(atividade -> atividade.hashCode() == id);
        if (atividades.size() > 0) {
            return atividades.get(0);
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Atividade> getAtividades() {
        return this.atividades;
    }

    @Override
    public void saveFile() throws IOException {
        File f = new File(this.filePath);
        if (f.isFile()) {
            FileUtils.forceDelete(f);
        }
        this.atividades.stream().forEach(item -> {
            try {
                FileUtils.writeStringToFile(f, DaoTxtUtils.toJSON(item) + "\r\n", "UTF-8", true);
            } catch (IOException ex) {
                Logger.getLogger(DaoTxtUtils.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(NotaDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

}
