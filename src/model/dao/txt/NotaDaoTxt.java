/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.txt;

import exceptions.NotaJaCadastradaException;
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

    /**
     * Construtor do DAO
     */
    public NotaDaoTxt() {
        this.notas = new ArrayList<>();
        this.file = new File(this.filePath);
        this.initDao();
    }

    /**
     * Inicia o Dao na hora do construtor, lendo os dados já salvo e adicionando
     * nas variáveis
     */
    private void initDao() {
        if (this.file.canRead()) {
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
            } catch (IOException ex) {
                Logger.getLogger(DisciplinaDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public ArrayList<Nota> getNotas() {
        return this.notas;
    }

    @Override
    public Nota getNotaPorAlunoId(int alunoId, int turmaId) {
        List<Nota> notas = this.notas.stream().filter(nota -> nota.getAluno() == alunoId && nota.getTurma() == turmaId).collect(Collectors.toList());
        if (notas.size() > 0) {
            return notas.get(0);
        } else {
        }
        return null;
    }

    @Override
    public Nota getNotaPorId(int notaId) {
        List<Nota> notas = this.notas.stream().filter(nota -> nota.hashCode() == notaId).collect(Collectors.toList());
        if (notas.size() > 0) {
            return notas.get(0);
        }
        return null;
    }

    @Override
    public void adicionaNota(Nota nota) throws NotaJaCadastradaException, IOException {
        if (this.getNotaPorId(nota.hashCode()) == null) {
            this.notas.add(nota);
            this.saveFile();
        } else {
            throw new NotaJaCadastradaException();
        }
    }

    @Override
    public void saveFile() throws IOException {
        File f = new File(this.filePath);
        if (f.isFile()) {
            FileUtils.forceDelete(f);
        }
        this.notas.stream().forEach(item -> {
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
