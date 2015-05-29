package exceptions;

/**
 *
 * @author Elias Júnior
 */
public class ProfessorNaoAptoDisciplinaException extends Exception {

    public ProfessorNaoAptoDisciplinaException() {
    }

    public ProfessorNaoAptoDisciplinaException(String message) {
        super(message);
    }

    public ProfessorNaoAptoDisciplinaException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProfessorNaoAptoDisciplinaException(Throwable cause) {
        super(cause);
    }

    public ProfessorNaoAptoDisciplinaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
