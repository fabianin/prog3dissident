package exceptions;

/**
 *
 * @author Elias Júnior
 */
public class NotaJaCadastradaException extends Exception {

    public NotaJaCadastradaException() {
    }

    public NotaJaCadastradaException(String message) {
        super(message);
    }

    public NotaJaCadastradaException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotaJaCadastradaException(Throwable cause) {
        super(cause);
    }

    public NotaJaCadastradaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
