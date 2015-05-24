/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.txt;

import exceptions.AlunoJaCadastradoException;
import exceptions.TurmaJaCadastradaException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import model.dao.AlunoDao;
import model.pojo.Aluno;
import model.pojo.Disciplina;
import model.pojo.Nota;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Elias Júnior
 */
public class AlunoDaoTxt implements AlunoDao {

    private final String filePath = "txtdatabase/alunos.txt";
    private final File file;
    private final ArrayList<Aluno> alunos;

    /**
     * Construtor do DAO
     */
    public AlunoDaoTxt() {
        this.file = new File(this.filePath);
        this.alunos = new ArrayList<>();
        this.initDao();
    }

    /**
     * Inicia o Dao na hora do construtor, lendo os dados já salvo e adicionando
     * nas variáveis
     */
    private void initDao() {
        try {
            List<String> conteudo = FileUtils.readLines(this.file, "UTF-8");
            conteudo.stream().filter(str -> !str.isEmpty()).forEach((String str) -> {
                try {
                    JSONObject objAluno = new JSONObject(str);
                    Aluno aluno;
                    aluno = DaoTxtUtils.createAlunoFromJSON(objAluno);
                    this.alunos.add(aluno);
                } catch (JSONException ex) {
                    Logger.getLogger(NotaDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
                } catch (TurmaJaCadastradaException ex) {
                    Logger.getLogger(DisciplinaDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(DisciplinaDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Aluno getAlunoById(int alunoId) {
        List<Aluno> alunos = this.alunos.stream().filter(aluno -> aluno.hashCode() == alunoId).collect(Collectors.toList());
        if (alunos.size() > 0) {
            return alunos.get(0);
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Aluno> getAlunos() {
        return this.alunos;
    }

    @Override
    public Aluno getAlunoByMatricula(long matricula) {
        List<Aluno> alunos = this.alunos.stream().filter(aluno -> aluno.getMatricula() == matricula).collect(Collectors.toList());
        if (alunos.size() > 0) {
            return alunos.get(0);
        } else {
            return null;
        }
    }

    @Override
    public void adicionaAluno(Aluno aluno) throws AlunoJaCadastradoException, IOException {
        if (this.alunos.contains(aluno)) {
            throw new AlunoJaCadastradoException();
        } else {
            this.alunos.add(aluno);
            this.saveFile();
        }
    }

    @Override
    public void saveFile() throws IOException {
        File f = new File(this.filePath);
        if (f.isFile()) {
            FileUtils.forceDelete(f);
        }
        this.alunos.stream().forEach(item -> {
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
