package com.sentinel.identity.user.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateUserRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String profileImage;
    private Long organizationId;
}
