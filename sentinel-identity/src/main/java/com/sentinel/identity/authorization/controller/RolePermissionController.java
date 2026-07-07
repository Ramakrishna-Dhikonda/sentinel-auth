package com.sentinel.identity.authorization.controller;

import com.sentinel.common.response.ApiResponse;
import com.sentinel.identity.authorization.dto.request.AssignRolePermissionRequest;
import com.sentinel.identity.authorization.dto.response.RolePermissionResponse;
import com.sentinel.identity.authorization.service.RolePermissionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/roles/{roleId}/permissions")
@RequiredArgsConstructor
public class RolePermissionController {

    private final RolePermissionService rolePermissionService;

    @PostMapping
    public ResponseEntity<ApiResponse<RolePermissionResponse>> assignPermissionToRole(
            @PathVariable UUID roleId,
            @Valid @RequestBody AssignRolePermissionRequest request) {
        RolePermissionResponse response = rolePermissionService.assignPermissionToRole(roleId, request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.<RolePermissionResponse>builder()
                        .success(true)
                        .message("Permission assigned to role successfully")
                        .data(response)
                        .build());
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<RolePermissionResponse>>> getRolePermissions(@PathVariable UUID roleId) {
        List<RolePermissionResponse> rolePermissions = rolePermissionService.getRolePermissions(roleId);
        return ResponseEntity.ok(
                ApiResponse.<List<RolePermissionResponse>>builder()
                        .success(true)
                        .message("Role permissions fetched successfully")
                        .data(rolePermissions)
                        .build());
    }

    @DeleteMapping("/{permissionId}")
    public ResponseEntity<ApiResponse<Void>> removePermissionFromRole(
            @PathVariable UUID roleId,
            @PathVariable UUID permissionId) {
        rolePermissionService.removePermissionFromRole(roleId, permissionId);
        return ResponseEntity.noContent().build();
    }
}