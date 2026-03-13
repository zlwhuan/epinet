package com.clzk.epinet.base.util;

import com.clzk.epinet.base.model.EmrDic;
import com.clzk.epinet.emr.model.EmrExClinicalItem;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class FieldConvertUtil {

    public static final Map<String, Map<String, EmrDic>> dicMap = new HashMap<>();

    public static <T> T convert(T entity) {
        // 获取实体类的所有字段
        Field[] fields = entity.getClass().getDeclaredFields();

        for (Field field : fields) {
            // 如果字段需要字典映射，假设字段名称包含字典类型，例如 "gender", "status"
            try {
                String fieldName = field.getName();
                // 如果字段名称是deptCode， 则跳过这个字段不处理
                if (fieldName.equals("deptCode")) {
                    continue;
                }
                //examinationResultCode需要特殊处理 检验或者检查
                if (fieldName.equals("examinationResultCode")) {
                    fieldName = entity.getClass().getName().equals(EmrExClinicalItem.class.getName()) ? "examinationResultCodeClinical" : "examinationResultCodeLab";
                }
                // 特殊处理 wmDiseaseCode
                boolean isWmDiseaseCode = false;
                if (fieldName.equals("wmDiseaseCode")) {
                    isWmDiseaseCode = true;
                    // 用 fieldName 去查字典，仍然是 wmDiseaseCode
                }
                Map<String, EmrDic> detailMap = new HashMap<>();
                if (dicMap.containsKey(fieldName)) {
                    detailMap = dicMap.get(fieldName);
                    if (detailMap == null) {
                        continue;
                    }
                }
                // 设置字段可访问
                field.setAccessible(true);
                // 获取字段值
                Object fieldValue = field.get(entity);
                // 如果字段值不为空，则进行字典查询
                EmrDic dic;
                if (fieldValue == null) {
                    continue;
                }
                dic = detailMap.get(fieldValue.toString());
                if (dic == null) {
                    if (fieldName.equals("orgCode")) {
                        field.set(entity, null);
                    }
                    continue;
                }
                String mappedCode = dic.getStdCode();
                // 设置映射后的编码值
                if (isWmDiseaseCode) {
                    // wmDiseaseCode -> diseaseCode & diseaseName
                    String codeStr = fieldValue.toString();
                    String[] codes = codeStr.split("\\|\\|"); // 按 || 分割
                    for (String code : codes) {
                        EmrDic dicItem = detailMap.get(code);
                        if (dicItem != null) {
                            // 找到匹配的第一个 code 就赋值
                            setFieldIfExists(entity, "diseaseCode", dicItem.getStdCode());
                            setFieldIfExists(entity, "diseaseName", dicItem.getStdName());
                            break;
                        }
                    }
                } else {
                    // 普通映射
                    field.set(entity, mappedCode);
                    replaceNameFieldValue(entity, fieldName, dic);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        }
        return entity;
    }

    /**
     * 安全设置字段值，如果字段不存在则忽略
     */
    private static <T> void setFieldIfExists(T entity, String fieldName, Object value) {
        try {
            Field field = entity.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(entity, value);
        } catch (NoSuchFieldException | IllegalAccessException ignored) {
        }
    }

    private static <T> void replaceNameFieldValue(T entity, String fieldName, EmrDic dic) throws NoSuchFieldException, IllegalAccessException {
        try {
            //找到这个code的name字段， 比如 typeCode ， 找到 typeName
            Field nameField = entity.getClass().getDeclaredField(fieldName.replace("Code", "Name"));
            nameField.setAccessible(true);
            // 设置映射后的名称值
            nameField.set(entity, dic.getStdName());
        } catch (Exception e) {
                //如果没有找到对应的name字段，或者设置失败，忽略异常继续执行
        }
    }
}
