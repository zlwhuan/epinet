package com.clzk.epinet.sync;

import com.clzk.epinet.base.repository.BaseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DataSyncService {

    private final RestTemplate restTemplate;

    // 让 Spring 自动收集所有 Repository 并映射到 repositoryMap
    private final Map<Class<?>, BaseRepository<?>> repositoryMap;

    @Autowired
    public DataSyncService(RestTemplate restTemplate, List<BaseRepository<?>> repositories) {
        this.restTemplate = restTemplate;
        // 自动构建 repositoryMap，映射每个 Repository 到它的实体类
        this.repositoryMap = repositories.stream()
                .collect(Collectors.toMap(
                        this::getEntityType,
                        repo -> repo
                ));
    }

    /**
     * 通过反射获取 Repository 的泛型实体类型
     */
    private Class<?> getEntityType(BaseRepository<?> repository) {
        // 解析 repository 的泛型类型
        ResolvableType resolvableType = ResolvableType.forClass(repository.getClass());

        // 查找 BaseRepository<T> 的泛型参数
        ResolvableType baseRepositoryType = resolvableType.as(BaseRepository.class);

        // 获取 T 的类型
        Class<?> entityType = baseRepositoryType.getGeneric(0).resolve();

        if (entityType == null) {
            throw new IllegalArgumentException("无法解析 Repository 的泛型类型: " + repository.getClass().getName());
        }

        return entityType;
    }

    public void syncData(Class<?> entityClass, String apiUrl) {
        log.info("Starting data synchronization for {} from {}", entityClass.getSimpleName(), apiUrl);

        BaseRepository repository = repositoryMap.get(entityClass);
        if (repository == null) {
            log.error("No repository found for {}", entityClass.getSimpleName());
            return;
        }

        // 获取数据库最新的 lastUpdateTime
        LocalDateTime lastUpdateTime = repository.findLatestUpdateTime();
        String lastUpdateTimeStr = (lastUpdateTime != null) ? lastUpdateTime.toString() : "2000-01-01T00:00:00";

        log.info("Last update time for {}: {}", entityClass.getSimpleName(), lastUpdateTimeStr);

        // 调用 API 获取数据
        String url = apiUrl + "?last_update_time=" + lastUpdateTimeStr;
        List response = (List) restTemplate.getForObject(url, entityClass.arrayType());

        List dataList = response != null ? List.of(response) : List.of();

        if (!dataList.isEmpty()) {
            repository.saveAll(dataList);
            log.info("Saved {} records for {}", dataList.size(), entityClass.getSimpleName());
        } else {
            log.info("No new data for {}", entityClass.getSimpleName());
        }
    }
}
