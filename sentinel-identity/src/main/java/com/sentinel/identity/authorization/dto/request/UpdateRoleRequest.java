package com.sentinel.identity.authorization.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateRoleRequest {
    @NotBlank(message = "Role name is required")
    @Size(max = 100, message = "Role name cannot exceed 100 characters")
    private String name;

    @NotBlank(message = "Role code is required")
    @Size(max = 50, message = "Role code cannot exceed 50 characters")
    private String code;

    @Size(max = 255, message = "Role description cannot exceed 255 characters")
    private String description;

    private Boolean systemRole; // Can be null for partial updates
}