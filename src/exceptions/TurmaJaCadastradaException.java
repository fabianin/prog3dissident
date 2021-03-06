package exceptions;

/**
 *
 * @author Elias Júnior
 */
public class TurmaJaCadastradaException extends Exception {

    public TurmaJaCadastradaException() {
    }

    public TurmaJaCadastradaException(String message) {
        super(message);
    }

    public TurmaJaCadastradaException(String message, Throwable cause) {
        super(message, cause);
    }

    public TurmaJaCadastradaException(Throwable cause) {
        super(cause);
    }

    public TurmaJaCadastradaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
