package com.sentinel.identity.authorization.service;

import com.sentinel.common.exception.InvalidOperationException;
import com.sentinel.common.exception.ResourceNotFoundException;
import com.sentinel.identity.authorization.dto.request.AssignUserRoleRequest;
import com.sentinel.identity.authorization.dto.response.UserRoleResponse;
import com.sentinel.identity.authorization.entity.Role;
import com.sentinel.identity.authorization.entity.UserRole;
import com.sentinel.identity.authorization.mapper.UserRoleMapper;
import com.sentinel.identity.authorization.repository.RoleRepository;
import com.sentinel.identity.authorization.repository.UserRoleRepository;
import com.sentinel.identity.identity.entity.User;
import com.sentinel.identity.identity.repository.UserRepository;
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
public class UserRoleService {

    private static final Logger log = LoggerFactory.getLogger(UserRoleService.class);
    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Transactional
    public UserRoleResponse assignRoleToUser(UUID userId, AssignUserRoleRequest request) {
        log.info("Attempting to assign role ID: {} to user ID: {}", request.getRoleId(), userId);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> {
                    log.warn("User not found with ID: {}", userId);
                    return new ResourceNotFoundException("User", userId.toString());
                });

        Role role = roleRepository.findById(request.getRoleId())
                .orElseThrow(() -> {
                    log.warn("Role not found with ID: {}", request.getRoleId());
                    return new ResourceNotFoundException("Role", request.getRoleId().toString());
                });

        if (userRoleRepository.existsByUserAndRole(user, role)) {
            log.warn("Role ID: {} is already assigned to user ID: {}", request.getRoleId(), userId);
            throw new InvalidOperationException("Role ID '" + request.getRoleId() + "' is already assigned to user ID '" + userId + "'");
        }

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        userRole.setCreatedAt(Instant.now());
        // userRole.setCreatedBy(getCurrentUserId());
        userRole.setVersion(0L);

        UserRole savedUserRole = userRoleRepository.save(userRole);
        log.info("Role ID: {} assigned to user ID: {} successfully. UserRole ID: {}", request.getRoleId(), userId, savedUserRole.getId());
        return UserRoleMapper.toUserRoleResponse(savedUserRole);
    }

    public List<UserRoleResponse> getUserRoles(UUID userId) {
        log.debug("Fetching roles for user ID: {}", userId);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> {
                    log.warn("User not found with ID: {}", userId);
                    return new ResourceNotFoundException("User", userId.toString());
                });

        return userRoleRepository.findByUser(user).stream()
                .map(UserRoleMapper::toUserRoleResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public void removeRoleFromUser(UUID userId, UUID roleId) {
        log.info("Attempting to remove role ID: {} from user ID: {}", roleId, userId);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> {
                    log.warn("User not found with ID: {}", userId);
                    return new ResourceNotFoundException("User", userId.toString());
                });

        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> {
                    log.warn("Role not found with ID: {}", roleId);
                    return new ResourceNotFoundException("Role", roleId.toString());
                });

        UserRole userRole = userRoleRepository.findByUserAndRole(user, role)
                .orElseThrow(() -> {
                    log.warn("Role ID: {} is not assigned to user ID: {}", roleId, userId);
                    return new ResourceNotFoundException("UserRole", "user_id: " + userId + ", role_id: " + roleId);
                });

        userRoleRepository.delete(userRole);
        log.info("Role ID: {} removed from user ID: {} successfully.", roleId, userId);
    }
}