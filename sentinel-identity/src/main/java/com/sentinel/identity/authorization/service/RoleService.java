package com.sentinel.identity.authorization.service;

import com.sentinel.common.exception.InvalidOperationException;
import com.sentinel.common.exception.ResourceNotFoundException;
import com.sentinel.identity.authorization.dto.request.CreateRoleRequest;
import com.sentinel.identity.authorization.dto.request.UpdateRoleRequest;
import com.sentinel.identity.authorization.dto.response.RoleResponse;
import com.sentinel.identity.authorization.entity.Role;
import com.sentinel.identity.authorization.mapper.RoleMapper;
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
public class RoleService {

    private static final Logger log = LoggerFactory.getLogger(RoleService.class);
    private final RoleRepository roleRepository;

    @Transactional
    public RoleResponse createRole(CreateRoleRequest request) {
        log.info("Attempting to create role with code: {}", request.getCode());

        if (roleRepository.existsByCode(request.getCode())) {
            log.warn("Role creation failed: Role with code '{}' already exists.", request.getCode());
            throw new InvalidOperationException("Role with code '" + request.getCode() + "' already exists.");
        }

        Role role = RoleMapper.toRoleEntity(request);
        role.setCreatedAt(Instant.now());
        // Assuming createdBy is set by a security context or default value
        // role.setCreatedBy(getCurrentUserId());
        role.setSystemRole(request.getSystemRole() != null ? request.getSystemRole() : false); // Default to false if not provided
        role.setVersion(0L); // Initial version

        Role savedRole = roleRepository.save(role);
        log.info("Role created successfully with ID: {}", savedRole.getId());
        return RoleMapper.toRoleResponse(savedRole);
    }

    public List<RoleResponse> getAllRoles() {
        log.debug("Fetching all roles");
        return roleRepository.findAll().stream()
                .map(RoleMapper::toRoleResponse)
                .collect(Collectors.toList());
    }

    public RoleResponse getRoleById(UUID id) {
        log.debug("Fetching role with ID: {}", id);
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Role not found with ID: {}", id);
                    return new ResourceNotFoundException("Role", id.toString());
                });
        return RoleMapper.toRoleResponse(role);
    }

    @Transactional
    public RoleResponse updateRole(UUID id, UpdateRoleRequest request) {
        log.info("Attempting to update role with ID: {}", id);
        Role existingRole = roleRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Role not found for update with ID: {}", id);
                    return new ResourceNotFoundException("Role", id.toString());
                });

        if (!existingRole.getCode().equals(request.getCode()) && roleRepository.existsByCode(request.getCode())) {
            log.warn("Role update failed: Another role with code '{}' already exists.", request.getCode());
            throw new InvalidOperationException("Role with code '" + request.getCode() + "' already exists.");
        }

        existingRole.setName(request.getName());
        existingRole.setCode(request.getCode());
        existingRole.setDescription(request.getDescription());
        existingRole.setSystemRole(request.getSystemRole() != null ? request.getSystemRole() : existingRole.getSystemRole());
        existingRole.setUpdatedAt(Instant.now());
        // Assuming updatedBy is set by a security context or default value
        // existingRole.setUpdatedBy(getCurrentUserId());
        existingRole.setVersion(existingRole.getVersion() + 1); // Increment version for optimistic locking

        Role updatedRole = roleRepository.save(existingRole);
        log.info("Role with ID: {} updated successfully.", updatedRole.getId());
        return RoleMapper.toRoleResponse(updatedRole);
    }

    @Transactional
    public void deleteRole(UUID id) {
        log.info("Attempting to delete role with ID: {}", id);
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Role not found for deletion with ID: {}", id);
                    return new ResourceNotFoundException("Role", id.toString());
                });

        // Soft delete
        role.setDeletedAt(Instant.now());
        role.setUpdatedAt(Instant.now());
        // role.setUpdatedBy(getCurrentUserId());
        role.setVersion(role.getVersion() + 1);
        roleRepository.save(role);
        log.info("Role with ID: {} soft-deleted successfully.", id);
    }
}