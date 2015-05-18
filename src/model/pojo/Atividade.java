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

    private final ArrayList<Nota> notas;
    private final String nome;
    private final Calendar data;
    private final String tipo;

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
    }

    /**
     * Adicionar uma nota na lista
     *
     * @param nota Nota para ser adicionada
     * @throws NotaJaCadastradaException
     * @throws NullPointerException
     */
    public void adicionarNota(Nota nota) throws NotaJaCadastradaException, NullPointerException {
        Objects.requireNonNull(nota); // não premite nota null
        if (notas.indexOf(nota) == -1) { // caso a nota não tenha sido cadastrada
            this.notas.add(nota); // adiciona nota na lista
        } else { // caso já tenha cadastrado, lança exception
            throw new NotaJaCadastradaException("Você não pode cadastrar uma nota duas vezes."); // lança exception
        }
    }

}
