CREATE TABLE user_roles (
                            user_id    CHAR(36) NOT NULL,
                            role_id    BIGINT   NOT NULL,
                            granted_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                            granted_by CHAR(36) NULL,
                            PRIMARY KEY (user_id, role_id),
                            CONSTRAINT fk_user_roles_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
                            CONSTRAINT fk_user_roles_role FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE INDEX idx_user_roles_role ON user_roles(role_id);