package com.sentinel.identity.authorization.service;

import com.sentinel.common.exception.InvalidOperationException;
import com.sentinel.common.exception.ResourceNotFoundException;
import com.sentinel.identity.authorization.dto.request.CreatePermissionRequest;
import com.sentinel.identity.authorization.dto.request.UpdatePermissionRequest;
import com.sentinel.identity.authorization.dto.response.PermissionResponse;
import com.sentinel.identity.authorization.entity.Permission;
import com.sentinel.identity.authorization.mapper.PermissionMapper;
import com.sentinel.identity.authorization.repository.PermissionRepository;
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
public class PermissionService {

    private static final Logger log = LoggerFactory.getLogger(PermissionService.class);
    private final PermissionRepository permissionRepository;

    @Transactional
    public PermissionResponse createPermission(CreatePermissionRequest request) {
        log.info("Attempting to create permission with code: {}", request.getCode());

        if (permissionRepository.existsByCode(request.getCode())) {
            log.warn("Permission creation failed: Permission with code '{}' already exists.", request.getCode());
            throw new InvalidOperationException("Permission with code '" + request.getCode() + "' already exists.");
        }

        Permission permission = PermissionMapper.toPermissionEntity(request);
        // Assuming createdBy is set by a security context or default value
        // permission.setCreatedBy(getCurrentUserId());
        permission.setVersion(0L); // Initial version

        Permission savedPermission = permissionRepository.save(permission);
        log.info("Permission created successfully with ID: {}", savedPermission.getId());
        return PermissionMapper.toPermissionResponse(savedPermission);
    }

    public List<PermissionResponse> getAllPermissions() {
        log.debug("Fetching all permissions");
        return permissionRepository.findAll().stream()
                .map(PermissionMapper::toPermissionResponse)
                .collect(Collectors.toList());
    }

    public PermissionResponse getPermissionById(UUID id) {
        log.debug("Fetching permission with ID: {}", id);
        Permission permission = permissionRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Permission not found with ID: {}", id);
                    return new ResourceNotFoundException("Permission", id.toString());
                });
        return PermissionMapper.toPermissionResponse(permission);
    }

    @Transactional
    public PermissionResponse updatePermission(UUID id, UpdatePermissionRequest request) {
        log.info("Attempting to update permission with ID: {}", id);
        Permission existingPermission = permissionRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Permission not found for update with ID: {}", id);
                    return new ResourceNotFoundException("Permission", id.toString());
                });

        if (!existingPermission.getCode().equals(request.getCode()) && permissionRepository.existsByCode(request.getCode())) {
            log.warn("Permission update failed: Another permission with code '{}' already exists.", request.getCode());
            throw new InvalidOperationException("Permission with code '" + request.getCode() + "' already exists.");
        }

        PermissionMapper.updatePermissionEntity(existingPermission, request);
        existingPermission.setUpdatedAt(Instant.now());
        // Assuming updatedBy is set by a security context or default value
        // existingPermission.setUpdatedBy(getCurrentUserId());
        existingPermission.setVersion(existingPermission.getVersion() + 1); // Increment version for optimistic locking

        Permission updatedPermission = permissionRepository.save(existingPermission);
        log.info("Permission with ID: {} updated successfully.", updatedPermission.getId());
        return PermissionMapper.toPermissionResponse(updatedPermission);
    }

    @Transactional
    public void deletePermission(UUID id) {
        log.info("Attempting to delete permission with ID: {}", id);
        Permission permission = permissionRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Permission not found for deletion with ID: {}", id);
                    return new ResourceNotFoundException("Permission", id.toString());
                });

        // Soft delete
        permission.setDeletedAt(Instant.now());
        permission.setUpdatedAt(Instant.now());
        // permission.setUpdatedBy(getCurrentUserId());
        permission.setVersion(permission.getVersion() + 1);
        permissionRepository.save(permission);
        log.info("Permission with ID: {} soft-deleted successfully.", id);
    }
}