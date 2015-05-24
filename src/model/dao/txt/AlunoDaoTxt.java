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
import java.util.Objects;
import java.util.stream.Collectors;
import model.dao.AlunoDao;
import model.pojo.Aluno;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Elias Júnior
 */
public class AlunoDaoTxt implements AlunoDao {

    private Integer lastId;
    private final String filePath;
    private final File file;
    private List<String> fileContent;

    public AlunoDaoTxt() {
        this.filePath = "txtdatabase/alunos.txt";
        this.file = new File(this.filePath);
        this.lastId = 0;
        try {
            this.fileContent = FileUtils.readLines(this.file, "UTF-8");
            this.defLastId();
        } catch (IOException e) {
            System.out.println("Não encontrado");
        }
    }

    private void setLastId(Integer id) {
        this.lastId = id;
    }

    private void setLastId(String id) {
        this.lastId = new Integer(id);
    }

    private void defLastId() {
        this.fileContent.stream().filter(str -> !str.isEmpty()).forEach((String str) -> this.setLastId(getLineIndex(str, 0)));
    }

    private String getLineIndex(String line, int index) {
        String[] colunas = line.split(";");
        if (colunas.length > index) {
            return colunas[index];
        } else {
            return null;
        }
    }

    private void saveDatabase() throws IOException {
        FileUtils.forceDelete(this.file);
        FileUtils.writeLines(this.file, "UTF-8", this.fileContent.stream().filter(str -> !str.isEmpty()).collect(Collectors.toList()));
    }

    private String parseAluno(Aluno aluno) {
        String parse = this.lastId + ";" + aluno.getMatricula() + ";" + aluno.getNome() + ";" + aluno.getCpf();
        return parse;
    }

    @Override
    public Aluno getAlunoByID(Integer id) {
        Objects.requireNonNull(id, "ID não pode ser NULL");
        for (String line : this.fileContent) {
            if (!line.isEmpty()) {
                String[] colunas = line.split(";");
                if (colunas[0].equals(id.toString())) {
                    long matricula = Long.parseLong(colunas[1]);
                    String nome = colunas[2];
                    long cpf = Long.parseLong(colunas[3]);
                    Aluno aluno = new Aluno(matricula, nome, cpf);
                    return aluno;
                }
            }
        }
        return null;
    }

    @Override
    public Integer adicionaAluno(Aluno aluno) throws IllegalArgumentException {
        if(aluno == null){
            throw new IllegalArgumentException("this method can't recieve NULL");
        }
        if (this.getAlunos().contains(aluno)) {
            return null;
        } else {
            this.lastId++;
            this.fileContent.add(this.parseAluno(aluno));
            return this.lastId;
        }
    }

    @Override
    public ArrayList<Aluno> getAlunos() {
        ArrayList<Aluno> alunos = new ArrayList<>();
        for (String line : this.fileContent) {
            if(line.isEmpty()){
                return null;
            }
            if (!line.isEmpty()) {
                String[] colunas = line.split(";");
                long matricula = Long.parseLong(colunas[1]);
                String nome = colunas[2];
                long cpf = Long.parseLong(colunas[3]);
                Aluno aluno = new Aluno(matricula, nome, cpf);
                alunos.add(aluno);
            }
        }
        return alunos;
    }

}
