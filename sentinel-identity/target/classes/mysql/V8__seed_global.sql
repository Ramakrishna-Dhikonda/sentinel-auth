INSERT INTO users (id, email, first_name, last_name, status, email_verified, created_at) VALUES
                                                                                             ('a0000000-0000-0000-0000-000000000001','sarah.whitfield@meridianhealthgroup.com','Sarah','Whitfield','ACTIVE',TRUE,'2023-01-10 09:00:00'),
                                                                                             ('a0000000-0000-0000-0000-000000000002','marcus.chen@meridianhealthgroup.com','Marcus','Chen','ACTIVE',TRUE,'2023-01-12 09:15:00'),
                                                                                             ('a0000000-0000-0000-0000-000000000003','priya.raman@meridianhealthgroup.com','Priya','Raman','ACTIVE',TRUE,'2023-01-15 10:00:00'),
                                                                                             ('a0000000-0000-0000-0000-000000000004','david.oconnor@meridianhealthgroup.com','David','O''Connor','ACTIVE',TRUE,'2023-01-20 08:30:00'),
                                                                                             ('a0000000-0000-0000-0000-000000000005','fatima.alsayed@meridianhealthgroup.com','Fatima','Al-Sayed','ACTIVE',TRUE,'2023-02-01 09:00:00'),
                                                                                             ('a0000000-0000-0000-0000-000000000006','james.whitmore@meridianhealthgroup.com','James','Whitmore','ACTIVE',TRUE,'2023-02-05 09:00:00'),
                                                                                             ('a0000000-0000-0000-0000-000000000007','elena.petrova@meridianhealthgroup.com','Elena','Petrova','ACTIVE',TRUE,'2023-02-10 09:00:00'),
                                                                                             ('a0000000-0000-0000-0000-000000000008','carlos.mendoza@meridianhealthgroup.com','Carlos','Mendoza','ACTIVE',TRUE,'2023-02-14 09:00:00'),
                                                                                             ('a0000000-0000-0000-0000-000000000009','aisha.bello@meridianhealthgroup.com','Aisha','Bello','ACTIVE',TRUE,'2023-03-01 09:00:00'),
                                                                                             ('a0000000-0000-0000-0000-000000000010','thomas.kessler@meridianhealthgroup.com','Thomas','Kessler','ACTIVE',TRUE,'2023-03-05 09:00:00'),
                                                                                             ('a0000000-0000-0000-0000-000000000011','nina.kovacs@meridianhealthgroup.com','Nina','Kovacs','ACTIVE',TRUE,'2023-03-10 09:00:00'),
                                                                                             ('a0000000-0000-0000-0000-000000000012','rajesh.iyer@meridianhealthgroup.com','Rajesh','Iyer','ACTIVE',TRUE,'2023-03-15 09:00:00'),
                                                                                             ('a0000000-0000-0000-0000-000000000013','laura.bennett@meridianhealthgroup.com','Laura','Bennett','ACTIVE',TRUE,'2023-04-01 09:00:00'),
                                                                                             ('a0000000-0000-0000-0000-000000000014','hiroshi.tanaka@meridianhealthgroup.com','Hiroshi','Tanaka','ACTIVE',TRUE,'2023-04-10 09:00:00'),
                                                                                             ('a0000000-0000-0000-0000-000000000015','grace.okafor@meridianhealthgroup.com','Grace','Okafor','ACTIVE',TRUE,'2023-04-15 09:00:00'),
                                                                                             ('a0000000-0000-0000-0000-000000000016','michael.sullivan@meridianhealthgroup.com','Michael','Sullivan','ACTIVE',TRUE,'2023-05-01 09:00:00'),
                                                                                             ('a0000000-0000-0000-0000-000000000017','yuki.nakamura@meridianhealthgroup.com','Yuki','Nakamura','ACTIVE',TRUE,'2023-05-10 09:00:00'),
                                                                                             ('a0000000-0000-0000-0000-000000000018','daniel.fischer@meridianhealthgroup.com','Daniel','Fischer','ACTIVE',TRUE,'2023-05-15 09:00:00'),
                                                                                             ('a0000000-0000-0000-0000-000000000019','camille.dubois@meridianhealthgroup.com','Camille','Dubois','ACTIVE',TRUE,'2023-06-01 09:00:00'),
                                                                                             ('a0000000-0000-0000-0000-000000000020','robert.hayes@meridianhealthgroup.com','Robert','Hayes','ACTIVE',TRUE,'2023-06-10 09:00:00'),
                                                                                             ('a0000000-0000-0000-0000-000000000021','meera.nair@meridianhealthgroup.com','Meera','Nair','ACTIVE',TRUE,'2023-06-15 09:00:00'),
                                                                                             ('a0000000-0000-0000-0000-000000000022','andrew.collins@meridianhealthgroup.com','Andrew','Collins','ACTIVE',TRUE,'2023-07-01 09:00:00'),
                                                                                             ('a0000000-0000-0000-0000-000000000023','sofia.rossi@meridianhealthgroup.com','Sofia','Rossi','ACTIVE',TRUE,'2023-07-10 09:00:00'),
                                                                                             ('a0000000-0000-0000-0000-000000000024','kevin.park@meridianhealthgroup.com','Kevin','Park','ACTIVE',TRUE,'2023-07-15 09:00:00'),
                                                                                             ('a0000000-0000-0000-0000-000000000025','natasha.ivanova@meridianhealthgroup.com','Natasha','Ivanova','ACTIVE',TRUE,'2023-08-01 09:00:00'),
                                                                                             ('a0000000-0000-0000-0000-000000000026','brian.foster@meridianhealthgroup.com','Brian','Foster','DISABLED',TRUE,'2022-11-01 09:00:00'),
                                                                                             ('a0000000-0000-0000-0000-000000000027','leila.hassan@meridianhealthgroup.com','Leila','Hassan','DISABLED',TRUE,'2022-12-01 09:00:00'),
                                                                                             ('a0000000-0000-0000-0000-000000000028','william.turner@meridianhealthgroup.com','William','Turner','PENDING',FALSE,'2026-07-01 09:00:00'),
                                                                                             ('a0000000-0000-0000-0000-000000000029','anjali.deshpande@meridianhealthgroup.com','Anjali','Deshpande','PENDING',FALSE,'2026-07-05 09:00:00'),
                                                                                             ('a0000000-0000-0000-0000-000000000030','christopher.wood@meridianhealthgroup.com','Christopher','Wood','ACTIVE',TRUE,'2023-08-10 09:00:00');

