package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import lombok.EqualsAndHashCode;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

/**
 * 诊疗活动信息 - 记录患者的诊疗活动信息
 */
@Entity
@Table(name = "emr_activity_info")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmrActivityInfo extends BaseEntity {

    private Long patientId; // 患者基本信息 ID
    private String activityTypeCode; // 诊疗活动类型代码
    private String activityTypeName; // 诊疗活动类型名称
    private String serialNumber; // 就诊流水号
    private String activityTime; // 诊疗活动发生日期时间
    private String patientName; // 患者姓名
    private String idCardTypeCode; // 身份证件类别代码
    private String idCardTypeName; // 身份证件类别名称
    private String idCard; // 身份证件号码
    private String chiefComplaint; // 主诉
    private String presentIllnessHis; // 现病史/入院情况
    private String physicalExamination; // 体格检查
    private String studiesSummaryResult; // 辅助检查
    private String diagnoseTime; // 诊断时间
    private String diseaseCode; // 疾病代码
    private String diseaseName; // 疾病名称
    private String wmDiseaseCode; // 西医疾病诊断编码
    private String wmDiseaseName; // 西医疾病诊断名称
    private String tcmDiseaseCode; // 中医病名代码
    private String tcmDiseaseName; // 中医病名名称
    private String tcmSyndromeCode; // 中医证候编码
    private String tcmSyndromeName; // 中医证候名称
    private String fillDoctor; // 诊断医生
    private String deptCode; // 科室代码
    private String deptName; // 科室名称
    private String orgCode; // 医疗机构代码
    private String orgName; // 医疗机构名称
    private String operatorId; // 操作人 ID
    private String operationTime; // 操作时间

    @Transient
//    @ManyToOne
//    @JoinColumn(name = "patientId", referencedColumnName = "id", insertable = false, updatable = false)
    private EmrPatientInfo patientInfo; // 患者基本信息
}
