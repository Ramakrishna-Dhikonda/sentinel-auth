-- ============================================================
-- Seed Data - Identity
-- ============================================================

---------------------------------------------------------------
-- USERS
---------------------------------------------------------------

INSERT INTO users (
    id,
    username,
    email,
    phone_number,
    display_name,
    avatar_url,
    account_status,
    email_verified,
    phone_verified,
    last_login_at,
    created_at,
    created_by,
    updated_at,
    updated_by,
    deleted_at,
    version
) VALUES

      ('11111111-1111-1111-1111-111111111111',
       'admin',
       'admin@sentinel.com',
       '9999999991',
       'System Administrator',
       'https://picsum.photos/200?1',
       1,
       TRUE,
       TRUE,
       CURRENT_TIMESTAMP,
       CURRENT_TIMESTAMP,
       NULL,
       CURRENT_TIMESTAMP,
       NULL,
       NULL,
       0),

      ('22222222-2222-2222-2222-222222222222',
       'john',
       'john@sentinel.com',
       '9999999992',
       'John Doe',
       'https://picsum.photos/200?2',
       1,
       TRUE,
       TRUE,
       CURRENT_TIMESTAMP,
       CURRENT_TIMESTAMP,
       NULL,
       CURRENT_TIMESTAMP,
       NULL,
       NULL,
       0),

      ('33333333-3333-3333-3333-333333333333',
       'jane',
       'jane@sentinel.com',
       '9999999993',
       'Jane Smith',
       'https://picsum.photos/200?3',
       1,
       TRUE,
       FALSE,
       CURRENT_TIMESTAMP,
       CURRENT_TIMESTAMP,
       NULL,
       CURRENT_TIMESTAMP,
       NULL,
       NULL,
       0),

      ('44444444-4444-4444-4444-444444444444',
       'michael',
       'michael@sentinel.com',
       '9999999994',
       'Michael Johnson',
       'https://picsum.photos/200?4',
       1,
       TRUE,
       TRUE,
       CURRENT_TIMESTAMP,
       CURRENT_TIMESTAMP,
       NULL,
       CURRENT_TIMESTAMP,
       NULL,
       NULL,
       0),

      ('55555555-5555-5555-5555-555555555555',
       'emily',
       'emily@sentinel.com',
       '9999999995',
       'Emily Davis',
       'https://picsum.photos/200?5',
       1,
       TRUE,
       FALSE,
       CURRENT_TIMESTAMP,
       CURRENT_TIMESTAMP,
       NULL,
       CURRENT_TIMESTAMP,
       NULL,
       NULL,
       0),

      ('66666666-6666-6666-6666-666666666666',
       'david',
       'david@sentinel.com',
       '9999999996',
       'David Wilson',
       'https://picsum.photos/200?6',
       2,
       TRUE,
       TRUE,
       CURRENT_TIMESTAMP,
       CURRENT_TIMESTAMP,
       NULL,
       CURRENT_TIMESTAMP,
       NULL,
       NULL,
       0),

      ('77777777-7777-7777-7777-777777777777',
       'sophia',
       'sophia@sentinel.com',
       '9999999997',
       'Sophia Brown',
       'https://picsum.photos/200?7',
       3,
       FALSE,
       FALSE,
       NULL,
       CURRENT_TIMESTAMP,
       NULL,
       CURRENT_TIMESTAMP,
       NULL,
       NULL,
       0),

      ('88888888-8888-8888-8888-888888888888',
       'william',
       'william@sentinel.com',
       '9999999998',
       'William Taylor',
       'https://picsum.photos/200?8',
       4,
       TRUE,
       TRUE,
       CURRENT_TIMESTAMP,
       CURRENT_TIMESTAMP,
       NULL,
       CURRENT_TIMESTAMP,
       NULL,
       NULL,
       0),

      ('99999999-9999-9999-9999-999999999999',
       'olivia',
       'olivia@sentinel.com',
       '9999999999',
       'Olivia Anderson',
       'https://picsum.photos/200?9',
       1,
       TRUE,
       TRUE,
       CURRENT_TIMESTAMP,
       CURRENT_TIMESTAMP,
       NULL,
       CURRENT_TIMESTAMP,
       NULL,
       NULL,
       0),

      ('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
       'ram',
       'ram@sentinel.com',
       '9999999900',
       'Ramakrishna',
       'https://picsum.photos/200?10',
       1,
       TRUE,
       TRUE,
       CURRENT_TIMESTAMP,
       CURRENT_TIMESTAMP,
       NULL,
       CURRENT_TIMESTAMP,
       NULL,
       NULL,
       0);

