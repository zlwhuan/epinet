package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 住院首次病程记录信息 - 记录患者的住院首次病程信息
 */
@Entity
@Table(name = "emr_first_course")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmrFirstCourse extends BaseEntity {

    private String patientId; // 患者 ID
    private String serialNumber; // 住院号
    private String patientName; // 患者姓名
    private String idCardTypeCode; // 身份证件类别代码
    private String idCardTypeName; // 身份证件类别名称
    private String idCard; // 身份证件号码
    private String wardName; // 病区名称
    private String wardNo; // 病房号
    private String bedNo; // 病床号
    private String createTime; // 记录创建时间
    private String chiefComplaint; // 主诉
    private String presentIllnessHis; // 病例特点
    private String observationResult; // 中医“四诊”观察结果
    private String diagnosisBasis; // 诊断依据
    private String wmInitalDiagnosisCode; // 初步诊断-西医诊断编码
    private String wmInitalDiagnosisName; // 初步诊断-西医诊断名称
    private String tcmInitalDiagnosisCode; // 初步诊断-中医病名代码
    private String tcmInitalDiagnosisName; // 初步诊断-中医病名名称
    private String tcmInitalSyndromeCode; // 初步诊断-中医证候代码
    private String tcmInitalSyndromeName; // 初步诊断-中医证候名称
    private String wmDiffDiagnosisCode; // 鉴别诊断-西医诊断代码
    private String wmDiffDiagnosisName; // 鉴别诊断-西医诊断名称
    private String tcmPrimaryDiagnosisCode; // 鉴别诊断-中医病名代码
    private String tcmPrimaryDiagnosisName; // 鉴别诊断-中医病名名称
    private String tcmPrimarySyndromeCode; // 鉴别诊断-中医证候代码
    private String tcmPrimarySyndromeName; // 鉴别诊断-中医证候名称
    private String treatment; // 治则治法
    private String treatmentPlan; // 诊疗计划
    private String diseaseProgressionCode; // 病情转归代码
    private String diseaseProgressionName; // 病情转归名称
    private String residentPhysicianId; // 住院医师
    private String orgCode; // 医疗机构代码
    private String orgName; // 医疗机构名称
    private String deptCode; // 科室代码
    private String deptName; // 科室名称
    private String operatorId; // 操作人 ID
    private String operationTime; // 操作时间
}