-- password_hash values below are illustrative bcrypt-shaped strings, not real
-- hashes of any actual password -- they only exist to make the seed data look
-- like a genuine credentials table, never use these in application logic.
INSERT INTO credentials (user_id, password_hash, failed_attempts, locked_until) VALUES
                                                                                    ('a0000000-0000-0000-0000-000000000001','$2a$12$Kx9mQ2vL8pR3nT6wY1zA4uJhF7gD0sC5eB8iH2oN9kM3lP6rQ1xUu',0,NULL),
                                                                                    ('a0000000-0000-0000-0000-000000000002','$2a$12$Lz8nR3wM9qS4oU7xZ2aB5vKiG8hE1tD6fC9jI3pO0lN4mQ7sR2yVv',0,NULL),
                                                                                    ('a0000000-0000-0000-0000-000000000003','$2a$12$My9oS4xN0rT5pV8yA3bC6wLjH9iF2uE7gD0kJ4qP1mO5nR8tS3zWw',0,NULL),
                                                                                    ('a0000000-0000-0000-0000-000000000004','$2a$12$Nz0pT5yO1sU6qW9zB4cD7xMkI0jG3vF8hE1lK5rQ2nP6oS9uT4aXx',0,NULL),
                                                                                    ('a0000000-0000-0000-0000-000000000005','$2a$12$Oa1qU6zP2tV7rX0aC5dE8yNlJ1kH4wG9iF2mL6sR3oQ7pT0vU5bYy',0,NULL),
                                                                                    ('a0000000-0000-0000-0000-000000000006','$2a$12$Pb2rV7aQ3uW8sY1bD6eF9zOmK2lI5xH0jG3nM7tS4pR8qU1wV6cZz',0,NULL),
                                                                                    ('a0000000-0000-0000-0000-000000000007','$2a$12$Qc3sW8bR4vX9tZ2cE7fG0aPnL3mJ6yI1kH4oN8uT5qS9rV2xW7dAa',0,NULL),
                                                                                    ('a0000000-0000-0000-0000-000000000008','$2a$12$Rd4tX9cS5wY0uA3dF8gH1bQoM4nK7zJ2lI5pO9vU6rT0sW3yX8eBb',0,NULL),
                                                                                    ('a0000000-0000-0000-0000-000000000009','$2a$12$Se5uY0dT6xZ1vB4eG9hI2cRpN5oL8aK3mJ6qP0wV7sU1tX4zY9fCc',0,NULL),
                                                                                    ('a0000000-0000-0000-0000-000000000010','$2a$12$Tf6vZ1eU7yA2wC5fH0iJ3dSqO6pM9bL4nK7rQ1xW8tV2uY5aZ0gDd',0,NULL),
                                                                                    ('a0000000-0000-0000-0000-000000000011','$2a$12$Ug7wA2fV8zB3xD6gI1jK4eTrP7qN0cM5oL8sR2yX9uW3vZ6bA1hEe',0,NULL),
                                                                                    ('a0000000-0000-0000-0000-000000000012','$2a$12$Vh8xB3gW9aC4yE7hJ2kL5fUsQ8rO1dN6pM9tS3zY0vX4wA7cB2iFf',0,NULL),
                                                                                    ('a0000000-0000-0000-0000-000000000013','$2a$12$Wi9yC4hX0bD5zF8iK3lM6gVtR9sP2eO7qN0uT4aZ1wY5xB8dC3jGg',0,NULL),
                                                                                    ('a0000000-0000-0000-0000-000000000014','$2a$12$Xj0zD5iY1cE6aG9jL4mN7hWuS0tQ3fP8rO1vU5bA2xZ6yC9eD4kHh',0,NULL),
                                                                                    ('a0000000-0000-0000-0000-000000000015','$2a$12$Yk1aE6jZ2dF7bH0kM5nO8iXvT1uR4gQ9sP2wV6cB3yA7zD0fE5lIi',0,NULL),
                                                                                    ('a0000000-0000-0000-0000-000000000016','$2a$12$Zl2bF7kA3eG8cI1lN6oP9jYwU2vS5hR0tQ3xW7dC4zB8aE1gF6mJj',0,NULL),
                                                                                    ('a0000000-0000-0000-0000-000000000017','$2a$12$Am3cG8lB4fH9dJ2mO7pQ0kZxV3wT6iS1uR4yX8eD5aC9bF2hG7nKk',0,NULL),
                                                                                    ('a0000000-0000-0000-0000-000000000018','$2a$12$Bn4dH9mC5gI0eK3nP8qR1lAyW4xU7jT2vS5zY9fE6bD0cG3iH8oLl',0,NULL),
                                                                                    ('a0000000-0000-0000-0000-000000000019','$2a$12$Co5eI0nD6hJ1fL4oQ9rS2mBzX5yV8kU3wT6aZ0gF7cE1dH4jI9pMm',0,NULL),
                                                                                    ('a0000000-0000-0000-0000-000000000020','$2a$12$Dp6fJ1oE7iK2gM5pR0sT3nCaY6zW9lV4xU7bA1hG8dF2eI5kJ0qNn',0,NULL),
                                                                                    ('a0000000-0000-0000-0000-000000000021','$2a$12$Eq7gK2pF8jL3hN6qS1tU4oDbZ7aX0mW5yV8cB2iH9eG3fJ6lK1rOo',0,NULL),
                                                                                    ('a0000000-0000-0000-0000-000000000022','$2a$12$Fr8hL3qG9kM4iO7rT2uV5pEcA8bY1nX6zW9dC3jI0fH4gK7mL2sPp',0,NULL),
                                                                                    ('a0000000-0000-0000-0000-000000000023','$2a$12$Gs9iM4rH0lN5jP8sU3vW6qFdB9cZ2oY7aX0eD4kJ1gI5hL8nM3tQq',0,NULL),
                                                                                    ('a0000000-0000-0000-0000-000000000024','$2a$12$Ht0jN5sI1mO6kQ9tV4wX7rGeC0dA3pZ8bY1fE5lK2hJ6iM9oN4uRr',0,NULL),
                                                                                    ('a0000000-0000-0000-0000-000000000025','$2a$12$Iu1kO6tJ2nP7lR0uW5xY8sHfD1eB4qA9cZ2gF6mL3iK7jN0pO5vSs',0,NULL),
                                                                                    ('a0000000-0000-0000-0000-000000000026','$2a$12$Jv2lP7uK3oQ8mS1vX6yZ9tIgE2fC5rB0dA3hG7nM4jL8kO1qP6wTt',3,'2026-06-15 12:00:00'),
                                                                                    ('a0000000-0000-0000-0000-000000000027','$2a$12$Kw3mQ8vL4pR9nT2wY7zA0uJhF3gD6sC1eB4iH8oN5kM9lP2rQ7xUu',0,NULL),
                                                                                    ('a0000000-0000-0000-0000-000000000028','$2a$12$Lx4nR9wM5qS0oU3xZ8aB1vKiG4hE7tD2fC5jI9pO6lN0mQ3sR8yVv',0,NULL),
                                                                                    ('a0000000-0000-0000-0000-000000000029','$2a$12$My5oS0xN6rT1pV4yA9bC2wLjH5iF8uE3gD6kJ0qP7mO1nR4tS9zWw',0,NULL),
                                                                                    ('a0000000-0000-0000-0000-000000000030','$2a$12$Nz6pT1yO7sU2qW5zB0cD3xMkI6jG9vF4hE7lK1rQ8nP2oS5uT0aXx',0,NULL);

