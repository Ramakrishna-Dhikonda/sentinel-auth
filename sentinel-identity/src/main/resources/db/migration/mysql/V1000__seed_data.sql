INSERT INTO roles (id, name, description) VALUES
                                              (1, 'SUPER_ADMIN', 'System Administrator'),
                                              (2, 'ADMIN', 'Administrator'),
                                              (3, 'MANAGER', 'Manager'),
                                              (4, 'USER', 'Regular User');
INSERT INTO users (
    id,
    username,
    email,
    password,
    enabled,
    account_non_locked
)
VALUES
    (
        1,
        'superadmin',
        'superadmin@sentinel.com',
        '$2a$10$7EqJtq98hPqEX7fNZaFWoOHi6J4jN8QwQJQ0lP5zP9Q6yGQx6vF8K',
        TRUE,
        TRUE
    ),
    (
        2,
        'admin',
        'admin@sentinel.com',
        '$2a$10$7EqJtq98hPqEX7fNZaFWoOHi6J4jN8QwQJQ0lP5zP9Q6yGQx6vF8K',
        TRUE,
        TRUE
    ),
    (
        3,
        'john',
        'john@sentinel.com',
        '$2a$10$7EqJtq98hPqEX7fNZaFWoOHi6J4jN8QwQJQ0lP5zP9Q6yGQx6vF8K',
        TRUE,
        TRUE
    );
INSERT INTO user_roles(user_id, role_id)
VALUES
    (1,1),
    (2,2),
    (3,4);
INSERT INTO permissions(id, name)
VALUES
    (1,'USER_READ'),
    (2,'USER_CREATE'),
    (3,'USER_UPDATE'),
    (4,'USER_DELETE'),
    (5,'ROLE_READ'),
    (6,'ROLE_CREATE'),
    (7,'ROLE_UPDATE'),
    (8,'ROLE_DELETE');
INSERT INTO role_permissions(role_id, permission_id)
VALUES
    (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),
    (2,1),(2,2),(2,3),(2,5),
    (3,1),(3,5),
    (4,1);