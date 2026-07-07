package com.sentinel.identity.authorization.service;

import com.sentinel.common.exception.InvalidOperationException;
import com.sentinel.common.exception.ResourceNotFoundException;
import com.sentinel.identity.authorization.dto.request.AssignRolePermissionRequest;
import com.sentinel.identity.authorization.dto.response.RolePermissionResponse;
import com.sentinel.identity.authorization.entity.Permission;
import com.sentinel.identity.authorization.entity.Role;
import com.sentinel.identity.authorization.entity.RolePermission;
import com.sentinel.identity.authorization.mapper.RolePermissionMapper;
import com.sentinel.identity.authorization.repository.PermissionRepository;
import com.sentinel.identity.authorization.repository.RolePermissionRepository;
import com.sentinel.identity.authorization.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RolePermissionService {

    private static final Logger log = LoggerFactory.getLogger(RolePermissionService.class);
    private final RolePermissionRepository rolePermissionRepository;
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    @Transactional
    public RolePermissionResponse assignPermissionToRole(UUID roleId, AssignRolePermissionRequest request) {
        log.info("Attempting to assign permission ID: {} to role ID: {}", request.getPermissionId(), roleId);

        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> {
                    log.warn("Role not found with ID: {}", roleId);
                    return new ResourceNotFoundException("Role", roleId.toString());
                });

        Permission permission = permissionRepository.findById(request.getPermissionId())
                .orElseThrow(() -> {
                    log.warn("Permission not found with ID: {}", request.getPermissionId());
                    return new ResourceNotFoundException("Permission", request.getPermissionId().toString());
                });

        if (rolePermissionRepository.existsByRoleAndPermission(role, permission)) {
            log.warn("Permission ID: {} is already assigned to role ID: {}", request.getPermissionId(), roleId);
            throw new InvalidOperationException("Permission ID '" + request.getPermissionId() + "' is already assigned to role ID '" + roleId + "'");
        }

        RolePermission rolePermission = new RolePermission();
        rolePermission.setRole(role);
        rolePermission.setPermission(permission);
        rolePermission.setCreatedAt(Instant.now());
        // rolePermission.setCreatedBy(getCurrentUserId());
        rolePermission.setVersion(0L);

        RolePermission savedRolePermission = rolePermissionRepository.save(rolePermission);
        log.info("Permission ID: {} assigned to role ID: {} successfully. RolePermission ID: {}", request.getPermissionId(), roleId, savedRolePermission.getId());
        return RolePermissionMapper.toRolePermissionResponse(savedRolePermission);
    }

    public List<RolePermissionResponse> getRolePermissions(UUID roleId) {
        log.debug("Fetching permissions for role ID: {}", roleId);

        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> {
                    log.warn("Role not found with ID: {}", roleId);
                    return new ResourceNotFoundException("Role", roleId.toString());
                });

        return rolePermissionRepository.findByRole(role).stream()
                .map(RolePermissionMapper::toRolePermissionResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public void removePermissionFromRole(UUID roleId, UUID permissionId) {
        log.info("Attempting to remove permission ID: {} from role ID: {}", permissionId, roleId);

        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> {
                    log.warn("Role not found with ID: {}", roleId);
                    return new ResourceNotFoundException("Role", roleId.toString());
                });

        Permission permission = permissionRepository.findById(permissionId)
                .orElseThrow(() -> {
                    log.warn("Permission not found with ID: {}", permissionId);
                    return new ResourceNotFoundException("Permission", permissionId.toString());
                });

        RolePermission rolePermission = rolePermissionRepository.findByRoleAndPermission(role, permission)
                .orElseThrow(() -> {
                    log.warn("Permission ID: {} is not assigned to role ID: {}", permissionId, roleId);
                    return new ResourceNotFoundException("RolePermission", "role_id: " + roleId + ", permission_id: " + permissionId);
                });

        rolePermissionRepository.delete(rolePermission);
        log.info("Permission ID: {} removed from role ID: {} successfully.", permissionId, roleId);
    }
}