package com.clzk.epinet.base.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "api_call_logs")
public class ApiCallLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "interface_name", nullable = false)
    private String interfaceName;

    @Column(name = "request_time", nullable = false)
    private LocalDateTime requestTime;

    @Column(name = "response_time")
    private LocalDateTime responseTime;

    @Lob
    @Column(name = "request_params", columnDefinition = "LONGTEXT")
    private String requestParams;

    @Lob
    @Column(name = "response_result", columnDefinition = "LONGTEXT")
    private String responseResult;

    @Column(name = "status")
    private String status;

    @Column(name = "error_message")
    private String errorMessage;

    @Column(name = "duration_ms")
    private Long durationMs;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
