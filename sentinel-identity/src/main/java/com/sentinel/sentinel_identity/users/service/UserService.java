package com.sentinel.sentinel_identity.users.service;

import com.sentinel.sentinel_common.dto.response.PageResponse;
import com.sentinel.sentinel_identity.users.dto.request.UserCreateRequest;
import com.sentinel.sentinel_identity.users.dto.request.UserUpdateRequest;
import com.sentinel.sentinel_identity.users.dto.response.UserResponse;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface UserService {
    UserResponse createUser(UserCreateRequest request);
    UserResponse getUserById(UUID id);
    PageResponse<UserResponse> listUsers(int pageSize, int pageNo, String sortBy, String sortDir);
    UserResponse updateUser(UUID id, UserUpdateRequest request);
}