package com.sentinel.common.response;

import lombok.Builder;

import java.time.Instant;
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