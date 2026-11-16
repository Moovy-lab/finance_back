package project.personal.finance.exception;

public class MontantNegativeException extends RuntimeException{
    public MontantNegativeException(String message) {
        super(message);
    }
}
