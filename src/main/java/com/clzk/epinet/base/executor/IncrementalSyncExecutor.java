package com.clzk.epinet.base.executor;

import com.clzk.epinet.base.dto.SyncResult;
import com.clzk.epinet.base.model.EmrDic;
import com.clzk.epinet.base.service.BaseApiService;
import com.clzk.epinet.base.service.QueryService;
import com.clzk.epinet.base.service.SyncWatermarkService;
import com.clzk.epinet.emr.model.BaseDept;
import com.clzk.epinet.emr.model.EmrActivityInfo;
import com.clzk.epinet.emr.model.EmrPatientInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Slf4j
public class IncrementalSyncExecutor {

    @Autowired
    private QueryService queryService;
    @Autowired
    private SyncWatermarkService watermarkService;  // 新注入

    @Autowired
    private BaseApiService apiService;
    private final Map<Long, Boolean> patientExistenceCache = new ConcurrentHashMap<>();

    // 可以注入一个依赖关系管理器（后面讲第二步优化）

    @Transactional("baseTransactionManager")
    public <T> SyncResult syncIncremental(Class<T> entityType) {
        String typeName = entityType.getSimpleName();
        LocalDateTime lastWatermark = watermarkService.getLastSyncTime(typeName);
        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime since = lastWatermark.minusHours(10); // 或从配置读取
        LocalDateTime since = lastWatermark; // 或从配置读取

        List<T> increments = queryService.queryViewIncremental(entityType, since);
        if (CollectionUtils.isEmpty(increments)) {
            watermarkService.updateWatermark(typeName, now, 0, "无增量");
            return SyncResult.noData();
        }

        int success = 0;
        int total = increments.size();

        for (T item : increments) {
            try {
                handleDependenciesIfNeeded(item);   // 关键：处理前置依赖
                apiService.syncSingleObject(item);
                success++;
            } catch (Exception e) {
                log.error("同步失败 {} id={}: {}", typeName, getId(item), e.getMessage());
                // 可记录失败项，后续加重试机制
            }
        }

        if (success == total) {
            watermarkService.updateWatermark(typeName, now, success, success + "/" + total);
            return SyncResult.success(success, total);
        } else {
            // 部分失败不推进水位
            watermarkService.updateWatermark(typeName, lastWatermark, 0, "部分失败: " + success + "/" + total);
            return SyncResult.partial(success, total);
        }
    }

    private void handleDependenciesIfNeeded(Object item) {
        if (item instanceof EmrActivityInfo activity) {
            String patientIdStr = activity.getPatientId();
            if (patientIdStr == null) return;

            Long patientId = Long.valueOf(patientIdStr);
            if (Boolean.TRUE.equals(patientExistenceCache.get(patientId))) {
                return;
            }

            EmrPatientInfo patient = queryService.findPatientById(patientIdStr);
            if (patient != null) {
                apiService.syncSingleObject(patient);
                patientExistenceCache.put(patientId, true);
            }
        }
        // 后续其他依赖类型在这里扩展（或抽策略模式）
    }

    // 工具方法：获取实体ID（根据实际情况实现）
    private String getId(Object entity) {
        if (entity instanceof EmrActivityInfo activity) {
            return activity.getId() != null ? activity.getId() : "null";
        } else if (entity instanceof EmrPatientInfo patient) {
            return patient.getId() != null ? patient.getId() : "null";
        }
        // 其他类型的ID获取逻辑
        return "unknown";
    }

    @Transactional("baseTransactionManager")
    public <T> SyncResult syncIncrementalManual(Class<T> entityType, List<T> increments) {
        String typeName = entityType.getSimpleName();

        if (CollectionUtils.isEmpty(increments)) {
            return SyncResult.noData();
        }

        int success = 0;
        int total = increments.size();

        for (T item : increments) {
            try {
                handleDependenciesIfNeeded(item);   // 关键：处理前置依赖
                apiService.syncSingleObject(item);
                success++;
            } catch (Exception e) {
                log.error("同步失败 {} id={}: {}", typeName, getId(item), e.getMessage());
                // 可记录失败项，后续加重试机制
            }
        }

        if (success == total) {
            return SyncResult.success(success, total);
        } else {
            // 部分失败不推进水位
            return SyncResult.partial(success, total);
        }
    }

}