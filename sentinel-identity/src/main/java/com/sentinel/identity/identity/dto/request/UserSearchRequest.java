package com.sentinel.identity.identity.dto.request;

import com.sentinel.common.enums.AccountStatus;

public class UserSearchRequest {
    private String username;
    private String email;
    private AccountStatus status;
    private Long organizationId;
    private int page = 0;
    private int size = 20;
}
