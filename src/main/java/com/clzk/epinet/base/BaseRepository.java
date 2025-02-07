package com.clzk.epinet.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.time.LocalDateTime;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long> {

    // 查询最新的 lastUpdateTime
    @Query("SELECT MAX(e.lastUpdateTime) FROM #{#entityName} e")
    LocalDateTime findLatestUpdateTime();

}
