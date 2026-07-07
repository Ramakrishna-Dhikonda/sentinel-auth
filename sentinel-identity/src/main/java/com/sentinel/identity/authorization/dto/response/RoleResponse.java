package com.sentinel.identity.authorization.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Builder
public class RoleResponse {
    private UUID id;
    private String name;
    private String code;
    private String description;
    private Boolean systemRole;
    private Instant createdAt;
    private UUID createdBy;
    private Instant updatedAt;
    private UUID updatedBy;
}