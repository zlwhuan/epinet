package com.clzk.epinet.base.sync;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "sync")
public class SyncProperties {

    /**
     * 每种数据类型的同步频率（cron表达式）
     * key: 实体类简单名，例如 EmrPatientInfo
     * value: cron 表达式，例如 "0 *\/5 * * * ?" （每5分钟）
     */

    private Map<String, String> frequencies = new HashMap<>();

    /**
     * 默认频率（当配置文件未指定时使用）
     */
    private String defaultFrequency = "0 */5 * * * ?";  // 每5分钟

    public Map<String, String> getFrequencies() {
        return frequencies;
    }

    public void setFrequencies(Map<String, String> frequencies) {
        this.frequencies = frequencies;
    }

    public String getDefaultFrequency() {
        return defaultFrequency;
    }

    public void setDefaultFrequency(String defaultFrequency) {
        this.defaultFrequency = defaultFrequency;
    }

    /**
     * 获取某个类型的实际 cron 表达式
     */
    public String getFrequencyFor(String typeName) {
        return frequencies.getOrDefault(typeName, defaultFrequency);
    }
}