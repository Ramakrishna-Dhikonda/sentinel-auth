package com.sentinel.common.response;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Builder
@Getter
// FIXME: @JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private final boolean success;
    private final String message;
    private final T data;
    private final Object errors;
    @Builder.Default
    private final Instant timestamp = Instant.now();

}
