package com.sentinel.identity.authorization.dto;

import lombok.Data;

@Data
public class RoleResponse {
    private String id;
    private String name;
    private String description;
}