INSERT INTO roles (id, name, description) VALUES
                                              (1,'SUPER_ADMIN','Full platform access across all modules'),
                                              (2,'IT_ADMIN','Manages users, roles, and system configuration'),
                                              (3,'FINANCE_MANAGER','Oversees payroll processing and financial reporting'),
                                              (4,'HR_MANAGER','Manages employee records, leave approvals, and departments'),
                                              (5,'DEPARTMENT_MANAGER','Approves leave and views reports for their team'),
                                              (6,'COMPLIANCE_AUDITOR','Read-only access to audit trails and user records'),
                                              (7,'IT_SUPPORT','First-line support for account and access issues'),
                                              (8,'HR_STAFF','Handles day-to-day HR administrative tasks'),
                                              (9,'FINANCE_STAFF','Views payroll data for assigned employees'),
                                              (10,'EMPLOYEE','Baseline access for all staff');

INSERT INTO permissions (id, name, description) VALUES
                                                    (1,'user:create','Create new user accounts'),
                                                    (2,'user:read','View user account details'),
                                                    (3,'user:update','Update user profile information'),
                                                    (4,'user:disable','Disable a user account'),
                                                    (5,'user:delete','Permanently remove a user account'),
                                                    (6,'role:create','Create new roles'),
                                                    (7,'role:read','View roles and their permissions'),
                                                    (8,'role:assign','Assign a role to a user'),
                                                    (9,'role:revoke','Remove a role from a user'),
                                                    (10,'permission:read','View available permissions'),
                                                    (11,'permission:assign','Assign permissions to a role'),
                                                    (12,'leave:apply','Submit a leave request'),
                                                    (13,'leave:approve','Approve or reject leave requests'),
                                                    (14,'payroll:view','View payroll records'),
                                                    (15,'payroll:process','Process payroll runs'),
                                                    (16,'employee:view_profile','View employee profile details'),
                                                    (17,'employee:update_profile','Update employee profile details'),
                                                    (18,'department:manage','Manage department structure and assignments'),
                                                    (19,'report:view','View operational reports'),
                                                    (20,'report:generate','Generate new reports'),
                                                    (21,'audit:view','View audit log entries'),
                                                    (22,'system:configure','Modify platform-wide configuration');