---------------------------------------------------------------
-- USER PREFERENCES
---------------------------------------------------------------

INSERT INTO user_preferences (
    id,
    user_id,
    theme,
    language,
    timezone,
    email_notifications,
    sms_notifications,
    push_notifications,
    mfa_enabled,
    created_at,
    created_by,
    updated_at,
    updated_by,
    deleted_at,
    version
)
VALUES

    ('b1111111-1111-1111-1111-111111111111','11111111-1111-1111-1111-111111111111','DARK','en','Asia/Kolkata',TRUE,FALSE,TRUE,TRUE,CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),

    ('b2222222-2222-2222-2222-222222222222','22222222-2222-2222-2222-222222222222','LIGHT','en','Asia/Kolkata',TRUE,TRUE,TRUE,FALSE,CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),

    ('b3333333-3333-3333-3333-333333333333','33333333-3333-3333-3333-333333333333','SYSTEM','en','Asia/Kolkata',TRUE,FALSE,TRUE,FALSE,CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),

    ('b4444444-4444-4444-4444-444444444444','44444444-4444-4444-4444-444444444444','DARK','en','UTC',TRUE,FALSE,TRUE,TRUE,CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),

    ('b5555555-5555-5555-5555-555555555555','55555555-5555-5555-5555-555555555555','LIGHT','en','UTC',TRUE,TRUE,FALSE,FALSE,CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),

    ('b6666666-6666-6666-6666-666666666666','66666666-6666-6666-6666-666666666666','SYSTEM','en','Asia/Kolkata',FALSE,FALSE,TRUE,TRUE,CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),

    ('b7777777-7777-7777-7777-777777777777','77777777-7777-7777-7777-777777777777','DARK','en','Asia/Kolkata',TRUE,FALSE,FALSE,FALSE,CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),

    ('b8888888-8888-8888-8888-888888888888','88888888-8888-8888-8888-888888888888','LIGHT','en','UTC',TRUE,FALSE,TRUE,FALSE,CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),

    ('b9999999-9999-9999-9999-999999999999','99999999-9999-9999-9999-999999999999','SYSTEM','en','Asia/Kolkata',TRUE,TRUE,TRUE,FALSE,CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),

    ('baaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa','aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa','DARK','en','Asia/Kolkata',TRUE,TRUE,TRUE,TRUE,CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0);

-- ============================================================
-- SentinelAuth
-- Seed Data
-- Authorization
-- Version : V1001__seed_authorization.sql
-- ============================================================

---------------------------------------------------------------
-- ROLES
---------------------------------------------------------------

INSERT INTO roles (
    id,
    name,
    code,
    description,
    system_role,
    created_at,
    created_by,
    updated_at,
    updated_by,
    deleted_at,
    version
)
VALUES

    ('10000000-0000-0000-0000-000000000001','Super Administrator','SUPER_ADMIN','Full system access',TRUE,CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),

    ('10000000-0000-0000-0000-000000000002','Administrator','ADMIN','Administrative access',TRUE,CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),

    ('10000000-0000-0000-0000-000000000003','Manager','MANAGER','Manager role',FALSE,CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),

    ('10000000-0000-0000-0000-000000000004','Support','SUPPORT','Support team',FALSE,CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),

    ('10000000-0000-0000-0000-000000000005','User','USER','Regular application user',FALSE,CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0);

