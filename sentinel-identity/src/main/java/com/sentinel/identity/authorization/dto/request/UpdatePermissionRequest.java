package com.sentinel.identity.authorization.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdatePermissionRequest {
    @NotBlank(message = "Permission name is required")
    @Size(max = 100, message = "Permission name cannot exceed 100 characters")
    private String name;

    @NotBlank(message = "Permission code is required")
    @Size(max = 50, message = "Permission code cannot exceed 50 characters")
    private String code;

    @Size(max = 255, message = "Permission description cannot exceed 255 characters")
    private String description;
}