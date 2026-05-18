package org.example.english_word.common;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleValidException(MethodArgumentNotValidException e) {

        return e.getBindingResult()
                .getFieldError()
                .getDefaultMessage();
    }
}
