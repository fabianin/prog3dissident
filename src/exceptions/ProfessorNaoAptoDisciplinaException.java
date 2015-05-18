/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Elias Júnior
 */
public class ProfessorNaoAptoDisciplinaException extends Exception {

    public ProfessorNaoAptoDisciplinaException() {
    }

    public ProfessorNaoAptoDisciplinaException(String message) {
        super(message);
    }

    public ProfessorNaoAptoDisciplinaException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProfessorNaoAptoDisciplinaException(Throwable cause) {
        super(cause);
    }

    public ProfessorNaoAptoDisciplinaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
