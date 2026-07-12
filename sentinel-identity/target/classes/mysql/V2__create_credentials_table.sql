-- One-to-one with users, split into its own table deliberately:
-- credential data has different access patterns and stricter handling
-- than profile data, even within the same service.
CREATE TABLE credentials (
                             user_id         CHAR(36)     NOT NULL PRIMARY KEY,
                             password_hash   VARCHAR(255) NOT NULL,
                             password_algo   VARCHAR(20)  NOT NULL DEFAULT 'BCRYPT',
                             failed_attempts INT          NOT NULL DEFAULT 0,
                             locked_until    TIMESTAMP    NULL,
                             created_at      TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
                             updated_at      TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                             CONSTRAINT fk_credentials_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;