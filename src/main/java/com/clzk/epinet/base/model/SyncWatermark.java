package com.clzk.epinet.base.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "sync_watermark")
@Data
@NoArgsConstructor
public class SyncWatermark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entity_type", unique = true, nullable = false)
    private String entityType;

    @Column(name = "last_success_time", nullable = false)
    private LocalDateTime lastSuccessTime;

    @Column(name = "last_sync_count")
    private Long lastSyncCount = 0L;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "remark")
    private String remark;

    public SyncWatermark(String entityType, LocalDateTime lastSuccessTime) {
        this.entityType = entityType;
        this.lastSuccessTime = lastSuccessTime;
    }
}