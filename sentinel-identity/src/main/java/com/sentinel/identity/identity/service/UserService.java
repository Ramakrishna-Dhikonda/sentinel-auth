package com.sentinel.identity.identity.service;

import com.sentinel.common.enums.AccountStatus;
import com.sentinel.common.exception.*;
import com.sentinel.identity.identity.dto.request.CreateUserRequest;
import com.sentinel.identity.identity.dto.request.UpdateUserRequest;
import com.sentinel.identity.identity.dto.response.UserResponse;
import com.sentinel.identity.identity.entity.PasswordHistory;
import com.sentinel.identity.identity.entity.User;
import com.sentinel.identity.identity.mapper.UserMapper;
import com.sentinel.identity.identity.repository.PasswordHistoryRepository;
import com.sentinel.identity.identity.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final PasswordHistoryRepository passwordHistoryRepository;

    public List<UserResponse> listUsers() {
        log.debug("Fetching all users");
        return userRepository.findAll()
                .stream()
                .map(UserMapper::userResponseMapper)
                .collect(Collectors.toList());
    }

    public UserResponse findUserByUserId(UUID id) {
        log.debug("Finding user by ID: {}", id);
        Optional<User> user = userRepository.findById(id);
        return user.map(UserMapper::userResponseMapper)
                .orElseThrow(() -> new ResourceNotFoundException("User", id.toString()));
    }

    public UserResponse findUserByUsername(String username) {
        log.debug("Finding user by username: {}", username);
        Optional<User> user = userRepository.findByUsername(username);
        return user.map(UserMapper::userResponseMapper)
                .orElseThrow(() -> new ResourceNotFoundException("User", username));
    }

    public UserResponse findUserByEmail(String email) {
        log.debug("Finding user by email: {}", email);
        Optional<User> user = userRepository.findByEmail(email);
        return user.map(UserMapper::userResponseMapper)
                .orElseThrow(() -> new ResourceNotFoundException("User", email));
    }

    @Transactional
    public void updateUserStatus(UUID id, AccountStatus status) {
        log.info("Updating status for user ID: {} to {}", id, status);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", id.toString()));

        if ("superadmin".equalsIgnoreCase(user.getUsername())
                && status != AccountStatus.ACTIVE) {
            log.warn("Attempt to deactivate Super Admin account: {}", user.getUsername());
            throw new InvalidAccountStatusException("Super Admin account cannot be deactivated");
        }
        userRepository.updateAccountStatus(id, status);
        log.info("User status updated successfully for ID: {}", id);
    }

    @Transactional
    public void deleteUser(UUID userId) {
        log.info("Attempting to delete user with ID: {}", userId);
        User user = userRepository.findById(userId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("User", userId.toString())
                );
        if (user.getDeletedAt() != null) {
            log.warn("User with ID {} already deleted.", userId);
            throw new UserAlreadyDeletedException("User with provided ID already deleted");
        }
        if ("superadmin".equalsIgnoreCase(user.getUsername())) {
            log.warn("Attempt to delete Super Admin account: {}", user.getUsername());
            throw new InvalidOperationException("Super Admin account cannot be deleted.");
        }
        userRepository.softDeleteUser(userId);
        log.info("User with ID {} soft-deleted successfully.", userId);
    }

    @Transactional
    public UserResponse createUser(CreateUserRequest createUserRequest) {
        log.info("Creating new user with username: {}", createUserRequest.getUsername());
        if (userRepository.findByUsername(createUserRequest.getUsername()).isPresent()) {
            log.warn("User creation failed: username '{}' already exists.", createUserRequest.getUsername());
            throw new InvalidOperationException("User with username '" + createUserRequest.getUsername() + "' already exists.");
        }
        if (userRepository.findByEmail(createUserRequest.getEmail()).isPresent()) {
            log.warn("User creation failed: email '{}' already exists.", createUserRequest.getEmail());
            throw new InvalidOperationException("User with email '" + createUserRequest.getEmail() + "' already exists.");
        }

        // Create and save User entity
        User user = UserMapper.toCreateUserEntity(createUserRequest);
        User savedUser = userRepository.save(user);
        log.info("User created successfully with ID: {}", savedUser.getId());

        // Hash password and save to PasswordHistory
        String hashedPassword = passwordEncoder.encode(createUserRequest.getPassword());
        PasswordHistory passwordHistory = new PasswordHistory();
        passwordHistory.setPasswordHash(hashedPassword);
        passwordHistory.setUser(savedUser);
        passwordHistory.setCreatedAt(LocalDateTime.now());
        passwordHistoryRepository.save(passwordHistory);
        log.info("Password history saved for user ID: {}", savedUser.getId());

        return UserMapper.userResponseMapper(savedUser);
    }

    @Transactional
    public UserResponse updateUser(UUID id, UpdateUserRequest updateUserRequest) {
        log.info("Updating user with ID: {}", id);
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", id.toString()));

        String displayName = (updateUserRequest.getFirstName() != null ? updateUserRequest.getFirstName() : "") + " " +
                (updateUserRequest.getLastName() != null ? updateUserRequest.getLastName() : "");
        existingUser.setDisplayName(displayName.trim());
        existingUser.setPhoneNumber(updateUserRequest.getPhoneNumber());
        //Fixme later -> Add organizationID
        User updatedUser = userRepository.save(existingUser);
        log.info("User with ID {} updated successfully.", updatedUser.getId());
        return UserMapper.userResponseMapper(updatedUser);
    }

    public boolean exists(String userId) {
        return userRepository.existsById(UUID.fromString(userId));
    }

    public boolean isEmailAlreadyUsed(String email) {
        log.debug("Checking if email is already used: {}", email);
        return userRepository.findByEmail(email).isPresent();
    }
}