package com.sentinel.identity.identity.controller;

import com.sentinel.identity.identity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/internal")
@RequiredArgsConstructor
public class UserInternalController {

    private final UserService userService;

    @GetMapping("/users/{userId}/exists")
    public boolean exists(@PathVariable String userId) {
        return userService.exists(userId);
    }

    @GetMapping("/email/{email}/exists")
    public boolean isEmailAlreadyUsed(@PathVariable String email) {
        return userService.isEmailAlreadyUsed(email);
    }
}
