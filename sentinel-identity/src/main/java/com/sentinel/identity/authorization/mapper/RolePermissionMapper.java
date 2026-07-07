package com.sentinel.identity.authorization.mapper;

import com.sentinel.identity.authorization.dto.response.RolePermissionResponse;
import com.sentinel.identity.authorization.entity.RolePermission;

public class RolePermissionMapper {

    public static RolePermissionResponse toRolePermissionResponse(RolePermission rolePermission) {
        return RolePermissionResponse.builder()
                .id(rolePermission.getId())
                .roleId(rolePermission.getRole().getId())
                .roleName(rolePermission.getRole().getName())
                .roleCode(rolePermission.getRole().getCode())
                .permissionId(rolePermission.getPermission().getId())
                .permissionName(rolePermission.getPermission().getName())
                .permissionCode(rolePermission.getPermission().getCode())
                .createdAt(rolePermission.getCreatedAt())
                .createdBy(rolePermission.getCreatedBy())
                .build();
    }
}