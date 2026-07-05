-- ============================================================
-- SentinelAuth
-- Identity Service
-- Migration : V2__authorization.sql
-- Description : Authorization Schema
-- ============================================================

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ============================================================
-- TABLE : roles
-- ============================================================

CREATE TABLE roles
(
    id                  CHAR(36) NOT NULL PRIMARY KEY,

    name                VARCHAR(100) NOT NULL,

    code                VARCHAR(100) NOT NULL,

    description         VARCHAR(500),

    system_role         BOOLEAN NOT NULL DEFAULT FALSE,

    created_at          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    created_by          CHAR(36),

    updated_at          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    updated_by          CHAR(36),

    deleted_at          TIMESTAMP NULL,

    version             BIGINT NOT NULL DEFAULT 0,

    CONSTRAINT uk_roles_name UNIQUE(name),
    CONSTRAINT uk_roles_code UNIQUE(code)

)
    ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci
COMMENT='Stores all available roles.';


CREATE INDEX idx_roles_system
    ON roles(system_role);

CREATE INDEX idx_roles_deleted
    ON roles(deleted_at);



-- ============================================================
-- TABLE : permissions
-- ============================================================

CREATE TABLE permissions
(
    id                  CHAR(36) NOT NULL PRIMARY KEY,

    name                VARCHAR(150) NOT NULL,

    code                VARCHAR(150) NOT NULL,

    module              VARCHAR(100) NOT NULL,

    description         VARCHAR(500),

    created_at          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    created_by          CHAR(36),

    updated_at          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    updated_by          CHAR(36),

    deleted_at          TIMESTAMP NULL,

    version             BIGINT NOT NULL DEFAULT 0,

    CONSTRAINT uk_permission_name UNIQUE(name),
    CONSTRAINT uk_permission_code UNIQUE(code)

)
    ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci
COMMENT='Stores all application permissions.';


CREATE INDEX idx_permissions_module
    ON permissions(module);

CREATE INDEX idx_permissions_deleted
    ON permissions(deleted_at);



-- ============================================================
-- TABLE : user_roles
-- ============================================================

CREATE TABLE user_roles
(
    id                  CHAR(36) NOT NULL PRIMARY KEY,

    user_id             CHAR(36) NOT NULL,

    role_id             CHAR(36) NOT NULL,

    assigned_at         TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    expires_at          TIMESTAMP NULL,

    created_at          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    created_by          CHAR(36),

    updated_at          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    updated_by          CHAR(36),

    deleted_at          TIMESTAMP NULL,

    version             BIGINT NOT NULL DEFAULT 0,

    CONSTRAINT fk_user_roles_user
        FOREIGN KEY(user_id)
            REFERENCES users(id)
            ON DELETE CASCADE
            ON UPDATE CASCADE,

    CONSTRAINT fk_user_roles_role
        FOREIGN KEY(role_id)
            REFERENCES roles(id)
            ON DELETE CASCADE
            ON UPDATE CASCADE,

    CONSTRAINT uk_user_role UNIQUE(user_id, role_id)

)
    ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci
COMMENT='Maps users to roles.';


CREATE INDEX idx_user_roles_user
    ON user_roles(user_id);

CREATE INDEX idx_user_roles_role
    ON user_roles(role_id);



-- ============================================================
-- TABLE : role_permissions
-- ============================================================

CREATE TABLE role_permissions
(
    id                  CHAR(36) NOT NULL PRIMARY KEY,

    role_id             CHAR(36) NOT NULL,

    permission_id       CHAR(36) NOT NULL,

    created_at          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    created_by          CHAR(36),

    updated_at          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    updated_by          CHAR(36),

    deleted_at          TIMESTAMP NULL,

    version             BIGINT NOT NULL DEFAULT 0,

    CONSTRAINT fk_role_permissions_role
        FOREIGN KEY(role_id)
            REFERENCES roles(id)
            ON DELETE CASCADE
            ON UPDATE CASCADE,

    CONSTRAINT fk_role_permissions_permission
        FOREIGN KEY(permission_id)
            REFERENCES permissions(id)
            ON DELETE CASCADE
            ON UPDATE CASCADE,

    CONSTRAINT uk_role_permission UNIQUE(role_id, permission_id)

)
    ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci
COMMENT='Maps roles to permissions.';


CREATE INDEX idx_role_permissions_role
    ON role_permissions(role_id);

CREATE INDEX idx_role_permissions_permission
    ON role_permissions(permission_id);

SET FOREIGN_KEY_CHECKS = 1;