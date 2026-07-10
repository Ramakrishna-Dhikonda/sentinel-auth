package com.sentinel.authentication.service;

import com.sentinel.authentication.dto.request.RegisterRequest;
import com.sentinel.authentication.feign.UserClient;
import com.sentinel.authentication.repository.UserCredentialsRepository;
import com.sentinel.common.exception.EmailAlreadyExistsException;
import com.sentinel.common.exception.UserAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCredentialsService {

    private static final Logger log = LoggerFactory.getLogger(UserCredentialsService.class);
    private final UserCredentialsRepository repository;
    private final UserClient userClient;

    public void register(RegisterRequest registerRequest) {
        if (!registerRequest.getPassword().equals(registerRequest.getConfirmPassword())) {
            //throw appropriate exception
            throw new RuntimeException("Passwords did not match");
        }
        // Check whether username already exists.
        if (userClient.checkUserExistence(registerRequest.getUsername())) {
            throw new UserAlreadyExistsException("Username already exists");
        }
        // Check whether email already exists.
        if (userClient.isEmailAlreadyUsed(registerRequest.getEmail())) {
            throw new EmailAlreadyExistsException(registerRequest.getEmail());
        }
        // Hash password using BCrypt.
        // Create User in Identity Service.
        /*
            accountStatus = PENDING_VERIFICATION
            emailVerified = false
            phoneVerified = false
         */
        // Assign USER role - Every new account receives the default USER role.
        /*
        Create UserCredential.

            Store

            passwordHash
            passwordAlgorithm
            enabled
            accountNonLocked
            failedLoginAttempts = 0
         */
        // Store password history. - Insert first password into
        // Generate Email Verification Token.
        // Send verification email.
        // Return - 201 created
    }
}
