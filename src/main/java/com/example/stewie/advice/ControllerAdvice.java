package com.example.stewie.advice;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author [mariohieu09]
 * @since [9/1/2024]
 */

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage<Map<String, String>> handleBindingException(MethodArgumentNotValidException ex, WebRequest webRequest){
        BindingResult bindingResult = ex.getBindingResult();
        Map<String, String> errors = new HashMap<>();

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return ErrorMessage.<Map<String, String>>builder()
                .data(errors)
                .status(400)
                .message("Error binding!")
                .build();
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleRuntimeException(Exception ex, WebRequest webRequest){
        return ErrorMessage.builder()
                .message(ex.getMessage())
                .status(400)
                .build();
    }
}
