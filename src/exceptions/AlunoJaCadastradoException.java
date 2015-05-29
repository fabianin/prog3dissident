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
