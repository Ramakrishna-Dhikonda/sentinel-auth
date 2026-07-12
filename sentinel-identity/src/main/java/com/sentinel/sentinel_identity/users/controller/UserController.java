package com.sentinel.sentinel_identity.users.controller;

import com.sentinel.sentinel_common.dto.response.ApiResponse;
import com.sentinel.sentinel_common.dto.response.PageResponse;
import com.sentinel.sentinel_identity.users.dto.request.UserCreateRequest;
import com.sentinel.sentinel_identity.users.dto.request.UserUpdateRequest;
import com.sentinel.sentinel_identity.users.dto.response.UserResponse;
import com.sentinel.sentinel_identity.users.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(
            @Valid @RequestBody UserCreateRequest request) {

        String traceId = MDC.get("traceId");
        log.info("traceId: {}, Received request to create user with email: {}", traceId, request.getEmail());
        UserResponse userResponse = userService.createUser(request);
        log.info("traceId: {}, User created successfully with ID: {}", traceId, userResponse.getId());
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<UserResponse>>> listUsers(
            int pageSize,
            int pageNo,
            HttpServletRequest request) {

        String traceId = MDC.get("traceId");
        log.info("traceId: {}, Received request to list users", traceId);
        return ResponseEntity.ok(ApiResponse.<PageResponse<UserResponse>>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Users retrieved successfully")
                .data(userService.listUsers(pageSize, pageNo, "", ""))
                .path(request.getRequestURI())
                .timestamp(Instant.now())
                .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> getUserById(@PathVariable UUID id) {

        String traceId = MDC.get("traceId");
        log.info("traceId: {}, Received request to get user with ID: {}", traceId, id);
        UserResponse userResponse = userService.getUserById(id);
        log.info("traceId: {}, User retrieved successfully with ID: {}", traceId, userResponse.getId());
        return ResponseEntity.ok(ApiResponse.<UserResponse>builder()
                .status(HttpStatus.FOUND.value())
                .success(true)
                .data(userResponse)
                .message("User retrieved successfully")
                .timestamp(Instant.now())
                .build()
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable UUID id,
            @Valid @RequestBody UserUpdateRequest request) {

        String traceId = MDC.get("traceId");
        log.info("traceId: {}, Received request to update user with ID: {}", traceId, id);
        UserResponse userResponse = userService.updateUser(id, request);
        log.info("traceId: {}, User with ID {} updated successfully", traceId, userResponse.getId());
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
}