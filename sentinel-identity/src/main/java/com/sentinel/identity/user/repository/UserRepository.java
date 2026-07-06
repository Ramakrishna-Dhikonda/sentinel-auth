package com.sentinel.identity.user.repository;

import com.sentinel.common.enums.AccountStatus;
import com.sentinel.identity.user.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);

    @Modifying
    @Transactional
    @Query("""
        UPDATE User u
            SET u.accountStatus = :status
            WHERE u.id = :userId
    """)
    int updateAccountStatus(@Param("userId") UUID id,@Param("status") AccountStatus status);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Transactional
    @Query("""
        UPDATE User u
            SET u.deletedAt = CURRENT_TIMESTAMP,
                u.updatedAt = CURRENT_TIMESTAMP
            WHERE u.id = :userId 
                AND u.deletedAt IS NULL
    """)
    int softDeleteUser(@Param("userId") UUID userId);
}
