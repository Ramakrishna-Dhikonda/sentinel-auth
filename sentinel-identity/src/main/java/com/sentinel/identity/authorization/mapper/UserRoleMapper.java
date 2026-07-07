package com.sentinel.identity.authorization.mapper;

import com.sentinel.identity.authorization.dto.response.UserRoleResponse;
import com.sentinel.identity.authorization.entity.UserRole;

public class UserRoleMapper {

    public static UserRoleResponse toUserRoleResponse(UserRole userRole) {
        return UserRoleResponse.builder()
                .id(userRole.getId())
                .userId(userRole.getUser().getId())
                .roleId(userRole.getRole().getId())
                .roleName(userRole.getRole().getName())
                .roleCode(userRole.getRole().getCode())
                .createdAt(userRole.getCreatedAt())
                .createdBy(userRole.getCreatedBy())
                .build();
    }
}