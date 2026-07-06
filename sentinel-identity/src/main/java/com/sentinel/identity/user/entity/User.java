package com.sentinel.identity.user.entity;

import com.sentinel.common.enums.AccountStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
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
    //TODO: create enum
    private AccountStatus accountStatus;
    private LocalDateTime deletedAt;
}
