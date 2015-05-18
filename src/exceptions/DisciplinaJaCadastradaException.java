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
public class DisciplinaJaCadastradaException extends Exception {

    public DisciplinaJaCadastradaException() {
    }

    public DisciplinaJaCadastradaException(String message) {
        super(message);
    }

    public DisciplinaJaCadastradaException(String message, Throwable cause) {
        super(message, cause);
    }

    public DisciplinaJaCadastradaException(Throwable cause) {
        super(cause);
    }

    public DisciplinaJaCadastradaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
