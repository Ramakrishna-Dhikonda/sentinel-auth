package com.sentinel.sentinel_identity.users.service.impl;

import com.sentinel.sentinel_common.dto.response.PageResponse;
import com.sentinel.sentinel_common.exceptions.DuplicateEmailException;
import com.sentinel.sentinel_common.exceptions.UserNotFoundException;
import com.sentinel.sentinel_identity.users.dto.request.UserCreateRequest;
import com.sentinel.sentinel_identity.users.dto.request.UserUpdateRequest;
import com.sentinel.sentinel_identity.users.dto.response.UserResponse;
import com.sentinel.sentinel_identity.users.entity.User;
import com.sentinel.sentinel_identity.users.mapper.UserMapper;
import com.sentinel.sentinel_identity.users.model.UserStatus;
import com.sentinel.sentinel_identity.users.repository.UserRepository;
import com.sentinel.sentinel_identity.users.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserResponse createUser(UserCreateRequest request) {
        String traceId = MDC.get("traceId");
        log.info("traceId: {}, Attempting to create user with email: {}", traceId, request.getEmail());

        if (userRepository.existsByEmail(request.getEmail())) {
            log.warn("traceId: {}, User creation failed: Email {} already exists", traceId, request.getEmail());
            throw new DuplicateEmailException("User with email " + request.getEmail() + " already exists.");
        }

        User user = User.builder()
                .email(request.getEmail())
                //.password(passwordEncoder.encode(request.getPassword()))
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .status(UserStatus.PENDING_VERIFICATION) // Default status for new users
                .emailVerified(false) // Default to false for new users
                .build();

        User savedUser = userRepository.save(user);
        log.info("traceId: {}, User created successfully with ID: {}", traceId, savedUser.getId());

        return UserResponse.builder()
                .id(savedUser.getId())
                .email(savedUser.getEmail())
                .firstName(savedUser.getFirstName())
                .lastName(savedUser.getLastName())
                .status(savedUser.getStatus())
                .emailVerified(savedUser.isEmailVerified())
                .createdAt(savedUser.getCreatedAt())
                .updatedAt(savedUser.getUpdatedAt())
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponse getUserById(UUID id) {
        String traceId = MDC.get("traceId");
        log.info("traceId: {}, Attempting to retrieve user with ID: {}", traceId, id);

        User user = userRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("traceId: {}, User not found with ID: {}", traceId, id);
                    return new UserNotFoundException("User not found with ID: " + id);
                });

        log.info("traceId: {}, User retrieved successfully with ID: {}", traceId, user.getId());

        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .status(user.getStatus())
                .emailVerified(user.isEmailVerified())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }

    @Override
    @Transactional
    public UserResponse updateUser(UUID id, UserUpdateRequest request) {
        String traceId = MDC.get("traceId");
        log.info("traceId: {}, Attempting to update user with ID: {}", traceId, id);
        log.debug("traceId: {}, User update request received for ID {}: {}", traceId, id, request);

        User user = userRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("traceId: {}, User not found with ID: {}", traceId, id);
                    return new UserNotFoundException("User not found with ID: " + id);
                });

        // Use the mapper to apply partial updates. Fields with null values in the request will be ignored.
        userMapper.updateUserFromDto(request, user);

        User updatedUser = userRepository.save(user);
        log.info("traceId: {}, User updated successfully with ID: {}", traceId, updatedUser.getId());
        return userMapper.toUserResponse(updatedUser);
    }

    @Override
    public PageResponse<UserResponse> listUsers(int pageSize, int pageNo, String sortBy, String sortDir) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<User> users = userRepository.findAll(pageable);
        List<UserResponse> responses = users.getContent().stream()
                .map(userMapper::toUserResponse)
                .toList();
        return PageResponse.<UserResponse>builder()
                .content(responses)
                .page(users.getNumber())
                .size(users.getSize())
                .totalElements(users.getTotalElements())
                .totalPages(users.getTotalPages())
                .first(users.isFirst())
                .last(users.isLast())
                .hasNext(users.hasNext())
                .hasPrevious(users.hasPrevious())
                .build();
    }
}