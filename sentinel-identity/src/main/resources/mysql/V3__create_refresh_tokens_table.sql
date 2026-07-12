CREATE TABLE refresh_tokens (
                                id          CHAR(36)     NOT NULL PRIMARY KEY,
                                user_id     CHAR(36)     NOT NULL,
                                token_hash  VARCHAR(255) NOT NULL,
                                device_info VARCHAR(255),
                                ip_address  VARCHAR(45),
                                expires_at  TIMESTAMP    NOT NULL,
                                revoked     BOOLEAN      NOT NULL DEFAULT FALSE,
                                created_at  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                CONSTRAINT uq_refresh_token_hash UNIQUE (token_hash),
                                CONSTRAINT fk_refresh_tokens_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE INDEX idx_refresh_tokens_user ON refresh_tokens(user_id);
CREATE INDEX idx_refresh_tokens_expires ON refresh_tokens(expires_at);