package com.sentinel.identity.authorization.mapper;

import com.sentinel.identity.authorization.dto.request.CreateRoleRequest;
import com.sentinel.identity.authorization.dto.response.RoleResponse;
import com.sentinel.identity.authorization.entity.Role;

public class RoleMapper {
    public static Role toRoleEntity(CreateRoleRequest request) {
        Role role = new Role();
        role.setCode(request.getCode());
        role.setSystemRole(request.getSystemRole() != null ? request.getSystemRole() : false); // Default to false if not provided
        return role;
    }

    public static RoleResponse toRoleResponse(Role savedRole) {
        return RoleResponse.builder()
                .id(savedRole.getId())
                .name(savedRole.getName())
                .code(savedRole.getCode())
                .description(savedRole.getDescription())
                .systemRole(savedRole.getSystemRole())
                .createdAt(savedRole.getCreatedAt())
                .createdBy(savedRole.getCreatedBy())
                .updatedAt(savedRole.getUpdatedAt())
                .updatedAt(savedRole.getUpdatedAt())
                .build();
    }
}
