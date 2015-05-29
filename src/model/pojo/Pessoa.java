package model.pojo;

/**
 *
 * @author Fabiano
 */
public abstract class Pessoa {

    final String nome;
    private final long cpf;

    /**
     * Construtor da pessoa
     *
     * @param nome Nome da pessoa
     * @param cpf CPF da pessoa
     * @throws IllegalArgumentException
     */
    public Pessoa(String nome, long cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    /**
     * Obtém nome da pessoa
     *
     * @return Nome da pessoa
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém CPFda pessoa
     *
     * @return CPF da pessoa
     */
    public long getCpf() {
        return cpf;
    }

}
