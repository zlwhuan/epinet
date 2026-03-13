package com.clzk.epinet.base.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@MappedSuperclass
@Data
public abstract class BaseEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id", length = 80)
//    private String id;

//    private Timestamp lastUpdateTime; // 记录最后更新时间，用于增量同步
}
