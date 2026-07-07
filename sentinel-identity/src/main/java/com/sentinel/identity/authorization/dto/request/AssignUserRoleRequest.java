package com.sentinel.identity.authorization.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class AssignUserRoleRequest {
    @NotNull(message = "Role ID is required")
    private UUID roleId;
}