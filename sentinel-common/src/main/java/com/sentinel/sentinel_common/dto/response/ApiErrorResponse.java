package com.sentinel.sentinel_common.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.validation.FieldError;

import java.time.Instant;
import java.util.Collections;
import java.util.List;

@Builder
public record ApiErrorResponse(
        Instant timestamp,
        int status,
        String error,
        String code,
        String message,
        String path,
        List<FieldError> errors
) {

    @Builder
    public record FieldError(
            String field,
            String message
    ) {}
}