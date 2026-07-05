package com.sentinel.identity.user.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String username;
    private String email;
    private String phoneNumber;
    private String displayName;
    private String avatarUrl;
    private Boolean emailVerified;
    private Boolean phoneVerified;
    private String accountStatus;

    //TODO: create enum
}
