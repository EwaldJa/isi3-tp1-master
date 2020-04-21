package calculette_tp1a_q2.utils.exceptions;

public class IncorrectOperatorException extends Exception {

    public IncorrectOperatorException(String message) {
        super(message);
    }

    public IncorrectOperatorException(String message, Exception cause) {
        super(message, cause);
    }
}
