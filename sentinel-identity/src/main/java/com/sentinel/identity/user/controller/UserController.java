package com.sentinel.identity.user.controller;

import com.sentinel.common.response.ApiResponse;
import com.sentinel.identity.user.dto.request.CreateUserRequest;
import com.sentinel.identity.user.dto.request.UpdateUserRequest;
import com.sentinel.identity.user.dto.request.UpdateUserStatusRequest;
import com.sentinel.identity.user.dto.response.UserResponse;
import com.sentinel.identity.user.entity.User;
import com.sentinel.identity.user.service.UserService;
import lombok.RequiredArgsConstructor;
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
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser() {
        return null;
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
    public void updateUser(@RequestParam UUID id, @RequestBody UpdateUserRequest updateUserRequest) {

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@RequestParam UUID id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<ApiResponse<UserResponse>> findByUsername(@RequestParam String username) {
        return ResponseEntity.ok(
                ApiResponse.<UserResponse>builder()
                        .success(true)
                        .message("User found with provided Username")
                        .data(userService.findUserByUsername(username))
                        .build()
        );
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ApiResponse<UserResponse>> findByEmail(@RequestParam String email) {
        return ResponseEntity.ok(
                ApiResponse.<UserResponse>builder()
                        .success(true)
                        .message("User found with provided Email")
                        .data(userService.findUserByEmail(email))
                        .build()
        );
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<ApiResponse<Void>> updateStatus(@RequestParam UUID id, @RequestBody UpdateUserStatusRequest statusRequest) {
        userService.updateUserStatus(id, statusRequest.getStatus());
        return ResponseEntity.ok(
                ApiResponse.<Void>builder()
                        .success(true)
                        .message("User status updated successfully")
                        .build()
        );
    }
}
