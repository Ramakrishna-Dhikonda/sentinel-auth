package com.sentinel.authentication.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Table(name = "user_credentials")
@Entity
@Data
public class UserCredentials {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID userId;
    private String passwordHash;
    private String passwordAlgorithm;
    private Instant createdAt;
    private Instant updated_at;
}

