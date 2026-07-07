-- ============================================================
-- SentinelAuth
-- Identity Service
-- Migration : V1__create_identity_tables.sql
-- Description : Creates the core identity tables.
-- ============================================================

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ============================================================
-- TABLE : users
-- Purpose:
-- Stores the core identity of every user in SentinelAuth.
--
-- This table intentionally does NOT contain authentication
-- information (passwords, OTPs, refresh tokens, etc.).
--
-- It also does NOT contain application-specific profile data
-- like address, DOB, bio, department, etc.
-- ============================================================

CREATE TABLE users
(
    id                      CHAR(36) NOT NULL PRIMARY KEY COMMENT 'UUID',

    username                VARCHAR(50) NOT NULL COMMENT 'Unique username',

    email                   VARCHAR(320) NOT NULL COMMENT 'Unique email',

    phone_number            VARCHAR(20) NULL COMMENT 'International phone number',

    display_name            VARCHAR(150) NULL COMMENT 'Public display name',

    avatar_url              VARCHAR(500) NULL COMMENT 'Profile image URL',

    account_status ENUM(
        'ACTIVE',
        'INACTIVE',
        'LOCKED',
        'SUSPENDED',
        'PENDING_VERIFICATION'
    ) NOT NULL DEFAULT 'PENDING_VERIFICATION',

    email_verified          BOOLEAN NOT NULL DEFAULT FALSE,

    phone_verified          BOOLEAN NOT NULL DEFAULT FALSE,

    last_login_at           TIMESTAMP NULL,

    created_at              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    created_by              CHAR(36) NULL,

    updated_at              TIMESTAMP NOT NULL
        DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    updated_by              CHAR(36) NULL,

    deleted_at              TIMESTAMP NULL,

    version                 BIGINT NOT NULL DEFAULT 0,

    CONSTRAINT uk_users_username UNIQUE(username),

    CONSTRAINT uk_users_email UNIQUE(email),

    CONSTRAINT uk_users_phone UNIQUE(phone_number)

)
    ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci
COMMENT='Stores core user identity.';


CREATE INDEX idx_users_status
    ON users(account_status);

CREATE INDEX idx_users_created_at
    ON users(created_at);

CREATE INDEX idx_users_last_login
    ON users(last_login_at);



-- ============================================================
-- TABLE : user_preferences
--
-- Stores UI and notification preferences.
--
-- This table is optional.
-- A user can exist without preferences.
-- ============================================================

CREATE TABLE user_preferences
(
    id                      CHAR(36) NOT NULL PRIMARY KEY,

    user_id                 CHAR(36) NOT NULL,

    theme ENUM(
        'LIGHT',
        'DARK',
        'SYSTEM'
    ) NOT NULL DEFAULT 'SYSTEM',

    language                VARCHAR(20) NOT NULL DEFAULT 'en',

    timezone                VARCHAR(100) NOT NULL DEFAULT 'UTC',

    email_notifications     BOOLEAN NOT NULL DEFAULT TRUE,

    sms_notifications       BOOLEAN NOT NULL DEFAULT FALSE,

    push_notifications      BOOLEAN NOT NULL DEFAULT TRUE,

    mfa_enabled             BOOLEAN NOT NULL DEFAULT FALSE,

    created_at              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    created_by              CHAR(36) NULL,

    updated_at              TIMESTAMP NOT NULL
        DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    updated_by              CHAR(36) NULL,

    deleted_at              TIMESTAMP NULL,

    version                 BIGINT NOT NULL DEFAULT 0,

    CONSTRAINT fk_preferences_user
        FOREIGN KEY(user_id)
            REFERENCES users(id)
            ON DELETE CASCADE
            ON UPDATE CASCADE

)
    ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci
COMMENT='Stores user UI and notification preferences.';


CREATE UNIQUE INDEX uk_preferences_user
    ON user_preferences(user_id);

SET FOREIGN_KEY_CHECKS = 1;