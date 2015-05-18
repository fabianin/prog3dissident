/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Fabiano
 */
public class AlunoJaCadastradoException extends Exception {

    public AlunoJaCadastradoException() {
    }

    public AlunoJaCadastradoException(String message) {
        super(message);
    }

    public AlunoJaCadastradoException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlunoJaCadastradoException(Throwable cause) {
        super(cause);
    }
    
    
}