---------------------------------------------------------------
-- PERMISSIONS
---------------------------------------------------------------

INSERT INTO permissions
(id,name,code,module,description,created_at,created_by,updated_at,updated_by,deleted_at,version)
VALUES

    ('20000000-0000-0000-0000-000000000001','Create User','USER_CREATE','USER','Create users',CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),
    ('20000000-0000-0000-0000-000000000002','Read User','USER_READ','USER','Read users',CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),
    ('20000000-0000-0000-0000-000000000003','Update User','USER_UPDATE','USER','Update users',CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),
    ('20000000-0000-0000-0000-000000000004','Delete User','USER_DELETE','USER','Delete users',CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),

    ('20000000-0000-0000-0000-000000000005','Create Role','ROLE_CREATE','ROLE','Create roles',CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),
    ('20000000-0000-0000-0000-000000000006','Read Role','ROLE_READ','ROLE','Read roles',CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),
    ('20000000-0000-0000-0000-000000000007','Update Role','ROLE_UPDATE','ROLE','Update roles',CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),
    ('20000000-0000-0000-0000-000000000008','Delete Role','ROLE_DELETE','ROLE','Delete roles',CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),

    ('20000000-0000-0000-0000-000000000009','Create Permission','PERMISSION_CREATE','PERMISSION','Create permissions',CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),
    ('20000000-0000-0000-0000-000000000010','Read Permission','PERMISSION_READ','PERMISSION','Read permissions',CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),
    ('20000000-0000-0000-0000-000000000011','Update Permission','PERMISSION_UPDATE','PERMISSION','Update permissions',CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),
    ('20000000-0000-0000-0000-000000000012','Delete Permission','PERMISSION_DELETE','PERMISSION','Delete permissions',CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),

    ('20000000-0000-0000-0000-000000000013','Assign Role','ROLE_ASSIGN','ROLE','Assign role to user',CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),
    ('20000000-0000-0000-0000-000000000014','Remove Role','ROLE_REMOVE','ROLE','Remove role',CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),

    ('20000000-0000-0000-0000-000000000015','Login','AUTH_LOGIN','AUTH','User login',CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),
    ('20000000-0000-0000-0000-000000000016','Logout','AUTH_LOGOUT','AUTH','User logout',CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),

    ('20000000-0000-0000-0000-000000000017','Reset Password','PASSWORD_RESET','AUTH','Reset password',CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),
    ('20000000-0000-0000-0000-000000000018','Change Password','PASSWORD_CHANGE','AUTH','Change password',CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),

    ('20000000-0000-0000-0000-000000000019','Read Audit','AUDIT_READ','AUDIT','Read audit logs',CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),
    ('20000000-0000-0000-0000-000000000020','Export Audit','AUDIT_EXPORT','AUDIT','Export audit logs',CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0);

---------------------------------------------------------------
-- USER ROLES
---------------------------------------------------------------

INSERT INTO user_roles
(id,user_id,role_id,assigned_at,expires_at,created_at,created_by,updated_at,updated_by,deleted_at,version)
VALUES

    ('30000000-0000-0000-0000-000000000001',
     '11111111-1111-1111-1111-111111111111',
     '10000000-0000-0000-0000-000000000001',
     CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),

    ('30000000-0000-0000-0000-000000000002',
     '22222222-2222-2222-2222-222222222222',
     '10000000-0000-0000-0000-000000000002',
     CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),

    ('30000000-0000-0000-0000-000000000003',
     '33333333-3333-3333-3333-333333333333',
     '10000000-0000-0000-0000-000000000003',
     CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),

    ('30000000-0000-0000-0000-000000000004',
     '44444444-4444-4444-4444-444444444444',
     '10000000-0000-0000-0000-000000000004',
     CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),

    ('30000000-0000-0000-0000-000000000005',
     'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
     '10000000-0000-0000-0000-000000000005',
     CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0);

