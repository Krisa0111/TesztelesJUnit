package uni.obuda.testaut.java.bookstore.domain.exception;

public class ValidationException extends RuntimeException{

    private String message;

    public ValidationException (String message) {
        this.message = message;
    }

    @Override
    public String getMessage () {
        return message;
    }
}
