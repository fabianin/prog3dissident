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
public class TurmaNaoEncontradaException extends Exception {

    public TurmaNaoEncontradaException() {
    }

    public TurmaNaoEncontradaException(String message) {
        super(message);
    }

    public TurmaNaoEncontradaException(String message, Throwable cause) {
        super(message, cause);
    }

    public TurmaNaoEncontradaException(Throwable cause) {
        super(cause);
    }

    public TurmaNaoEncontradaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
