package com.sentinel.identity.user.service;

import com.sentinel.common.enums.AccountStatus;
import com.sentinel.common.exception.InvalidAccountStatusException;
import com.sentinel.common.exception.InvalidOperationException;
import com.sentinel.common.exception.UserAlreadyDeletedException;
import com.sentinel.identity.user.dto.request.CreateUserRequest;
import com.sentinel.identity.user.dto.request.UpdateUserRequest;
import com.sentinel.identity.user.dto.response.UserResponse;
import com.sentinel.identity.user.entity.User;
import com.sentinel.identity.user.mapper.UserMapper;
import com.sentinel.identity.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.sentinel.common.exception.ResourceNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    //TODO: update user creation flow to encrypt the password
    //private final PasswordEncoder passwordEncoder;

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

        User user = UserMapper.toCreateUserEntity(createUserRequest);
        //user.setPassword(passwordEncoder.encode(createUserRequest.getPassword()));
        User savedUser = userRepository.save(user);
        log.info("User created successfully with ID: {}", savedUser.getId());
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

        User updatedUser = userRepository.save(existingUser);
        log.info("User with ID {} updated successfully.", updatedUser.getId());
        return UserMapper.userResponseMapper(updatedUser);
    }
}