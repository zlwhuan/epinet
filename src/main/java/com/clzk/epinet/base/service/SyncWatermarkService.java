package com.clzk.epinet.base.service;

import com.clzk.epinet.base.model.SyncWatermark;
import com.clzk.epinet.base.repository.SyncWatermarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SyncWatermarkService {

    private final SyncWatermarkRepository watermarkRepository;

    /**
     * 获取上次成功同步时间，如果不存在，返回远古时间（全量同步）
     */
    @Transactional(value = "baseTransactionManager", readOnly = true)
    public LocalDateTime getLastSyncTime(String entityType) {
        return watermarkRepository.findByEntityType(entityType)
                .map(SyncWatermark::getLastSuccessTime)
                .orElse(LocalDateTime.now());
    }

    /**
     * 更新水位（成功后调用）
     *
     * @param entityType 类型
     * @param newTime    新水位时间（通常是 now()）
     * @param count      本次同步条数
     * @param remark     可选备注
     */
    @Transactional("baseTransactionManager")
    public void updateWatermark(String entityType, LocalDateTime newTime, long count, String remark) {
        SyncWatermark watermark = watermarkRepository.findByEntityType(entityType)
                .orElse(new SyncWatermark(entityType, newTime));

        watermark.setLastSuccessTime(newTime);
        watermark.setLastSyncCount(count);
        watermark.setRemark(remark);
        watermark.setUpdatedAt(LocalDateTime.now());

        watermarkRepository.save(watermark);
    }
}