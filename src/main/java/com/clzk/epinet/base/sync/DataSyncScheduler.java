package com.clzk.epinet.base.sync;

import com.clzk.epinet.base.dto.SyncResult;
import com.clzk.epinet.base.executor.IncrementalSyncExecutor;
import com.clzk.epinet.emr.model.BaseUser;
import com.clzk.epinet.emr.model.EmrActivityInfo;
import com.clzk.epinet.emr.model.EmrPatientInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.List;

// Assuming you have a QueryService to handle database queries
// and the entity classes are defined elsewhere

@Component
@EnableScheduling
@Slf4j
public class DataSyncScheduler {

    private final IncrementalSyncExecutor syncExecutor;
    private final SyncProperties syncProperties;
    private final TaskScheduler taskScheduler;

    @Autowired
    public DataSyncScheduler(IncrementalSyncExecutor syncExecutor,
                             SyncProperties syncProperties,
                             TaskScheduler taskScheduler) {
        this.syncExecutor = syncExecutor;
        this.syncProperties = syncProperties;
        this.taskScheduler = taskScheduler;
    }

    private final List<Class<?>> syncOrder = List.of(
//            BaseUser.class,
//            EmrPatientInfo.class,
            EmrActivityInfo.class
            // ... 其他，按依赖顺序排列
    );

    @EventListener(ApplicationReadyEvent.class)
    public void scheduleOnStartup() {
        // 为每种类型单独创建一个定时任务
        for (Class<?> type : syncOrder) {
            String typeName = type.getSimpleName();
            String cron = syncProperties.getFrequencyFor(typeName);

            // 使用 CronTrigger 调度
            taskScheduler.schedule(
                    () -> {
                        try {
                            SyncResult result = syncExecutor.syncIncremental(type);
                            log.info("同步完成 [{}] - 结果: {}", typeName, result);
                        } catch (Exception e) {
                            log.error("同步异常 [{}]: {}", typeName, e.getMessage(), e);
                        }
                    },
                    triggerContext -> new CronTrigger(cron).nextExecution(triggerContext)
            );

            log.info("已为 {} 注册定时同步任务，cron: {}", typeName, cron);
        }

        log.info("所有数据同步任务已调度完成，共 {} 种类型", syncOrder.size());
    }

    private void syncAllInOrder() {
        for (Class<?> type : syncOrder) {
            try {
                syncExecutor.syncIncremental(type);
            } catch (Exception e) {
                log.error("类型同步异常 {}: {}", type.getSimpleName(), e.getMessage());
            }
        }
    }
}

