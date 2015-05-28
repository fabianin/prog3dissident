/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.txt;

import exceptions.AlunoJaCadastradoException;
import exceptions.AtividadeJaCadastradaException;
import exceptions.FaltaJaCadastradaException;
import exceptions.ProfessorNaoAptoDisciplinaException;
import exceptions.TurmaJaCadastradaException;
import exceptions.TurmaNaoEncontradaException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import model.dao.TurmaDao;
import model.pojo.Atividade;
import model.pojo.Disciplina;
import model.pojo.Nota;
import model.pojo.Turma;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Elias Júnior
 */
public class TurmaDaoTxt implements TurmaDao {

    private String filePath = "txtdatabase/turmas.txt";
    private File file;
    private ArrayList<Turma> turmas;

    public TurmaDaoTxt() {
        this.file = new File(this.filePath);
        this.turmas = new ArrayList<>();
        this.initDao();
    }

    private void initDao() {
        if (this.file.canRead()) {
            try {
                List<String> conteudo = FileUtils.readLines(this.file, "UTF-8");
                conteudo.stream().filter(str -> !str.isEmpty()).forEach((String str) -> {
                    try {
                        JSONObject objTurma = new JSONObject(str);
                        Turma turma;
                        turma = DaoTxtUtils.createTurmaFromJSON(objTurma);
                        this.turmas.add(turma);
                    } catch (JSONException ex) {
                        Logger.getLogger(NotaDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NullPointerException ex) {
                        Logger.getLogger(TurmaDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalArgumentException ex) {
                        Logger.getLogger(TurmaDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ProfessorNaoAptoDisciplinaException ex) {
                        Logger.getLogger(TurmaDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (FaltaJaCadastradaException ex) {
                        Logger.getLogger(TurmaDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (AlunoJaCadastradoException ex) {
                        Logger.getLogger(TurmaDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (AtividadeJaCadastradaException ex) {
                        Logger.getLogger(TurmaDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            } catch (IOException ex) {
                Logger.getLogger(DisciplinaDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Turma getTurmaById(int id) {
        List<Turma> turmas = this.turmas.stream().filter(turma -> turma.hashCode() == id).collect(Collectors.toList());
        if (turmas.size() > 0) {
            return turmas.get(0);
        }
        return null;
    }

    @Override
    public ArrayList<Turma> getTurmas() {
        return this.turmas;
    }

    @Override
    public void saveFile() throws IOException {
        File f = new File(this.filePath);
        if (f.isFile()) {
            FileUtils.forceDelete(f);
        }
        this.turmas.stream().forEach(item -> {
            try {
                FileUtils.writeStringToFile(f, DaoTxtUtils.toJSON(item) + "\r\n", "UTF-8", true);
            } catch (IOException ex) {
                Logger.getLogger(DaoTxtUtils.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(NotaDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    @Override
    public void adicionarTurma(Turma turma) throws TurmaJaCadastradaException, IOException {
        if (this.turmas.contains(turma.hashCode())) {
            throw new TurmaJaCadastradaException();
        } else {
            this.turmas.add(turma);
            this.saveFile();
        }
    }

    @Override
    public void adicionarAtividade(int turmaId, int atividadeId) throws AtividadeJaCadastradaException, TurmaNaoEncontradaException, IOException {
        for (Turma turma : this.turmas) {
            if (turma.hashCode() == turmaId) {
                turma.addAtividade(atividadeId);
                this.saveFile();
                return;
            }
        }
        throw new TurmaNaoEncontradaException();
    }

    @Override
    public void adicionarFalta(int turmaId, int faltaId) throws FaltaJaCadastradaException, TurmaNaoEncontradaException, IOException {
        for (Turma turma : this.turmas) {
            if (turma.hashCode() == turmaId) {
                turma.addFalta(faltaId);
                this.saveFile();
                return;
            }
        }
        throw new TurmaNaoEncontradaException();
    }

}
