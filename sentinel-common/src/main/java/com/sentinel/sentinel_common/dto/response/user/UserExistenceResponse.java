package com.sentinel.sentinel_common.dto.response.user;

import lombok.Builder;

import java.util.UUID;

@Builder
public record UserExistenceResponse (
        UUID userId,
        String email,
        boolean exist,
        boolean active,
        String message
) { }
