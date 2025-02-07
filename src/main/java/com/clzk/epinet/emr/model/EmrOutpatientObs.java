package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import lombok.EqualsAndHashCode;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * 门（急）诊留观记录信息 - 记录患者的急诊留观情况
 */
@Entity
@Table(name = "emr_outpatient_observation")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmrOutpatientObs extends BaseEntity {
    
    private String patientId; // 患者 ID
    private String serialNumber; // 就诊流水号
    private String patientName; // 患者姓名
    private String idCardTypeCode; // 身份证件类别代码
    private String idCardTypeName; // 身份证件类别名称
    private String idCard; // 身份证件号码
    private String allergyHisFlag; // 过敏史标志
    private String allergyHis; // 过敏史描述
    private String outpatientDate; // 就诊日期时间
    private String initalDiagnosisCode; // 初步诊断代码
    private String chiefComplaint; // 主诉
    private String presentIllnessHis; // 现病史
    private String pastIllnessHis; // 既往史
    private String physicalExamination; // 体格检查
    private String observationResult; // 中医“四诊”观察结果
    private String studiesSummaryResult; // 辅助检查
    private String wmDiagnosisCode; // 初步诊断-西医诊断代码
    private String wmDiagnosisName; // 初步诊断-西医诊断名称
    private String tcmInitalDiagnosisCode; // 初步诊断-中医病名代码
    private String tcmInitalDiagnosisName; // 初步诊断-中医病名名称
    private String tcmInitalSyndromeCode; // 初步诊断-中医证候代码
    private String tcmInitalSyndromeName; // 初步诊断-中医证候名称
    private String differentiationBasis; // 辨证依据
    private String treatment; // 治则治法
    private String course; // 急诊留观病程记录
    private String observationDate; // 收入观察室日期时间
    private String notes; // 注意事项
    private String orgCode; // 医疗机构代码
    private String orgName; // 医疗机构名称
    private String deptCode; // 科室代码
    private String deptName; // 科室名称
    private String operatorId; // 操作人 ID
    private String operationTime; // 操作时间
}
