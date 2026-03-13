package com.clzk.epinet.base.service;

import com.clzk.epinet.emr.model.EmrPatientInfo;
import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import oracle.sql.DATE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.Level;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class QueryService {

    // 视图数据源的 EntityManager（重点！）
    @PersistenceContext(unitName = "view")     // 对应上面配置的 persistenceUnit("view")
    private EntityManager viewEntityManager;

    @Autowired
    private Environment environment;

    public <T> List<T> queryViewIncremental(Class<T> entityClass, LocalDateTime since) {
        return this.queryViewIncremental(entityClass, null, since, null);
    }

    public EmrPatientInfo findPatientById(String patientId) {
        String jpql = "SELECT p FROM EmrPatientInfo p WHERE p.id = :patientId";
        TypedQuery<EmrPatientInfo> query = viewEntityManager.createQuery(jpql, EmrPatientInfo.class);
        query.setParameter("patientId", patientId);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            log.error("未找到患者信息，patientId: {}", patientId);
            return null;
        } catch (Exception e) {
            log.error("查询患者信息失败，patientId: {}, error: {}", patientId, e.getMessage());
            return null;
        }
    }

    /**
     * 增量查询：基于 updateTime / operationTime / createTime，并可选按 orgCode 过滤
     *
     * @param entityClass 实体类（视图对应的实体）
     * @param orgCode     机构代码（可选，null 或空字符串表示不过滤，按全量查询）
     * @param start       开始时间（必填）
     * @param end         结束时间（可选，null 表示不限结束时间）
     * @return 符合条件的增量数据列表
     */
    public <T> List<T> queryViewIncremental(
            Class<T> entityClass,
            String orgCode,
            LocalDateTime start,
            LocalDateTime end
    ) {

        String timeField = null;

        if (hasField(entityClass, "updateTime")) {
            timeField = "UPDATE_TIME";
        } else if (hasField(entityClass, "operationTime")) {
            timeField = "OPERATION_TIME";
        } else if (hasField(entityClass, "createTime")) {
            timeField = "CREATE_TIME";
        }

//        if (timeField == null) {
//            throw new IllegalArgumentException("实体缺少时间字段");
//        }

        Table tableAnno = entityClass.getAnnotation(Table.class);

        if (tableAnno == null || tableAnno.name().isEmpty()) {
            throw new RuntimeException("实体类缺少@Table name");
        }

        String viewName = getDynamicTableName(tableAnno);

        StringBuilder sql = new StringBuilder();

        sql.append("SELECT * FROM ")
                .append(viewName)
                .append(" e WHERE 1=1 ");

        Map<String, Object> params = new HashMap<>();

        if (orgCode != null && !orgCode.isBlank()) {
            sql.append(" AND e.ORG_CODE = :orgCode ");
            params.put("orgCode", orgCode);
        }

//        if (start != null) {
//            sql.append(" AND e.")
//                    .append(timeField)
//                    .append(" >= :start ");
//            params.put("start", Timestamp.valueOf(start));
//        }
//
//        if (end != null) {
//            sql.append(" AND e.")
//                    .append(timeField)
//                    .append(" <= :end ");
//            params.put("end", Timestamp.valueOf(end));
//        }
        if (start != null) {
            sql.append(" AND e.").append(timeField).append(" >= TO_TIMESTAMP(:start, 'YYYY-MM-DD HH24:MI:SS') ");
            params.put("start", start.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            // 或更精确：如果有纳秒，用 'YYYY-MM-DD HH24:MI:SS.FF9'
        }

        if (end != null) {
            sql.append(" AND e.").append(timeField).append(" <= TO_TIMESTAMP(:end, 'YYYY-MM-DD HH24:MI:SS') ");
            params.put("end", end.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }

//        sql.append(" ORDER BY e.")
//                .append(timeField)
//                .append(" ASC ");

        Query query = viewEntityManager.createNativeQuery(sql.toString(), entityClass);

        params.forEach(query::setParameter);

        try {

            @SuppressWarnings("unchecked")
            List<T> result = query.getResultList();

            log.info("查询 {} 返回 {} 条数据", entityClass.getSimpleName(), result.size());

            return result;

        } catch (Exception e) {

            log.error("查询失败 SQL: {}", sql, e);

            return Collections.emptyList();
        }
    }

    // 反射检查字段（可优化为缓存）
    private boolean hasField(Class<?> clazz, String fieldName) {
        try {
            clazz.getDeclaredField(fieldName);
            return true;
        } catch (NoSuchFieldException e) {
            return false;
        }
    }

    public String getDynamicTableName(Table tableAnno) {
        String viewName;
        String configuredSchema = tableAnno.schema();

        // 根据不同的profile判断
        if (environment.acceptsProfiles(Profiles.of("dev"))) {
            // 开发环境：不使用schema
            viewName = tableAnno.name();
        } else if (environment.acceptsProfiles(Profiles.of("test"))) {
            // 测试环境：使用测试schema TODO
            viewName = "TEST_SCHEMA" + "." + tableAnno.name();
        } else if (environment.acceptsProfiles(Profiles.of("prod"))) {
            // 生产环境：使用生产schema
            viewName = "BSPHIS_BASE" + "." + tableAnno.name();
        } else {
            // 其他环境：根据注解配置
            viewName = configuredSchema.isEmpty()
                    ? tableAnno.name()
                    : configuredSchema + "." + tableAnno.name();
        }

        return viewName;
    }
}
