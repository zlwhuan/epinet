package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import lombok.EqualsAndHashCode;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * 入院记录信息 - 记录患者的入院基本信息
 */
@Entity
@Table(name = "emr_admission_info")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmrAdmissionInfo extends BaseEntity {

    private Long patientId; // 患者 ID
    private String serialNumber; // 住院号
    private String wardName; // 病区名称
    private String wardNo; // 入院病房编号
    private String bedNo; // 病床号
    private String patientName; // 患者姓名
    private String idCardTypeCode; // 身份证件类别代码
    private String idCardTypeName; // 身份证件类别名称
    private String idCard; // 身份证件号码
    private String admissionDate; // 入院日期时间
    private String chiefComplaint; // 主诉
    private String presentIllnessHis; // 现病史
    private String healthStatusCode; // 一般健康状况标志
    private String pastIllnessHis; // 疾病史(含外伤）
    private String infectionCode; // 患者传染性标志
    private String infectionHis; // 传染病史
    private String vaccinationHis; // 预防接种史
    private String operationHis; // 手术史
    private String bloodTransfusion; // 输血史
    private String allergyHis; // 过敏史
    private String personalHis; // 个人史
    private String maritalHis; // 婚姻史
    private String menstrualHis; // 月经史
    private String familyHis; // 家族史
    private String physicalExamination; // 体格检查
    private String specializedExamination; // 专科情况
    private String studiesSummaryResult; // 辅助检查
    private String observationResult; // 中医“四诊”观察结果
    private String treatment; // 治则治法
    private String wmInitalDiagnosisCode; // 初步诊断-西医诊断编码
    private String wmInitalDiagnosisName; // 初步诊断-西医诊断名称
    private String tcmInitalDiagnosisCode; // 初步诊断-中医病名代码
    private String tcmInitalDiagnosisName; // 初步诊断-中医病名名称
    private String tcmInitalSyndromeCode; // 初步诊断-中医证候代码
    private String tcmInitalSyndromeName; // 初步诊断-中医证候名称
    private String initalDiagnosisDate; // 初步诊断日期
    private String wmRevisedDiagnosisCode; // 修正诊断-西医诊断代码
    private String wmRevisedDiagnosisName; // 修正诊断-西医诊断名称
    private String tcmRevisedDiagnosisCode; // 修正诊断-中医病名代码
    private String tcmRevisedDiagnosisName; // 修正诊断-中医病名名称
    private String tcmRevisedSyndromeCode; // 修正诊断-中医证候代码
    private String tcmRevisedSyndromeName; // 修正诊断-中医证候名称
    private String revisedDiagnosisDate; // 修正诊断日期
    private String wmConfirmedDiagnosisCode; // 确定诊断-西医诊断代码
    private String wmConfirmedDiagnosisName; // 确定诊断-西医诊断名称
    private String tcmConfirmedDiagnosisCode; // 确定诊断-中医病名代码
    private String tcmConfirmedDiagnosisName; // 确定诊断-中 医病名名称
    private String tcmConfirmedSyndromeCode; // 确定诊断-中医证候代码
    private String tcmConfirmedSyndromeName; // 确定诊断-中医证候名称
    private String confirmedDiagnosisDate; // 确定诊断日期
    private String complementaryDiagnosisCode; // 补充诊断编码
    private String complementaryDiagnosisName; // 补充诊断名称
    private String complementaryDiagnosisDate; // 补充诊断日期
    private String admissionDiagnosisOrder; // 入院诊断顺位
    private String visitingPhysicianId; // 接诊医师
    private String residentPhysicianId; // 住院医师
    private String chiefPhysicianId; // 主治医师
    private String orgCode; // 医疗机构代码
    private String orgName; // 医疗机构名称
    private String deptCode; // 科室代码
    private String deptName; // 科室名称
    private String operatorId; // 操作人 ID
    private String operationTime; // 操作时间
}
