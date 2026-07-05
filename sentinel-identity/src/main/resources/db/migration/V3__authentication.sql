-- ============================================================
-- SentinelAuth
-- Authentication Service
-- Migration : V1__authentication.sql
-- Description : Authentication Schema
-- ============================================================

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ============================================================
-- TABLE : user_credentials
--
-- Stores authentication credentials.
-- Passwords are stored as BCrypt hashes.
-- ============================================================

CREATE TABLE user_credentials
(
    id                          CHAR(36) NOT NULL PRIMARY KEY,

    user_id                     CHAR(36) NOT NULL COMMENT 'User UUID from Identity Service',

    password_hash               VARCHAR(255) NOT NULL,

    password_algorithm          VARCHAR(50) NOT NULL DEFAULT 'BCRYPT',

    password_changed_at         TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    password_expires_at         TIMESTAMP NULL,

    account_non_locked          BOOLEAN NOT NULL DEFAULT TRUE,

    account_non_expired         BOOLEAN NOT NULL DEFAULT TRUE,

    credentials_non_expired     BOOLEAN NOT NULL DEFAULT TRUE,

    enabled                     BOOLEAN NOT NULL DEFAULT TRUE,

    failed_login_attempts       INT NOT NULL DEFAULT 0,

    last_failed_login_at        TIMESTAMP NULL,

    last_successful_login_at    TIMESTAMP NULL,

    created_at                  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    created_by                  CHAR(36) NULL,

    updated_at                  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    updated_by                  CHAR(36) NULL,

    deleted_at                  TIMESTAMP NULL,

    version                     BIGINT NOT NULL DEFAULT 0,

    CONSTRAINT uk_credentials_user UNIQUE(user_id)

)
    ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci
COMMENT='Stores authentication credentials.';

CREATE INDEX idx_credentials_enabled
    ON user_credentials(enabled);

CREATE INDEX idx_credentials_locked
    ON user_credentials(account_non_locked);



-- ============================================================
-- TABLE : password_history
-- ============================================================

CREATE TABLE password_history
(
    id                  CHAR(36) NOT NULL PRIMARY KEY,

    user_id             CHAR(36) NOT NULL,

    password_hash       VARCHAR(255) NOT NULL,

    created_at          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    created_by          CHAR(36),

    updated_at          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    updated_by          CHAR(36),

    deleted_at          TIMESTAMP NULL,

    version             BIGINT NOT NULL DEFAULT 0

)
    ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci
COMMENT='Stores previous password hashes.';

CREATE INDEX idx_password_history_user
    ON password_history(user_id);



-- ============================================================
-- TABLE : email_verification_tokens
-- ============================================================

CREATE TABLE email_verification_tokens
(
    id                      CHAR(36) NOT NULL PRIMARY KEY,

    user_id                 CHAR(36) NOT NULL,

    token                   VARCHAR(255) NOT NULL,

    expires_at              TIMESTAMP NOT NULL,

    verified_at             TIMESTAMP NULL,

    created_at              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    created_by              CHAR(36),

    updated_at              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    updated_by              CHAR(36),

    deleted_at              TIMESTAMP NULL,

    version                 BIGINT NOT NULL DEFAULT 0,

    CONSTRAINT uk_email_verification_token UNIQUE(token)

)
    ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci
COMMENT='Stores email verification tokens.';

CREATE INDEX idx_email_verification_user
    ON email_verification_tokens(user_id);

CREATE INDEX idx_email_verification_expiry
    ON email_verification_tokens(expires_at);



-- ============================================================
-- TABLE : password_reset_tokens
-- ============================================================

CREATE TABLE password_reset_tokens
(
    id                      CHAR(36) NOT NULL PRIMARY KEY,

    user_id                 CHAR(36) NOT NULL,

    token                   VARCHAR(255) NOT NULL,

    expires_at              TIMESTAMP NOT NULL,

    used_at                 TIMESTAMP NULL,

    created_at              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    created_by              CHAR(36),

    updated_at              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    updated_by              CHAR(36),

    deleted_at              TIMESTAMP NULL,

    version                 BIGINT NOT NULL DEFAULT 0,

    CONSTRAINT uk_password_reset_token UNIQUE(token)

)
    ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci
COMMENT='Stores password reset tokens.';

CREATE INDEX idx_password_reset_user
    ON password_reset_tokens(user_id);

CREATE INDEX idx_password_reset_expiry
    ON password_reset_tokens(expires_at);



-- ============================================================
-- TABLE : refresh_tokens
-- ============================================================

CREATE TABLE refresh_tokens
(
    id                      CHAR(36) NOT NULL PRIMARY KEY,

    user_id                 CHAR(36) NOT NULL,

    token                   VARCHAR(512) NOT NULL,

    device_id               VARCHAR(255),

    device_name             VARCHAR(255),

    ip_address              VARCHAR(50),

    user_agent              VARCHAR(1000),

    expires_at              TIMESTAMP NOT NULL,

    revoked                 BOOLEAN NOT NULL DEFAULT FALSE,

    revoked_at              TIMESTAMP NULL,

    created_at              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    created_by              CHAR(36),

    updated_at              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    updated_by              CHAR(36),

    deleted_at              TIMESTAMP NULL,

    version                 BIGINT NOT NULL DEFAULT 0,

    CONSTRAINT uk_refresh_token UNIQUE(token)

)
    ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci
COMMENT='Stores refresh tokens.';

CREATE INDEX idx_refresh_user
    ON refresh_tokens(user_id);

CREATE INDEX idx_refresh_expiry
    ON refresh_tokens(expires_at);

CREATE INDEX idx_refresh_revoked
    ON refresh_tokens(revoked);



-- ============================================================
-- TABLE : login_attempts
-- ============================================================

CREATE TABLE login_attempts
(
    id                      CHAR(36) NOT NULL PRIMARY KEY,

    user_id                 CHAR(36),

    username                VARCHAR(320),

    ip_address              VARCHAR(50),

    user_agent              VARCHAR(1000),

    success                 BOOLEAN NOT NULL,

    failure_reason          VARCHAR(255),

    attempted_at            TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    created_at              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    created_by              CHAR(36),

    updated_at              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    updated_by              CHAR(36),

    deleted_at              TIMESTAMP NULL,

    version                 BIGINT NOT NULL DEFAULT 0

)
    ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci
COMMENT='Stores login attempt history.';

CREATE INDEX idx_login_attempts_user
    ON login_attempts(user_id);

CREATE INDEX idx_login_attempts_username
    ON login_attempts(username);

CREATE INDEX idx_login_attempts_ip
    ON login_attempts(ip_address);

CREATE INDEX idx_login_attempts_time
    ON login_attempts(attempted_at);

SET FOREIGN_KEY_CHECKS = 1;