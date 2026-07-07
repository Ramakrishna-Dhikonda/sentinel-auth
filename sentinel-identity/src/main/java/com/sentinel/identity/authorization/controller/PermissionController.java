package com.sentinel.identity.authorization.controller;

import com.sentinel.common.response.ApiResponse;
import com.sentinel.identity.authorization.dto.request.CreatePermissionRequest;
import com.sentinel.identity.authorization.dto.request.UpdatePermissionRequest;
import com.sentinel.identity.authorization.dto.response.PermissionResponse;
import com.sentinel.identity.authorization.service.PermissionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/permissions")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;

    @PostMapping
    public ResponseEntity<ApiResponse<PermissionResponse>> createPermission(@Valid @RequestBody CreatePermissionRequest request) {
        PermissionResponse response = permissionService.createPermission(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.<PermissionResponse>builder()
                        .success(true)
                        .message("Permission created successfully")
                        .data(response)
                        .build());
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<PermissionResponse>>> getAllPermissions() {
        List<PermissionResponse> permissions = permissionService.getAllPermissions();
        return ResponseEntity.ok(
                ApiResponse.<List<PermissionResponse>>builder()
                        .success(true)
                        .message("Permissions fetched successfully")
                        .data(permissions)
                        .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PermissionResponse>> getPermissionById(@PathVariable UUID id) {
        PermissionResponse response = permissionService.getPermissionById(id);
        return ResponseEntity.ok(
                ApiResponse.<PermissionResponse>builder()
                        .success(true)
                        .message("Permission fetched successfully")
                        .data(response)
                        .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<PermissionResponse>> updatePermission(@PathVariable UUID id, @Valid @RequestBody UpdatePermissionRequest request) {
        PermissionResponse response = permissionService.updatePermission(id, request);
        return ResponseEntity.ok(
                ApiResponse.<PermissionResponse>builder()
                        .success(true)
                        .message("Permission updated successfully")
                        .data(response)
                        .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deletePermission(@PathVariable UUID id) {
        permissionService.deletePermission(id);
        return ResponseEntity.noContent().build();
    }
}