package com.sentinel.sentinel_common.dto.response;

import com.sentinel.sentinel_common.enums.AccountStatus;
import lombok.Builder;

import java.time.Instant;
import java.util.UUID;

@Builder
public record UserResponse (
    UUID userId,
    String firstName,
    String lastName,
    String email,
    AccountStatus status,
    Boolean isEmailVerified,
    Instant createdAt
) { }