INSERT INTO role_permissions (role_id, permission_id) VALUES
-- SUPER_ADMIN: everything
(1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),
(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,19),(1,20),(1,21),(1,22),
-- IT_ADMIN
(2,1),(2,2),(2,3),(2,4),(2,6),(2,7),(2,8),(2,9),(2,10),(2,11),(2,19),(2,22),
-- FINANCE_MANAGER
(3,14),(3,15),(3,16),(3,19),(3,20),
-- HR_MANAGER
(4,2),(4,3),(4,7),(4,8),(4,13),(4,16),(4,17),(4,18),(4,19),(4,20),
-- DEPARTMENT_MANAGER
(5,13),(5,16),(5,19),
-- COMPLIANCE_AUDITOR
(6,2),(6,7),(6,19),(6,21),
-- IT_SUPPORT
(7,2),(7,3),(7,16),
-- HR_STAFF
(8,12),(8,16),(8,17),
-- FINANCE_STAFF
(9,14),(9,16),
-- EMPLOYEE
(10,12),(10,16),(10,17);


INSERT INTO user_roles (user_id, role_id, granted_at, granted_by) VALUES
                                                                      ('a0000000-0000-0000-0000-000000000001',1,'2023-01-10 09:05:00',NULL),
                                                                      ('a0000000-0000-0000-0000-000000000002',2,'2023-01-12 09:20:00','a0000000-0000-0000-0000-000000000001'),
                                                                      ('a0000000-0000-0000-0000-000000000003',3,'2023-01-15 10:05:00','a0000000-0000-0000-0000-000000000001'),
                                                                      ('a0000000-0000-0000-0000-000000000004',4,'2023-01-20 08:35:00','a0000000-0000-0000-0000-000000000001'),
                                                                      ('a0000000-0000-0000-0000-000000000005',5,'2023-02-01 09:05:00','a0000000-0000-0000-0000-000000000004'),
                                                                      ('a0000000-0000-0000-0000-000000000006',6,'2023-02-05 09:05:00','a0000000-0000-0000-0000-000000000001'),
                                                                      ('a0000000-0000-0000-0000-000000000007',7,'2023-02-10 09:05:00','a0000000-0000-0000-0000-000000000002'),
                                                                      ('a0000000-0000-0000-0000-000000000008',7,'2023-02-14 09:05:00','a0000000-0000-0000-0000-000000000002'),
                                                                      ('a0000000-0000-0000-0000-000000000009',8,'2023-03-01 09:05:00','a0000000-0000-0000-0000-000000000004'),
                                                                      ('a0000000-0000-0000-0000-000000000010',8,'2023-03-05 09:05:00','a0000000-0000-0000-0000-000000000004'),
                                                                      ('a0000000-0000-0000-0000-000000000011',9,'2023-03-10 09:05:00','a0000000-0000-0000-0000-000000000003'),
                                                                      ('a0000000-0000-0000-0000-000000000012',9,'2023-03-15 09:05:00','a0000000-0000-0000-0000-000000000003'),
                                                                      ('a0000000-0000-0000-0000-000000000013',5,'2023-04-01 09:05:00','a0000000-0000-0000-0000-000000000004'),
                                                                      ('a0000000-0000-0000-0000-000000000014',10,'2023-04-10 09:05:00','a0000000-0000-0000-0000-000000000004'),
                                                                      ('a0000000-0000-0000-0000-000000000015',10,'2023-04-15 09:05:00','a0000000-0000-0000-0000-000000000004'),
                                                                      ('a0000000-0000-0000-0000-000000000016',10,'2023-05-01 09:05:00','a0000000-0000-0000-0000-000000000004'),
                                                                      ('a0000000-0000-0000-0000-000000000017',10,'2023-05-10 09:05:00','a0000000-0000-0000-0000-000000000004'),
                                                                      ('a0000000-0000-0000-0000-000000000018',10,'2023-05-15 09:05:00','a0000000-0000-0000-0000-000000000004'),
                                                                      ('a0000000-0000-0000-0000-000000000019',10,'2023-06-01 09:05:00','a0000000-0000-0000-0000-000000000004'),
                                                                      ('a0000000-0000-0000-0000-000000000020',10,'2023-06-10 09:05:00','a0000000-0000-0000-0000-000000000004'),
                                                                      ('a0000000-0000-0000-0000-000000000021',10,'2023-06-15 09:05:00','a0000000-0000-0000-0000-000000000004'),
                                                                      ('a0000000-0000-0000-0000-000000000022',10,'2023-07-01 09:05:00','a0000000-0000-0000-0000-000000000004'),
                                                                      ('a0000000-0000-0000-0000-000000000023',10,'2023-07-10 09:05:00','a0000000-0000-0000-0000-000000000004'),
                                                                      ('a0000000-0000-0000-0000-000000000024',10,'2023-07-15 09:05:00','a0000000-0000-0000-0000-000000000004'),
                                                                      ('a0000000-0000-0000-0000-000000000025',10,'2023-08-01 09:05:00','a0000000-0000-0000-0000-000000000004'),
                                                                      ('a0000000-0000-0000-0000-000000000026',10,'2022-11-01 09:05:00','a0000000-0000-0000-0000-000000000004'),
                                                                      ('a0000000-0000-0000-0000-000000000027',10,'2022-12-01 09:05:00','a0000000-0000-0000-0000-000000000004'),
                                                                      ('a0000000-0000-0000-0000-000000000028',10,'2026-07-01 09:05:00','a0000000-0000-0000-0000-000000000004'),
                                                                      ('a0000000-0000-0000-0000-000000000029',10,'2026-07-05 09:05:00','a0000000-0000-0000-0000-000000000004'),
                                                                      ('a0000000-0000-0000-0000-000000000030',7,'2023-08-10 09:05:00','a0000000-0000-0000-0000-000000000002');


