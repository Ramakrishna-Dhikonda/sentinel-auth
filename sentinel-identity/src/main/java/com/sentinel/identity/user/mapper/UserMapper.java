package com.sentinel.identity.user.mapper;

import com.mysql.cj.util.StringUtils;
import com.sentinel.common.enums.AccountStatus;
import com.sentinel.identity.user.dto.request.CreateUserRequest;
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

    public static User toUserEntity(CreateUserRequest createUserRequest) {
        User user = new User();
        user.setUsername(createUserRequest.getUsername());
        user.setAccountStatus(AccountStatus.PENDING_VERIFICATION);
        user.setEmail(createUserRequest.getEmail());
        String displayName = (createUserRequest.getFirstName() != null ? createUserRequest.getFirstName() : "") + " " +
                (createUserRequest.getLastName() != null ? createUserRequest.getLastName() : "");
        user.setDisplayName(displayName.trim());
        user.setPhoneNumber(createUserRequest.getPhoneNumber());
        return user;
    }
}
