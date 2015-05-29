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