-- Only a handful of rows: refresh tokens represent *currently active sessions*,
-- not historical data, so most of the 30 users simply won't have one at any
-- given moment. This is intentionally sparse, unlike the other tables.
INSERT INTO refresh_tokens (id, user_id, token_hash, device_info, ip_address, expires_at, created_at) VALUES
                                                                                                          ('b0000000-0000-0000-0000-000000000001','a0000000-0000-0000-0000-000000000001','f3a1c9e7b2d4568a9c0e1f2a3b4c5d6e7f8091a2b3c4d5e6f708192a3b4c5d6','Chrome 126 on Windows 11','203.0.113.10','2026-07-18 09:00:00','2026-07-11 09:00:00'),
                                                                                                          ('b0000000-0000-0000-0000-000000000002','a0000000-0000-0000-0000-000000000002','a1b2c3d4e5f60718293a4b5c6d7e8f90a1b2c3d4e5f60718293a4b5c6d7e8f9','Safari 17 on macOS','203.0.113.22','2026-07-17 14:30:00','2026-07-10 14:30:00'),
                                                                                                          ('b0000000-0000-0000-0000-000000000003','a0000000-0000-0000-0000-000000000002','c9d8e7f6a5b4031928374655463728190a1b2c3d4e5f60718293a4b5c6d7e8','Chrome Mobile on Android 15','198.51.100.14','2026-07-19 08:15:00','2026-07-11 08:15:00'),
                                                                                                          ('b0000000-0000-0000-0000-000000000004','a0000000-0000-0000-0000-000000000004','e5f6a7b8c9d0e1f2a3b4c5d6e7f8091a2b3c4d5e6f708192a3b4c5d6e7f8091','Edge 126 on Windows 11','203.0.113.31','2026-07-16 11:00:00','2026-07-09 11:00:00'),
                                                                                                          ('b0000000-0000-0000-0000-000000000005','a0000000-0000-0000-0000-000000000007','1a2b3c4d5e6f708192a3b4c5d6e7f8091a2b3c4d5e6f708192a3b4c5d6e7f80','Chrome 126 on Windows 11','203.0.113.45','2026-07-18 07:45:00','2026-07-11 07:45:00'),
                                                                                                          ('b0000000-0000-0000-0000-000000000006','a0000000-0000-0000-0000-000000000009','9f8e7d6c5b4a3928170615243342516071829a3b4c5d6e7f8091a2b3c4d5e6','Firefox 128 on Ubuntu','198.51.100.60','2026-07-17 13:20:00','2026-07-10 13:20:00'),
                                                                                                          ('b0000000-0000-0000-0000-000000000007','a0000000-0000-0000-0000-000000000011','3c4d5e6f708192a3b4c5d6e7f8091a2b3c4d5e6f708192a3b4c5d6e7f8091a2','Safari 17 on iPadOS','203.0.113.52','2026-07-16 16:00:00','2026-07-09 16:00:00'),
                                                                                                          ('b0000000-0000-0000-0000-000000000008','a0000000-0000-0000-0000-000000000014','5e6f708192a3b4c5d6e7f8091a2b3c4d5e6f708192a3b4c5d6e7f8091a2b3c4','Chrome 126 on macOS','198.51.100.71','2026-07-18 10:30:00','2026-07-11 10:30:00'),
                                                                                                          ('b0000000-0000-0000-0000-000000000009','a0000000-0000-0000-0000-000000000019','7f8091a2b3c4d5e6f708192a3b4c5d6e7f8091a2b3c4d5e6f708192a3b4c5d6','Chrome Mobile on iOS 18','203.0.113.66','2026-07-17 12:10:00','2026-07-10 12:10:00'),
                                                                                                          ('b0000000-0000-0000-0000-000000000010','a0000000-0000-0000-0000-000000000021','091a2b3c4d5e6f708192a3b4c5d6e7f8091a2b3c4d5e6f708192a3b4c5d6e7f','Edge 126 on Windows 11','198.51.100.83','2026-07-16 09:50:00','2026-07-09 09:50:00'),
                                                                                                          ('b0000000-0000-0000-0000-000000000011','a0000000-0000-0000-0000-000000000024','2b3c4d5e6f708192a3b4c5d6e7f8091a2b3c4d5e6f708192a3b4c5d6e7f8091','Chrome 126 on Windows 11','203.0.113.77','2026-07-18 15:40:00','2026-07-11 15:40:00'),
                                                                                                          ('b0000000-0000-0000-0000-000000000012','a0000000-0000-0000-0000-000000000030','4d5e6f708192a3b4c5d6e7f8091a2b3c4d5e6f708192a3b4c5d6e7f8091a2b3','Firefox 128 on Windows 11','198.51.100.94','2026-07-17 08:00:00','2026-07-10 08:00:00');


