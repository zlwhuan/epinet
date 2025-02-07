package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import lombok.EqualsAndHashCode;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * 住院日常病程记录信息 - 记录患者的住院日常病程情况
 */
@Entity
@Table(name = "emr_daily_course")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmrDailyCourse extends BaseEntity {
    
    private Long patientId; // 患者 ID
    private String serialNumber; // 住院号
    private String patientName; // 患者姓名
    private String idCardTypeCode; // 身份证件类别代码
    private String idCardTypeName; // 身份证件类别名称
    private String idCard; // 身份证件号码
    private String wardName; // 病区名称
    private String wardNo; // 病房号
    private String bedNo; // 病床号
    private String createTime; // 记录日期时间
    private String course; // 住院病程
    private String orderContent; // 医嘱内容
    private String observationResult; // 中医“四诊”观察结果
    private String treatment; // 辨证论治详细描述
    private String diseaseProgressionCode; // 病情转归代码
    private String diseaseProgressionName; // 病情转归名称
    private String orgCode; // 医疗机构代码
    private String orgName; // 医疗机构名称
    private String deptCode; // 科室代码
    private String deptName; // 科室名称
    private String operatorId; // 操作人 ID
    private String operationTime; // 操作时间
}
