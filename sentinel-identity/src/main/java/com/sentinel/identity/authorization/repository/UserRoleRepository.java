package com.sentinel.identity.authorization.repository;

import com.sentinel.identity.authorization.entity.Role;
import com.sentinel.identity.authorization.entity.UserRole;
import com.sentinel.identity.identity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UUID> {
    List<UserRole> findByUser(User user);
    Optional<UserRole> findByUserAndRole(User user, Role role);
    boolean existsByUserAndRole(User user, Role role);
    void deleteByUserAndRole(User user, Role role);
}