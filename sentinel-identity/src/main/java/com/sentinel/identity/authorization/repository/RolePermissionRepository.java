package com.sentinel.identity.authorization.repository;

import com.sentinel.identity.authorization.entity.Permission;
import com.sentinel.identity.authorization.entity.Role;
import com.sentinel.identity.authorization.entity.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermission, UUID> {
    List<RolePermission> findByRole(Role role);
    Optional<RolePermission> findByRoleAndPermission(Role role, Permission permission);
    boolean existsByRoleAndPermission(Role role, Permission permission);
    void deleteByRoleAndPermission(Role role, Permission permission);
}