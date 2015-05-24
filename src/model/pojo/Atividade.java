/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import exceptions.NotaJaCadastradaException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author Fabiano
 */
public class Atividade {

    private final ArrayList<Integer> notas;
    private final String nome;
    private final Calendar data;
    private final String tipo;
    private final int id;

    /**
     * Construtor para atividade
     *
     * @param nome Nome da atividade
     * @param data Data da atividade
     * @param tipo Tipo da atividade
     * @throws NullPointerException Caso tenha valores null nos argumentos
     * @throws IllegalArgumentException Caso tenha conteúdos em branco ou
     * valores inválidos
     */
    public Atividade(String nome, Calendar data, String tipo) throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(nome, "Nome não pode ser null."); // não permite nome null
        Objects.requireNonNull(data, "Data não pode ser null."); // não permite data null
        Objects.requireNonNull(tipo, "Tipo não pode ser null."); // não permite tipo null
        if (nome.isEmpty()) { // não permite nome em branco
            throw new IllegalArgumentException("Nome não pode estar em branco.");
        } else if (tipo.isEmpty()) { // não permite tipo em branco
            throw new IllegalArgumentException("Tipo não pode estar em branco.");
        }
        this.nome = nome; // define nome
        this.data = data; // define data
        this.tipo = tipo; // define tipo
        this.notas = new ArrayList<>(); // cria nova lista vazia para as notas
        this.id = this.hashCode();
    }

    /**
     * Adicionar uma nota na lista
     *
     * @param nota Nota para ser adicionada
     * @throws NotaJaCadastradaException
     * @throws NullPointerException
     */
    public void addNota(int nota) throws NotaJaCadastradaException, NullPointerException {
        Objects.requireNonNull(nota); // não premite nota null
        if (!notas.contains(nota)) { // caso a nota não tenha sido cadastrada
            this.notas.add(nota); // adiciona nota na lista
        } else { // caso já tenha cadastrado, lança exception
            throw new NotaJaCadastradaException("Você não pode cadastrar uma nota duas vezes."); // lança exception
        }
    }

    /**
     * Obtém notas da atividade
     *
     * @return Notas da atividade
     */
    public ArrayList<Integer> getNotas() {
        return this.notas;
    }

    /**
     * Obtém nome da atividade
     *
     * @return Nome da atividade
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém data da atividade
     *
     * @return Data da atividade
     */
    public Calendar getData() {
        return data;
    }

    /**
     * Obtém tipo da atividade
     *
     * @return Tipo da atividade
     */
    public String getTipo() {
        return tipo;
    }

    @Override
    public final int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.notas);
        hash = 37 * hash + Objects.hashCode(this.nome);
        hash = 37 * hash + Objects.hashCode(this.data);
        hash = 37 * hash + Objects.hashCode(this.tipo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Atividade other = (Atividade) obj;
        
        return this.hashCode() == other.hashCode();
    }

}
