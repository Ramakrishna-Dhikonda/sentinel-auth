package com.sentinel.identity.user.controller;

import com.sentinel.common.response.ApiResponse;
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
    public ResponseEntity<User> getUser(@PathVariable UUID id) {
        return null;
    }

    @PutMapping("/{id}")
    public void updateUser(@RequestParam UUID id) {

    }
    @DeleteMapping("/{id}")
    public void deleteUser(@RequestParam UUID id) {

    }

    @GetMapping("/username/{username}")
    public void findByUsername(@RequestParam String username) {

    }

    @GetMapping("/email/{email}")
    public void findByEmail(@RequestParam String email) {

    }

    @PatchMapping("/{id}/status")
    public void updateStatus(@RequestParam UUID id) {

    }
}
