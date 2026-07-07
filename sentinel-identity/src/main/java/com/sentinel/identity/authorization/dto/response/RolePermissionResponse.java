package com.sentinel.identity.authorization.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Builder
public class RolePermissionResponse {
    private UUID id;
    private UUID roleId;
    private String roleName;
    private String roleCode;
    private UUID permissionId;
    private String permissionName;
    private String permissionCode;
    private Instant createdAt;
    private UUID createdBy;
}