package com.sentinel.identity.authorization.controller;

import com.sentinel.common.response.ApiResponse;
import com.sentinel.identity.authorization.dto.request.AssignUserRoleRequest;
import com.sentinel.identity.authorization.dto.response.UserRoleResponse;
import com.sentinel.identity.authorization.service.UserRoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users/{userId}/roles")
@RequiredArgsConstructor
public class UserRoleController {

    private final UserRoleService userRoleService;

    @PostMapping
    public ResponseEntity<ApiResponse<UserRoleResponse>> assignRoleToUser(
            @PathVariable UUID userId,
            @Valid @RequestBody AssignUserRoleRequest request) {
        UserRoleResponse response = userRoleService.assignRoleToUser(userId, request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.<UserRoleResponse>builder()
                        .success(true)
                        .message("Role assigned to user successfully")
                        .data(response)
                        .build());
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserRoleResponse>>> getUserRoles(@PathVariable UUID userId) {
        List<UserRoleResponse> userRoles = userRoleService.getUserRoles(userId);
        return ResponseEntity.ok(
                ApiResponse.<List<UserRoleResponse>>builder()
                        .success(true)
                        .message("User roles fetched successfully")
                        .data(userRoles)
                        .build());
    }

    @DeleteMapping("/{roleId}")
    public ResponseEntity<ApiResponse<Void>> removeRoleFromUser(
            @PathVariable UUID userId,
            @PathVariable UUID roleId) {
        userRoleService.removeRoleFromUser(userId, roleId);
        return ResponseEntity.noContent().build();
    }
}