---------------------------------------------------------------
-- ROLE PERMISSIONS
---------------------------------------------------------------

-- SUPER_ADMIN gets everything

INSERT INTO role_permissions
(id,role_id,permission_id,created_at,created_by,updated_at,updated_by,deleted_at,version)

SELECT
    RANDOM_UUID(),
    '10000000-0000-0000-0000-000000000001',
    id,
    CURRENT_TIMESTAMP,
    NULL,
    CURRENT_TIMESTAMP,
    NULL,
    NULL,
    0
FROM permissions;

---------------------------------------------------------------
-- ADMIN
---------------------------------------------------------------

INSERT INTO role_permissions
VALUES
    (RANDOM_UUID(),'10000000-0000-0000-0000-000000000002','20000000-0000-0000-0000-000000000001',CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),
    (RANDOM_UUID(),'10000000-0000-0000-0000-000000000002','20000000-0000-0000-0000-000000000002',CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),
    (RANDOM_UUID(),'10000000-0000-0000-0000-000000000002','20000000-0000-0000-0000-000000000003',CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),
    (RANDOM_UUID(),'10000000-0000-0000-0000-000000000002','20000000-0000-0000-0000-000000000005',CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),
    (RANDOM_UUID(),'10000000-0000-0000-0000-000000000002','20000000-0000-0000-0000-000000000006',CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),
    (RANDOM_UUID(),'10000000-0000-0000-0000-000000000002','20000000-0000-0000-0000-000000000015',CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),
    (RANDOM_UUID(),'10000000-0000-0000-0000-000000000002','20000000-0000-0000-0000-000000000016',CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0);

---------------------------------------------------------------
-- MANAGER
---------------------------------------------------------------

INSERT INTO role_permissions
VALUES
    (RANDOM_UUID(),'10000000-0000-0000-0000-000000000003','20000000-0000-0000-0000-000000000002',CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),
    (RANDOM_UUID(),'10000000-0000-0000-0000-000000000003','20000000-0000-0000-0000-000000000003',CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0);

---------------------------------------------------------------
-- SUPPORT
---------------------------------------------------------------

INSERT INTO role_permissions
VALUES
    (RANDOM_UUID(),'10000000-0000-0000-0000-000000000004','20000000-0000-0000-0000-000000000002',CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),
    (RANDOM_UUID(),'10000000-0000-0000-0000-000000000004','20000000-0000-0000-0000-000000000017',CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0);

---------------------------------------------------------------
-- USER
---------------------------------------------------------------

INSERT INTO role_permissions
VALUES
    (RANDOM_UUID(),'10000000-0000-0000-0000-000000000005','20000000-0000-0000-0000-000000000015',CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),
    (RANDOM_UUID(),'10000000-0000-0000-0000-000000000005','20000000-0000-0000-0000-000000000016',CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),
    (RANDOM_UUID(),'10000000-0000-0000-0000-000000000005','20000000-0000-0000-0000-000000000018',CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0);

-- ============================================================
-- SentinelAuth
-- Seed Data
-- Authentication
-- Version : V1002__seed_authentication.sql
-- ============================================================

---------------------------------------------------------------
-- PASSWORD
--
-- Plain password for every user:
--
-- Password@123
--
-- BCrypt Hash:
-- $2a$10$7EqJtq98hPqEX7fNZaFWoOHi6J4jN8QwQJQ0lP5zP9Q6yGQx6vF8K
---------------------------------------------------------------

---------------------------------------------------------------
-- USER CREDENTIALS
---------------------------------------------------------------

