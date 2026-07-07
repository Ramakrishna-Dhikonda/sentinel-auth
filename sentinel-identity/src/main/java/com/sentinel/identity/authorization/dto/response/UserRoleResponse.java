package com.sentinel.identity.authorization.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Builder
public class UserRoleResponse {
    private UUID id;
    private UUID userId;
    private UUID roleId;
    private String roleName;
    private String roleCode;
    private Instant createdAt;
    private UUID createdBy;
}