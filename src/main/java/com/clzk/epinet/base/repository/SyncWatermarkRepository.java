package com.clzk.epinet.base.repository;

import com.clzk.epinet.base.model.SyncWatermark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SyncWatermarkRepository extends JpaRepository<SyncWatermark, Long> {
    Optional<SyncWatermark> findByEntityType(String entityType);
}