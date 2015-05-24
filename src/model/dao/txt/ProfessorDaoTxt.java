/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.txt;

import exceptions.AlunoJaCadastradoException;
import exceptions.DisciplinaJaCadastradaException;
import exceptions.ProfessorJaCadastradoException;
import exceptions.TurmaJaCadastradaException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import model.dao.ProfessorDao;
import model.pojo.Aluno;
import model.pojo.Professor;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Elias Júnior
 */
public class ProfessorDaoTxt implements ProfessorDao {

    private final String filePath = "txtdatabase/alunos.txt";
    private final File file;
    private final ArrayList<Professor> professores;

    public ProfessorDaoTxt() {
        this.file = new File(this.filePath);
        this.professores = new ArrayList<>();
        this.initDao();
    }

    private void initDao() {
        if (this.file.canRead()) {
            try {
                List<String> conteudo = FileUtils.readLines(this.file, "UTF-8");
                conteudo.stream().filter(str -> !str.isEmpty()).forEach((String str) -> {
                    try {
                        JSONObject objProfessor = new JSONObject(str);
                        Professor professor;
                        professor = DaoTxtUtils.createProfessorFromJSON(objProfessor);
                        this.professores.add(professor);
                    } catch (JSONException ex) {
                        Logger.getLogger(NotaDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (TurmaJaCadastradaException ex) {
                        Logger.getLogger(DisciplinaDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalArgumentException ex) {
                        Logger.getLogger(ProfessorDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NullPointerException ex) {
                        Logger.getLogger(ProfessorDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (DisciplinaJaCadastradaException ex) {
                        Logger.getLogger(ProfessorDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            } catch (IOException ex) {
                Logger.getLogger(DisciplinaDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Professor getProfessorById(int id) {
        List<Professor> professores = this.professores.stream().filter(professor -> professor.hashCode() == id).collect(Collectors.toList());
        if (professores.size() > 0) {
            return professores.get(0);
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Professor> getProfessores() {
        return this.professores;
    }

    @Override
    public void adicionaProfessor(Professor professor) throws ProfessorJaCadastradoException, IOException {
        if (this.professores.contains(professor)) {
            throw new ProfessorJaCadastradoException();
        } else {
            this.professores.add(professor);
            this.saveFile();
        }
    }

    @Override
    public void saveFile() throws IOException {
        File f = new File(this.filePath);
        if (f.isFile()) {
            FileUtils.forceDelete(f);
        }
        this.professores.stream().forEach(item -> {
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
