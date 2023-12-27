package com.gbs.apiaddress.api;

import com.gbs.apiaddress.api.dto.ApiError;
import com.gbs.apiaddress.api.dto.ValidationError;
import com.gbs.apiaddress.shared.exceptions.DatabaseNotFoundException;
import com.gbs.apiaddress.shared.exceptions.InvalidCepException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;

import java.time.Instant;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(DatabaseNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError databaseError(DatabaseNotFoundException e, HttpServletRequest request) {
        log.warn("GlobalExceptionHandler::DatabaseNotFoundException", e);
        return ApiError.builder()
                .error("Resource not found")
                .mensage(e.getMessage())
                .path(request.getRequestURI())
                .timestamp(Instant.now())
                .status(HttpStatus.NOT_FOUND.value())
                .build();
    }
    @ExceptionHandler(InvalidCepException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError restClientException(InvalidCepException e, HttpServletRequest request) {
        log.warn("GlobalExceptionHandler::InvalidCepException", e);
        return ApiError.builder()
                .error("Rest Resource not found")
                .mensage(e.getMessage())
                .path(request.getRequestURI())
                .timestamp(Instant.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
    }

    @ExceptionHandler(RestClientException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError restClientException(RestClientException e, HttpServletRequest request) {
        log.warn("GlobalExceptionHandler::Exception", e);
        return ApiError.builder()
                .error("Rest Resource not found")
                .mensage(e.getMessage())
                .path(request.getRequestURI())
                .timestamp(Instant.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError geralException(MethodArgumentNotValidException e, HttpServletRequest request) {
        log.warn("GlobalExceptionHandler::MethodArgumentNotValidException", e);

        ValidationError error = new ValidationError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setError("Method Argument NotValid Exception");
        error.setMensage(e.getMessage());
        error.setPath(request.getRequestURI());

        for( FieldError f : e.getBindingResult().getFieldErrors()) {
            error.addError(f.getField(), f.getDefaultMessage());
        }

        return error;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError geralException(Exception e, HttpServletRequest request) {
        log.warn("GlobalExceptionHandler::Exception", e);
        return ApiError.builder()
                .error("Resource not found")
                .mensage(e.getMessage())
                .path(request.getRequestURI())
                .timestamp(Instant.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
    }



}
