CREATE TABLE users (
                       id             CHAR(36)     NOT NULL PRIMARY KEY,
                       email          VARCHAR(255) NOT NULL,
                       first_name     VARCHAR(100) NOT NULL,
                       last_name      VARCHAR(100) NOT NULL,
                       status         VARCHAR(20)  NOT NULL DEFAULT 'PENDING',
                       email_verified BOOLEAN      NOT NULL DEFAULT FALSE,
                       created_at     TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       updated_at     TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                       CONSTRAINT uq_users_email UNIQUE (email),
                       CONSTRAINT chk_users_status CHECK (status IN ('ACTIVE','DISABLED','PENDING'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE INDEX idx_users_status ON users(status);