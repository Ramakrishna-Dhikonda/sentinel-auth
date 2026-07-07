package com.sentinel.identity.user.repository;

import com.sentinel.identity.user.entity.PasswordHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PasswordHistoryRepository extends JpaRepository<PasswordHistory, UUID> {
}