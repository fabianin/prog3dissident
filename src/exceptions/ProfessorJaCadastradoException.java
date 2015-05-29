package exceptions;

/**
 *
 * @author Elias Júnior
 */
public class ProfessorJaCadastradoException extends Exception {

    public ProfessorJaCadastradoException() {
    }

    public ProfessorJaCadastradoException(String message) {
        super(message);
    }

    public ProfessorJaCadastradoException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProfessorJaCadastradoException(Throwable cause) {
        super(cause);
    }

    public ProfessorJaCadastradoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
