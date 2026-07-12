CREATE TABLE roles (
                       id          BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name        VARCHAR(100) NOT NULL,
                       description VARCHAR(255),
                       created_at  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       updated_at  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                       CONSTRAINT uq_roles_name UNIQUE (name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;