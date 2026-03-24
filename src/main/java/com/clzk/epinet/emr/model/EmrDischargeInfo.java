package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

/**
 * 出院记录信息 - 记录患者的出院情况
 */
@Entity
@Table(name = "EMR_DISCHARGE_INFO")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmrDischargeInfo extends BaseEntity {

    @Id
    @Column(name = "ID", length = 80, nullable = false)
    private String id;

    @Column(name = "PATIENT_ID", length = 80, nullable = false)
    private String patientId; // 患者 ID

    @Column(name = "SERIAL_NUMBER", length = 20, nullable = false)
    private String serialNumber; // 住院号

    @Column(name = "PATIENT_NAME", length = 100, nullable = false)
    private String patientName; // 患者姓名

    @Column(name = "ID_CARD_TYPE_CODE", length = 2)
    private String idCardTypeCode; // 身份证件类别代码

    @Column(name = "ID_CARD_TYPE_NAME", length = 20)
    private String idCardTypeName; // 身份证件类别名称

    @Column(name = "ID_CARD", length = 50)
    private String idCard; // 身份证件号码

    @Column(name = "WARD_NAME", length = 50)
    private String wardName; // 病区名称

    @Column(name = "WARD_NO", length = 10)
    private String wardNo; // 病房号

    @Column(name = "BED_NO", length = 10)
    private String bedNo; // 病床号

    @Column(name = "ADMISSION_DATE")
    private Timestamp admissionDate; // 入院日期时间

    @Column(name = "ADMISSION_DESC", length = 200)
    private String admissionDesc; // 入院描述

    @Column(name = "ADMISSION_DIAGNOSIS_CODE", length = 50)
    private String admissionDiagnosisCode; // 入院诊断代码

    @Column(name = "ADMISSION_DIAGNOSIS_NAME", length = 200)
    private String admissionDiagnosisName; // 入院诊断名称

    @Lob
    @Column(name = "STUDIES_SUMMARY_RESULT")
    private String studiesSummaryResult; // 辅助检查

    @Lob
    @Column(name = "OBSERVATION_RESULT")
    private String observationResult; // 观察结果

    @Column(name = "TREATMENT", length = 100)
    private String treatment; // 住院治疗

    @Lob
    @Column(name = "TREATMENT_DESC")
    private String treatmentDesc; // 治疗描述

    @Column(name = "TCM_DECOCTION_METHOD", length = 50)
    private String tcmDecoctionMethod; // 中药煎煮法

    @Column(name = "TCM_USE_METHOD", length = 50)
    private String tcmUseMethod; // 中药用药方法

    @Lob
    @Column(name = "DISCHARGE_DESC")
    private String dischargeDesc; // 出院描述

    @Column(name = "DISCHARGE_DATE")
    private Timestamp dischargeDate; // 出院日期时间

    @Column(name = "DISCHARGE_DIAGNOSIS_CODE", length = 50)
    private String dischargeDiagnosisCode; // 出院诊断代码

    @Column(name = "DISCHARGE_DIAGNOSIS_NAME", length = 200)
    private String dischargeDiagnosisName; // 出院诊断名称

    @Column(name = "TCM_DISCHARGE_DIAGNOSIS_CODE", length = 250)
    private String tcmDischargeDiagnosisCode; // 出院诊断-中医病名代码

    @Column(name = "TCM_DISCHARGE_DIAGNOSIS_NAME", length = 250)
    private String tcmDischargeDiagnosisName; // 出院诊断-中医病名名称

    @Column(name = "TCM_DISCHARGE_SYNDROME_CODE", length = 250)
    private String tcmDischargeSyndromeCode; // 出院诊断-中医证候代码

    @Column(name = "TCM_DISCHARGE_SYNDROME_NAME", length = 250)
    private String tcmDischargeSyndromeName; // 出院诊断-中医证候名称

    @Lob
    @Column(name = "DISCHARGE_SYMPTOMS_SIGNS")
    private String dischargeSymptomsSigns; // 出院时症状与体征

    @Column(name = "DISCHARGE_ORDER", length = 2)
    private String dischargeOrder; // 出院医嘱

    @Column(name = "DISEASE_PROGRESSION_CODE", length = 2)
    private String diseaseProgressionCode; // 病情转归代码

    @Column(name = "DISEASE_PROGRESSION_NAME", length = 50)
    private String diseaseProgressionName; // 病情转归名称

    @Column(name = "RESIDENT_PHYSICIAN_ID", length = 50)
    private String residentPhysicianId; // 住院医师

    @Column(name = "CHIEF_PHYSICIAN_ID", length = 50)
    private String chiefPhysicianId; // 主治医师

    @Column(name = "ORG_CODE", length = 9)
    private String orgCode; // 医疗机构代码

    @Column(name = "ORG_NAME", length = 100)
    private String orgName; // 医疗机构名称

    @Column(name = "DEPT_CODE", length = 20)
    private String deptCode; // 科室代码

    @Column(name = "DEPT_NAME", length = 50)
    private String deptName; // 科室名称

    @Column(name = "OPERATOR_ID", length = 40)
    private String operatorId; // 操作人 ID

    @Column(name = "OPERATION_TIME", updatable = false)
    private Timestamp operationTime; // 操作时间
}