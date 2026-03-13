package com.clzk.epinet.base.initialize;

import com.clzk.epinet.base.constant.CodeTypeEnum;
import com.clzk.epinet.base.model.EmrDic;
import com.clzk.epinet.base.repository.EmrDicRepository;
import com.clzk.epinet.base.util.FieldConvertUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@Slf4j
public class DictionaryInitializer {

    @Autowired
    private EmrDicRepository emrDicRepository;

    @EventListener(ApplicationReadyEvent.class)
    @Order(1)  // 优先级高，先于其他业务初始化
    public void onApplicationReady() {
        loadDictionaries();
    }

    // 或者用 @PostConstruct，如果不依赖其他 bean 就绪
    private void loadDictionaries() {
        try {
            FieldConvertUtil.dicMap.clear();

            Map<String, Map<String, EmrDic>> categoryMap = emrDicRepository.findAll().stream()
                    .collect(Collectors.groupingBy(
                            EmrDic::getCategoryCode,
                            Collectors.toMap(EmrDic::getCode, Function.identity())
                    ));

            int totalCategories = 0;
            for (CodeTypeEnum type : CodeTypeEnum.values()) {
                Map<String, EmrDic> map = categoryMap.get(type.getCode());
                if (map != null && !map.isEmpty()) {
                    FieldConvertUtil.dicMap.put(type.getFieldName(), map);
                    totalCategories++;
                }
            }

            log.info("字典加载完成：加载了 {} 个类别，总码值 {} 条",
                    totalCategories, FieldConvertUtil.dicMap.values().stream().mapToInt(Map::size).sum());
        } catch (Exception e) {
            log.error("字典初始化失败！后续字段转换可能出错", e);
            // 根据需求：可以抛异常让启动失败，或继续运行（降级）
        }
    }

    public Map<String, Integer> refreshDictionaries() {
        int beforeCategories = FieldConvertUtil.dicMap.size();
        int beforeTotal = FieldConvertUtil.dicMap.values().stream().mapToInt(Map::size).sum();

        loadDictionaries();  // 复用加载逻辑

        int afterCategories = FieldConvertUtil.dicMap.size();
        int afterTotal = FieldConvertUtil.dicMap.values().stream().mapToInt(Map::size).sum();

        Map<String, Integer> result = new LinkedHashMap<>();
        result.put("beforeCategories", beforeCategories);
        result.put("afterCategories", afterCategories);
        result.put("beforeTotalItems", beforeTotal);
        result.put("afterTotalItems", afterTotal);
        result.put("changed", afterTotal - beforeTotal);

        log.info("手动刷新字典完成：类别 {} → {}，总码值 {} → {} (变化 {})",
                beforeCategories, afterCategories, beforeTotal, afterTotal, afterTotal - beforeTotal);

        return result;
    }
}