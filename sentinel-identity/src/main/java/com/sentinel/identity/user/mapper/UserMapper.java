package com.sentinel.identity.user.mapper;

import com.sentinel.identity.user.dto.response.UserResponse;
import com.sentinel.identity.user.entity.User;

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
}
