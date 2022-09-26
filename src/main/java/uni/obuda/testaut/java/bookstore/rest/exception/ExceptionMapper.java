package uni.obuda.testaut.java.bookstore.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import uni.obuda.testaut.java.bookstore.domain.exception.BadRequestException;
import uni.obuda.testaut.java.bookstore.domain.exception.ExceptionResponseBody;
import uni.obuda.testaut.java.bookstore.domain.exception.ValidationException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionMapper {

    @ExceptionHandler({BadRequestException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionResponseBody mapBadRequestException(BadRequestException exception) {
        return new ExceptionResponseBody(exception.getMessage());
    }

    @ExceptionHandler({ValidationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionResponseBody mapValidationException(ValidationException exception) {
        return new ExceptionResponseBody(exception.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionResponseBody mapMethodArgumentNotValidException(MethodArgumentNotValidException exception) {

        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ExceptionResponseBody(errors.toString());
    }


}