INSERT INTO user_credentials
(
    id,
    user_id,
    password_hash,
    password_algorithm,
    password_changed_at,
    password_expires_at,
    account_non_locked,
    account_non_expired,
    credentials_non_expired,
    enabled,
    failed_login_attempts,
    last_failed_login_at,
    last_successful_login_at,
    created_at,
    created_by,
    updated_at,
    updated_by,
    deleted_at,
    version
)
VALUES

    (RANDOM_UUID(),'11111111-1111-1111-1111-111111111111','$2a$10$7EqJtq98hPqEX7fNZaFWoOHi6J4jN8QwQJQ0lP5zP9Q6yGQx6vF8K','BCRYPT',CURRENT_TIMESTAMP,NULL,TRUE,TRUE,TRUE,TRUE,0,NULL,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),

    (RANDOM_UUID(),'22222222-2222-2222-2222-222222222222','$2a$10$7EqJtq98hPqEX7fNZaFWoOHi6J4jN8QwQJQ0lP5zP9Q6yGQx6vF8K','BCRYPT',CURRENT_TIMESTAMP,NULL,TRUE,TRUE,TRUE,TRUE,0,NULL,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),

    (RANDOM_UUID(),'33333333-3333-3333-3333-333333333333','$2a$10$7EqJtq98hPqEX7fNZaFWoOHi6J4jN8QwQJQ0lP5zP9Q6yGQx6vF8K','BCRYPT',CURRENT_TIMESTAMP,NULL,TRUE,TRUE,TRUE,TRUE,1,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),

    (RANDOM_UUID(),'44444444-4444-4444-4444-444444444444','$2a$10$7EqJtq98hPqEX7fNZaFWoOHi6J4jN8QwQJQ0lP5zP9Q6yGQx6vF8K','BCRYPT',CURRENT_TIMESTAMP,NULL,FALSE,TRUE,TRUE,TRUE,5,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),

    (RANDOM_UUID(),'55555555-5555-5555-5555-555555555555','$2a$10$7EqJtq98hPqEX7fNZaFWoOHi6J4jN8QwQJQ0lP5zP9Q6yGQx6vF8K','BCRYPT',CURRENT_TIMESTAMP,NULL,TRUE,TRUE,TRUE,TRUE,0,NULL,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),

    (RANDOM_UUID(),'66666666-6666-6666-6666-666666666666','$2a$10$7EqJtq98hPqEX7fNZaFWoOHi6J4jN8QwQJQ0lP5zP9Q6yGQx6vF8K','BCRYPT',CURRENT_TIMESTAMP,NULL,FALSE,TRUE,TRUE,TRUE,8,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),

    (RANDOM_UUID(),'77777777-7777-7777-7777-777777777777','$2a$10$7EqJtq98hPqEX7fNZaFWoOHi6J4jN8QwQJQ0lP5zP9Q6yGQx6vF8K','BCRYPT',CURRENT_TIMESTAMP,NULL,TRUE,TRUE,TRUE,FALSE,0,NULL,NULL,CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),

    (RANDOM_UUID(),'88888888-8888-8888-8888-888888888888','$2a$10$7EqJtq98hPqEX7fNZaFWoOHi6J4jN8QwQJQ0lP5zP9Q6yGQx6vF8K','BCRYPT',CURRENT_TIMESTAMP,NULL,TRUE,TRUE,TRUE,TRUE,2,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),

    (RANDOM_UUID(),'99999999-9999-9999-9999-999999999999','$2a$10$7EqJtq98hPqEX7fNZaFWoOHi6J4jN8QwQJQ0lP5zP9Q6yGQx6vF8K','BCRYPT',CURRENT_TIMESTAMP,NULL,TRUE,TRUE,TRUE,TRUE,0,NULL,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),

    (RANDOM_UUID(),'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa','$2a$10$7EqJtq98hPqEX7fNZaFWoOHi6J4jN8QwQJQ0lP5zP9Q6yGQx6vF8K','BCRYPT',CURRENT_TIMESTAMP,NULL,TRUE,TRUE,TRUE,TRUE,0,NULL,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0);

---------------------------------------------------------------
-- PASSWORD HISTORY
---------------------------------------------------------------

