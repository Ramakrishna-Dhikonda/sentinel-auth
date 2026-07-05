package com.sentinel.identity.user.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public class UserResponse {
    private UUID id;
    private String username;
    private String email;
    private String phoneNumber;
    private String displayName;
    private String avatarUrl;
    private String accountStatus;
    private Boolean emailVerified;
    private Boolean phoneVerified;
}
