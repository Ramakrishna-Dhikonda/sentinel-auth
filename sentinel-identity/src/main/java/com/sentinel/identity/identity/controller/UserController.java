package com.sentinel.identity.identity.controller;

import com.sentinel.common.response.ApiResponse;
import com.sentinel.identity.identity.dto.request.CreateUserRequest;
import com.sentinel.identity.identity.dto.request.UpdateUserRequest;
import com.sentinel.identity.identity.dto.request.UpdateUserStatusRequest;
import com.sentinel.identity.identity.dto.response.UserResponse;
import com.sentinel.identity.identity.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/*
POST   /api/v1/users
GET    /api/v1/users
GET    /api/v1/users/{id}
PUT    /api/v1/users/{id}
DELETE /api/v1/users/{id}

GET    /api/v1/users/username/{username}
GET    /api/v1/users/email/{email}
GET    /api/v1/users/search
PATCH  /api/v1/users/{id}/status
 */
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    // Instance of userService
    private final UserService userService;

    @PostMapping
    public ResponseEntity<ApiResponse<UserResponse>> createUser(@Valid @RequestBody CreateUserRequest userRequest) {
        UserResponse response = userService.createUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED)  // 201
                .body(ApiResponse.<UserResponse>builder()
                        .success(true)
                        .message("User created successfully")
                        .data(response)
                        .build()
                );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponse>>> findAll() {
        return ResponseEntity.ok(
                ApiResponse.<List<UserResponse>>builder()
                        .success(true)
                        .message("User list fetched successfully")
                        .data(userService.listUsers())
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> getUser(@PathVariable UUID id) {
        return ResponseEntity.ok(
                ApiResponse.<UserResponse>builder()
                        .success(true)
                        .message("User found with provided ID")
                        .data(userService.findUserByUserId(id))
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> updateUser(@PathVariable UUID id, @RequestBody UpdateUserRequest updateUserRequest) {
        UserResponse response = userService.updateUser(id, updateUserRequest);
        return ResponseEntity.ok(
                ApiResponse.<UserResponse>builder()
                        .success(true)
                        .message("User updated successfully")
                        .data(response)
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<ApiResponse<UserResponse>> findByUsername(@PathVariable String username) {
        return ResponseEntity.ok(
                ApiResponse.<UserResponse>builder()
                        .success(true)
                        .message("User found with provided Username")
                        .data(userService.findUserByUsername(username))
                        .build()
        );
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ApiResponse<UserResponse>> findByEmail(@PathVariable String email) {
        return ResponseEntity.ok(
                ApiResponse.<UserResponse>builder()
                        .success(true)
                        .message("User found with provided Email")
                        .data(userService.findUserByEmail(email))
                        .build()
        );
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> updateStatus(@PathVariable UUID id, @RequestBody UpdateUserStatusRequest statusRequest) {
        userService.updateUserStatus(id, statusRequest.getStatus());
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}