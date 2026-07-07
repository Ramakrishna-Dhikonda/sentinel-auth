package com.sentinel.identity.identity.entity;

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
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String username;
    private String email;
    // Removed password field
    private String phoneNumber;
    private String displayName;
    private String avatarUrl;
    private Boolean emailVerified = false;
    private Boolean phoneVerified = false;
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}