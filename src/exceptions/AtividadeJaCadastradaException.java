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
public class AtividadeJaCadastradaException extends Exception {

    public AtividadeJaCadastradaException() {
    }

    public AtividadeJaCadastradaException(String message) {
        super(message);
    }

    public AtividadeJaCadastradaException(String message, Throwable cause) {
        super(message, cause);
    }

    public AtividadeJaCadastradaException(Throwable cause) {
        super(cause);
    }

    public AtividadeJaCadastradaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
