package com.sentinel.identity.user.mapper;

import com.sentinel.common.enums.AccountStatus;
import com.sentinel.identity.user.dto.request.CreateUserRequest;
import com.sentinel.identity.user.dto.request.UpdateUserRequest;
import com.sentinel.identity.user.dto.response.UserResponse;
import com.sentinel.identity.user.entity.User;

import java.time.LocalDateTime;

public class UserMapper {
    public static UserResponse userResponseMapper(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .displayName(user.getDisplayName())
                .avatarUrl(user.getAvatarUrl())
                .emailVerified(user.getEmailVerified())
                .phoneVerified(user.getPhoneVerified())
                .accountStatus(user.getAccountStatus())
                .build();

    }

    public static User toUpdateUserEntity(UpdateUserRequest request) {
        User user = new User();
        user.setDisplayName(request.getFirstName() + request.getLastName());
        user.setPhoneNumber(request.getPhoneNumber());
        return user;
    }

    public static User toCreateUserEntity(CreateUserRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setAccountStatus(AccountStatus.PENDING_VERIFICATION);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        user.setEmail(request.getEmail());
        String displayName = (request.getFirstName() != null ? request.getFirstName() : "") + " " +
                (request.getLastName() != null ? request.getLastName() : "");
        user.setDisplayName(displayName.trim());
        user.setPhoneNumber(request.getPhoneNumber());
        return user;
    }
}
