package com.sentinel.common.exception;

import com.sentinel.common.response.ApiErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.time.LocalDateTime;
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

    @ExceptionHandler(UserAlreadyDeletedException.class)
    public ResponseEntity<ApiErrorResponse> handleUserAlreadyDeletedException(UserAlreadyDeletedException e, HttpServletRequest request) {
        return build(
                HttpStatus.GONE,  // 410 Gone - resource no longer exists
                "USER_ALREADY_DELETED",
                e.getMessage(),
                request,
                null
        );
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ApiErrorResponse> handleUserAlreadyExistsException(UserAlreadyExistsException e, HttpServletRequest request) {
        return build(
                HttpStatus.IM_USED,  // 410 Gone - resource no longer exists
                "USER_ALREADY_EXIST",
                e.getMessage(),
                request,
                null
        );
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ApiErrorResponse> handleEmailAlreadyExists(EmailAlreadyExistsException ex, HttpServletRequest request) {

        return build(
                HttpStatus.CONFLICT,  // 410 Gone - resource no longer exists
                "EMAIL_ALREADY_REGISTERED",
                ex.getMessage(),
                request,
                null
        );
    }

    @ExceptionHandler(InvalidOperationException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidOperationException(InvalidOperationException e, HttpServletRequest request) {
        return build(
                HttpStatus.BAD_REQUEST,
                "INVALID_OPERATION",
                e.getMessage(),
                request,
                null
        );
    }

    // Catch-all for unexpected exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleGenericException(Exception e, HttpServletRequest request) {
        return build(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "INTERNAL_SERVER_ERROR",
                "An unexpected error occurred",
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
