package com.gamesrental.api.config;

import com.gamesrental.api.exception.ApiException;
import com.gamesrental.api.exception.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> handleApiException(ApiException ex, HttpServletRequest req) {

        ErrorResponse error = ErrorResponse.builder()
                .timestamp(Instant.now())
                .status(ex.getStatus().value())
                .error(ex.getStatus().getReasonPhrase())
                .message(ex.getMessage())
                .path(req.getRequestURI()).build();

        return ResponseEntity.status(ex.getStatus()).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpServletRequest req) {

        String message = ex.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .findFirst()
                .orElse("Invalid request");

        ErrorResponse response = new ErrorResponse(
                Instant.now(),
                400,
                "Bad Request",
                message,
                req.getRequestURI()
        );

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex, HttpServletRequest req) {
        ErrorResponse error = ErrorResponse.builder()
                .timestamp(Instant.now())
                .status(500)
                .error("Internal Server Error")
                .message(ex.getMessage())
                .path(req.getRequestURI()).build();

        return ResponseEntity.status(500).body(error);
    }


}