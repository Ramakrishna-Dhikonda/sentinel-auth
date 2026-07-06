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

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserResponse> listUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::userResponseMapper)
                .collect(Collectors.toList());
    }

    public UserResponse findUserByUserId(UUID id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(UserMapper::userResponseMapper)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with provided ID: " + id));
    }

    public UserResponse findUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.map(UserMapper::userResponseMapper)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with provided username: " + username));
    }

    public UserResponse findUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.map(UserMapper::userResponseMapper)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with provided email: " + email));
    }

    @Transactional
    public void updateUserStatus(UUID id, AccountStatus status) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));

        if ("superadmin".equalsIgnoreCase(user.getUsername())
                && status != AccountStatus.ACTIVE) {
            throw new InvalidAccountStatusException("Super Admin account cannot be deactivated");
        }
        int updatedRows = userRepository.updateAccountStatus(id, status);
        if (updatedRows == 0) {
            throw new ResourceNotFoundException("User not found with ID: " + id);
        }
    }

    @Transactional
    public void deleteUser(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("User not found with provide ID: " + userId.toString())
                );
        if (user.getDeletedAt() != null)
            throw new UserAlreadyDeletedException("User with provided ID already deleted");
        if ("superadmin".equalsIgnoreCase(user.getUsername()))
            throw new InvalidOperationException("Super Admin account cannot be deleted.");
        userRepository.softDeleteUser(userId);
    }

    public UserResponse createUser(CreateUserRequest createUserRequest) {
        User user = UserMapper.toUserEntity(createUserRequest);
        User savedUser = userRepository.save(user);
        return UserMapper.userResponseMapper(savedUser);
    }

    public UserResponse updateUser(UUID id, UpdateUserRequest updateUserRequest) {
        return null;
    }
}
