package com.sentinel.sentinel_identity.users.controller;

import com.sentinel.sentinel_common.dto.response.ApiResponse;
import com.sentinel.sentinel_common.dto.response.user.UserExistenceResponse;
import com.sentinel.sentinel_identity.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/internal/v1/users")
@RequiredArgsConstructor
public class InternalController {

    private final UserService userService;

}
