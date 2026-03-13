package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

/**
 * 住院日常病程记录信息 - 记录患者的住院日常病程情况
 */
@Entity
@Table(name = "emr_daily_course")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmrDailyCourse extends BaseEntity {

    @Id
    @Column(name = "id", length = 80)
    private String id;
    
    @Column(name = "patient_id", length = 80)
    private String patientId; // 患者 ID
    @Column(name = "serial_number", length = 20)
    private String serialNumber; // 住院号
    @Column(name = "patient_name", length = 100)
    private String patientName; // 患者姓名
    @Column(name = "id_card_type_code", length = 2)
    private String idCardTypeCode; // 身份证件类别代码
    @Column(name = "id_card_type_name", length = 20)
    private String idCardTypeName; // 身份证件类别名称
    @Column(name = "id_card", length = 50)
    private String idCard; // 身份证件号码
    @Column(name = "ward_name", length = 50)
    private String wardName; // 病区名称
    @Column(name = "ward_no", length = 10)
    private String wardNo; // 病房号
    private String bedNo; // 病床号
    private String createTime; // 记录日期时间
    @Lob
    @Column(name = "course")
    private String course; // 住院病程
    private String orderContent; // 医嘱内容
    @Lob
    @Column(name = "observation_result")
    private String observationResult; // 中医“四诊”观察结果
    @Column(name = "treatment", length = 100)
    private String treatment; // 辨证论治详细描述
    @Column(name = "disease_progression_code", length = 1)
    private String diseaseProgressionCode; // 病情转归代码
    @Column(name = "disease_progression_name", length = 50)
    private String diseaseProgressionName; // 病情转归名称
    @Column(name = "org_code", length = 9)
    private String orgCode; // 医疗机构代码
    @Column(name = "org_name", length = 100)
    private String orgName; // 医疗机构名称
    @Column(name = "dept_code", length = 20)
    private String deptCode; // 科室代码
    @Column(name = "dept_name", length = 50)
    private String deptName; // 科室名称
    @Column(name = "operator_id", length = 40)
    private String operatorId; // 操作人 ID
    private Timestamp operationTime; // 操作时间
}
