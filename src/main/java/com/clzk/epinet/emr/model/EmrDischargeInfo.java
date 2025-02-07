package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import lombok.EqualsAndHashCode;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * 出院记录信息 - 记录患者的出院情况
 */
@Entity
@Table(name = "emr_discharge_info")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmrDischargeInfo extends BaseEntity {

    private Long patientId; // 患者 ID
    private String serialNumber; // 住院号
    private String patientName; // 患者姓名
    private String idCardTypeCode; // 身份证件类别代码
    private String idCardTypeName; // 身份证件类别名称
    private String idCard; // 身份证件号码
    private String wardName; // 病区名称
    private String wardNo; // 病房号
    private String bedNo; // 病床号
    private String admissionDate; // 入院日期时间
    private String admissionDesc; // 入院描述
    private String admissionDiagnosisCode; // 入院诊断代码
    private String admissionDiagnosisName; // 入院诊断名称
    private String studiesSummaryResult; // 辅助检查
    private String observationResult; // 观察结果
    private String treatment; // 住院治疗
    private String treatmentDesc; // 治疗描述
    private String tcmDecoctionMethod; // 中药煎煮法
    private String tcmUseMethod; // 中药用药方法
    private String dischargeDesc; // 出院描述
    private String dischargeDate; // 出院日期时间
    private String dischargeDiagnosisCode; // 出院诊断代码
    private String dischargeDiagnosisName; // 出院诊断名称
    private String tcmDischargeDiagnosisCode; // 出院诊断-中医病名代码
    private String tcmDischargeDiagnosisCame; // 出院诊断-中医病名名称
    private String tcmDischargeSyndromeCode; // 出院诊断-中医证候代码
    private String tcmDischargeSyndromeCame; // 出院诊断-中医证候名称
    private String dischargeSymptomsSigns; // 出院时症状与体征
    private String dischargeOrder; // 出院医嘱
    private String diseaseProgressionCode; // 病情转归代码
    private String diseaseProgressionCame; // 病情转归名称
    private String residentPhysicianId; // 住院医师
    private String chiefPhysicianId; // 主治医师
    private String orgCode; // 医疗机构代码
    private String orgName; // 医疗机构名称
    private String deptCode; // 科室代码
    private String deptName; // 科室名称
    private String operatorId; // 操作人 ID
    private String operationTime; // 操作时间
}