INSERT INTO password_history
(
    id,
    user_id,
    password_hash,
    created_at,
    created_by,
    updated_at,
    updated_by,
    deleted_at,
    version
)
SELECT
    RANDOM_UUID(),
    user_id,
    password_hash,
    CURRENT_TIMESTAMP,
    NULL,
    CURRENT_TIMESTAMP,
    NULL,
    NULL,
    0
FROM user_credentials;

---------------------------------------------------------------
-- EMAIL VERIFICATION TOKENS
---------------------------------------------------------------

INSERT INTO email_verification_tokens
(
    id,
    user_id,
    token,
    expires_at,
    verified_at,
    created_at,
    created_by,
    updated_at,
    updated_by,
    deleted_at,
    version
)
SELECT
    RANDOM_UUID(),
    id,
    CONCAT('EMAIL-',REPLACE(id,'-','')),
    DATEADD('DAY',7,CURRENT_TIMESTAMP),
    CASE
        WHEN email_verified THEN CURRENT_TIMESTAMP
        ELSE NULL
        END,
    CURRENT_TIMESTAMP,
    NULL,
    CURRENT_TIMESTAMP,
    NULL,
    NULL,
    0
FROM users;

---------------------------------------------------------------
-- PASSWORD RESET TOKENS
---------------------------------------------------------------

INSERT INTO password_reset_tokens
(
    id,
    user_id,
    token,
    expires_at,
    used_at,
    created_at,
    created_by,
    updated_at,
    updated_by,
    deleted_at,
    version
)
VALUES

    (RANDOM_UUID(),'22222222-2222-2222-2222-222222222222','RESET-1001',DATEADD('DAY',1,CURRENT_TIMESTAMP),NULL,CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),

    (RANDOM_UUID(),'33333333-3333-3333-3333-333333333333','RESET-1002',DATEADD('DAY',1,CURRENT_TIMESTAMP),NULL,CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0),

    (RANDOM_UUID(),'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa','RESET-1003',DATEADD('DAY',1,CURRENT_TIMESTAMP),NULL,CURRENT_TIMESTAMP,NULL,CURRENT_TIMESTAMP,NULL,NULL,0);

---------------------------------------------------------------
-- REFRESH TOKENS
---------------------------------------------------------------

INSERT INTO refresh_tokens
(
    id,
    user_id,
    token,
    device_id,
    device_name,
    ip_address,
    user_agent,
    expires_at,
    revoked,
    revoked_at,
    created_at,
    created_by,
    updated_at,
    updated_by,
    deleted_at,
    version
)
VALUES

    (RANDOM_UUID(),
     '11111111-1111-1111-1111-111111111111',
     'REFRESH-TOKEN-ADMIN',
     'DEVICE-1001',
     'MacBook Pro',
     '192.168.1.10',
     'Chrome',
     DATEADD('DAY',30,CURRENT_TIMESTAMP),
     FALSE,
     NULL,
     CURRENT_TIMESTAMP,
     NULL,
     CURRENT_TIMESTAMP,
     NULL,
     NULL,
     0),

    (RANDOM_UUID(),
     '22222222-2222-2222-2222-222222222222',
     'REFRESH-TOKEN-JOHN',
     'DEVICE-1002',
     'iPhone 16 Pro',
     '192.168.1.11',
     'Safari',
     DATEADD('DAY',30,CURRENT_TIMESTAMP),
     FALSE,
     NULL,
     CURRENT_TIMESTAMP,
     NULL,
     CURRENT_TIMESTAMP,
     NULL,
     NULL,
     0),

    (RANDOM_UUID(),
     'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
     'REFRESH-TOKEN-RAM',
     'DEVICE-1003',
     'MacBook Air M5',
     '192.168.1.12',
     'Chrome',
     DATEADD('DAY',30,CURRENT_TIMESTAMP),
     FALSE,
     NULL,
     CURRENT_TIMESTAMP,
     NULL,
     CURRENT_TIMESTAMP,
     NULL,
     NULL,
     0);