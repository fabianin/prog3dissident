package exceptions;

/**
 *
 * @author Elias Júnior
 */
public class FaltaJaCadastradaException extends Exception {

    public FaltaJaCadastradaException() {
    }

    public FaltaJaCadastradaException(String message) {
        super(message);
    }

    public FaltaJaCadastradaException(String message, Throwable cause) {
        super(message, cause);
    }

    public FaltaJaCadastradaException(Throwable cause) {
        super(cause);
    }

    public FaltaJaCadastradaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
