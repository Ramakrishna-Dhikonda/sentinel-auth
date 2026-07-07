package com.sentinel.identity.authorization.mapper;

import com.sentinel.identity.authorization.dto.request.CreatePermissionRequest;
import com.sentinel.identity.authorization.dto.request.UpdatePermissionRequest;
import com.sentinel.identity.authorization.dto.response.PermissionResponse;
import com.sentinel.identity.authorization.entity.Permission;

import java.time.Instant;

public class PermissionMapper {

    public static Permission toPermissionEntity(CreatePermissionRequest request) {
        Permission permission = new Permission();
        permission.setName(request.getName());
        permission.setCode(request.getCode());
        permission.setDescription(request.getDescription());
        permission.setCreatedAt(Instant.now());
        // createdBy, version will be set in service
        return permission;
    }

    public static PermissionResponse toPermissionResponse(Permission permission) {
        return PermissionResponse.builder()
                .id(permission.getId())
                .name(permission.getName())
                .code(permission.getCode())
                .description(permission.getDescription())
                .createdAt(permission.getCreatedAt())
                .createdBy(permission.getCreatedBy())
                .updatedAt(permission.getUpdatedAt())
                .updatedBy(permission.getUpdatedBy())
                .build();
    }

    // Optional: for updating an existing entity from a request
    public static void updatePermissionEntity(Permission permission, UpdatePermissionRequest request) {
        permission.setName(request.getName());
        permission.setCode(request.getCode());
        permission.setDescription(request.getDescription());
        // updatedAt, updatedBy, version will be set in service
    }
}