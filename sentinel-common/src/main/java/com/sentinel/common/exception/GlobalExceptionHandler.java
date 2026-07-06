package com.sentinel.common.exception;

import com.sentinel.common.response.ApiErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request) {
        return build(
                HttpStatus.NOT_FOUND,
                "RESOURCE_NOT_FOUND",
                ex.getMessage(),
                request,
                null
        );
    }

    @ExceptionHandler(InvalidAccountStatusException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidAccountStatusException(InvalidAccountStatusException e, HttpServletRequest request) {
        return build(
                HttpStatus.BAD_REQUEST,
                "INVALID REQUEST",
                e.getMessage(),
                request,
                null
        );
    }

    private ResponseEntity<ApiErrorResponse> build(
            HttpStatus status,
            String code,
            String message,
            HttpServletRequest request,
            List<ApiErrorResponse.FieldError> errors) {

        ApiErrorResponse response =
                ApiErrorResponse.builder()
                        .timestamp(Instant.now())
                        .status(status.value())
                        .error(status.getReasonPhrase())
                        .code(code)
                        .message(message)
                        .path(request.getRequestURI())
                        .errors(errors)
                        .build();

        return ResponseEntity.status(status).body(response);
    }
}
