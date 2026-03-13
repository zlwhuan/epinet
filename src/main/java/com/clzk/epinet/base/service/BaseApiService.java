package com.clzk.epinet.base.service;

import com.clzk.epinet.base.dto.ApiResponse;
import com.clzk.epinet.base.repository.EmrDicRepository;
import com.clzk.epinet.base.util.FieldConvertUtil;
import com.clzk.epinet.base.util.HttpClient;
import com.clzk.epinet.config.EmrApiConfig;
import com.clzk.epinet.emr.model.*;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class BaseApiService {

    // 静态初始化 Map，减少运行时的动态配置
    private static final Map<Class<?>, String> apiUrls = new HashMap<>();

    @Autowired
    private HttpClient httpClient;

    @Autowired
    private EmrApiConfig emrApiConfig;

    @Autowired
    private EmrDicRepository emrDicRepository;

    @PostConstruct
    public void init() {

        // 静态初始化绑定类类型和 URL
        apiUrls.put(EmrPatientInfo.class, emrApiConfig.getBaseUrl() + "/hclient/emr/receive/emrPatientInfo");
        apiUrls.put(EmrActivityInfo.class, emrApiConfig.getBaseUrl() + "/hclient/emr/receive/emrActivityInfo");
        apiUrls.put(EmrInfReport.class, emrApiConfig.getBaseUrl() + "/hclient/emr/receive/emrInfReport");
        apiUrls.put(EmrOutpatientRecord.class, emrApiConfig.getBaseUrl() + "/hclient/emr/receive/emrOutpatientRecord");
        apiUrls.put(EmrOutpatientObs.class, emrApiConfig.getBaseUrl() + "/hclient/emr/receive/emrOutpatientObs");
        apiUrls.put(EmrAdmissionInfo.class, emrApiConfig.getBaseUrl() + "/hclient/emr/receive/emrAdmissionInfo");
        apiUrls.put(EmrFirstCourse.class, emrApiConfig.getBaseUrl() + "/hclient/emr/receive/emrFirstCourse");
        apiUrls.put(EmrDailyCourse.class, emrApiConfig.getBaseUrl() + "/hclient/emr/receive/emrDailyCourse");
        apiUrls.put(EmrAdmissionRecord.class, emrApiConfig.getBaseUrl() + "/hclient/emr/receive/emrAdmissionRecord");
        apiUrls.put(EmrDischargeInfo.class, emrApiConfig.getBaseUrl() + "/hclient/emr/receive/emrDischargeInfo");
        apiUrls.put(EmrExClinical.class, emrApiConfig.getBaseUrl() + "/hclient/emr/receive/emrExClinical");
        apiUrls.put(EmrExClinicalItem.class, emrApiConfig.getBaseUrl() + "/hclient/emr/receive/emrExClinicalItem");
        apiUrls.put(EmrExLab.class, emrApiConfig.getBaseUrl() + "/hclient/emr/receive/emrExLab");
        apiUrls.put(EmrExLabItem.class, emrApiConfig.getBaseUrl() + "/hclient/emr/receive/emrExLabItem");
        apiUrls.put(EmrOrder.class, emrApiConfig.getBaseUrl() + "/hclient/emr/receive/emrOrder");
        apiUrls.put(EmrOrderItem.class, emrApiConfig.getBaseUrl() + "/hclient/emr/receive/emrOrderItem");
        apiUrls.put(EmrDeathInfo.class, emrApiConfig.getBaseUrl() + "/hclient/emr/receive/emrDeathInfo");
        apiUrls.put(EmrVitalSignsRecord.class, emrApiConfig.getBaseUrl() + "/hclient/emr/receive/emrVitalSignsRecord");
        apiUrls.put(BaseUser.class, emrApiConfig.getBaseUrl() + "/hclient/emr/receive/baseUser");
        apiUrls.put(BaseDept.class, emrApiConfig.getBaseUrl() + "/hclient/emr/receive/baseDept");
    }

    // 获取 API URL
    public String getApiUrl(Class<?> clazz) {
        return apiUrls.get(clazz);
    }

    public void syncSingleObject(Object entity) {
        if (entity == null) return;

        String url = getApiUrl(entity.getClass());
        if (url == null) {
            throw new IllegalArgumentException("No API URL for " + entity.getClass().getSimpleName());
        }

        Object converted = FieldConvertUtil.convert(entity);
        // orgCode 过滤（可以抽成 Filter 或 Predicate 后续优化）
        boolean shouldSyncByOrgCode = shouldSyncByOrgCode(converted);
        if (!shouldSyncByOrgCode) {
            return;
        }

        ApiResponse resp = httpClient.post(url, converted);

        if (!resp.getResult()) {
            throw new RuntimeException("同步失败: " + resp.getDesc());
        }
    }

    private boolean shouldSyncByOrgCode(Object entity) {
        if (entity == null) {
            return false;  // 防御：实体为空不应该同步
        }

        try {
            Field field = entity.getClass().getDeclaredField("orgCode");
            if (field.getType() != String.class) {
                log.warn("orgCode 字段不是 String 类型: {}", entity.getClass().getName());
                return true;  // 非 String 字段，默认允许（或按需抛异常）
            }

            field.setAccessible(true);
            String orgCode = (String) field.get(entity);
            // 核心判断：有字段且值非空 → true；有字段但值为空 → false
            return StringUtils.hasText(orgCode);  // 推荐用 Spring 的 hasText（null、空串、纯空白都算 false）
            // 或者用 Java 原生： return orgCode != null && !orgCode.isBlank();
        } catch (NoSuchFieldException e) {
            log.error(e.getMessage());
            // 没有 orgCode 字段 → 默认允许同步
            return true;
        } catch (IllegalAccessException e) {
            log.error("无法访问 orgCode 字段: {}", entity.getClass().getName(), e);
            return true;  // 或 false，看业务容忍度
        } catch (Exception e) {
            log.error("检查 orgCode 异常: {}", entity.getClass().getName(), e);
            return true;  // 兜底默认允许
        }
    }
}
