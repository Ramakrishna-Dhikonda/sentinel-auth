package com.sentinel.authentication.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @PostMapping("/register")
    public void register() {

    }

    @PostMapping("/login")
    public void login() {

    }

    @PostMapping("/logout")
    public void logout() {

    }

    @PostMapping("/refresh")
    public void refresh() {

    }

    @PostMapping("/change-password")
    public void changePassword() {}

    @PostMapping("/forgot-password")
    public void forgotPassword() {}

    @PostMapping("/reset-password")
    public void resetPassword() {}

    @PostMapping("/verify-email")
    public void verifyEmail() {}

    @PostMapping("/resend-verification")
    public void resendVerification() {}

}
