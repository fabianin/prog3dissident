package model.pojo;

import java.util.Objects;

/**
 *
 * @author Fabiano
 */
public class Falta {

    private final int aluno;
    private final int faltas;
    private final int id;
    private final int turma;

    /**
     * Construtor da falta
     *
     * @param aluno Aluno relacionado a falta
     * @param faltas Faltas deste aluno
     * @param turma ID da turma
     * @throws IllegalArgumentException
     * @throws NullPointerException
     */
    public Falta(int aluno, int faltas, int turma) throws IllegalArgumentException {
        if (faltas < 0) {
            throw new IllegalArgumentException("Faltas deve ser um valor positivo.");
        }
        this.aluno = aluno;
        this.faltas = faltas;
        this.id = this.hashCode();
        this.turma = turma;
    }

    /**
     * Obtém as faltas do aluno
     *
     * @return número de faltas
     */
    public int getFaltas() {
        return this.faltas;
    }

    public int getTurma() {
        return turma;
    }

    /**
     * Obtém aluno relacionado a falta
     *
     * @return Aluno
     */
    public int getAluno() {
        return aluno;
    }

    @Override
    public final int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.aluno);
        hash = 47 * hash + this.faltas;
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
        final Falta other = (Falta) obj;
        if (this.aluno != other.aluno) {
            return false;
        }
        if (this.faltas != other.faltas) {
            return false;
        }
        if (this.turma != other.turma) {
            return false;
        }
        return true;
    }

}
