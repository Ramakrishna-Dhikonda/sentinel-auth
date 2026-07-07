package com.sentinel.identity.authorization.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRoleRequest {
    private String code;
    private Boolean systemRole;
}
