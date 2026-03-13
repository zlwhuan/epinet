package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

/**
 * 诊疗活动信息 - 记录患者的诊疗活动信息
 */
@Entity
@Table(name = "EMR_ACTIVITY_INFO")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmrActivityInfo extends BaseEntity {

    @Id
    @Column(name = "ID", length = 80)
    private String id;

    @Column(name = "PATIENT_ID", length = 80)
    private String patientId; // 患者基本信息 ID
    @Column(name = "ACTIVITY_TYPE_CODE", length = 2)
    private String activityTypeCode; // 诊疗活动类型代码
    @Column(name = "ACTIVITY_TYPE_NAME", length = 20)
    private String activityTypeName; // 诊疗活动类型名称
    @Column(name = "SERIAL_NUMBER", length = 20)
    private String serialNumber; // 就诊流水号
    @Column(name = "ACTIVITY_TIME", length = 20)
    private String activityTime; // 诊疗活动发生日期时间
    @Column(name = "PATIENT_NAME", length = 100)
    private String patientName; // 患者姓名
    @Column(name = "ID_CARD_TYPE_CODE", length = 2)
    private String idCardTypeCode; // 身份证件类别代码
    @Column(name = "ID_CARD_TYPE_NAME", length = 20)
    private String idCardTypeName; // 身份证件类别名称
    @Column(name = "ID_CARD", length = 50)
    private String idCard; // 身份证件号码
    @Lob
    @Column(name = "CHIEF_COMPLAINT")
    private String chiefComplaint; // 主诉
    @Lob
    @Column(name = "PRESENT_ILLNESS_HIS")
    private String presentIllnessHis; // 现病史/入院情况
    @Lob
    @Column(name = "PHYSICAL_EXAMINATION")
    private String physicalExamination; // 体格检查
    @Lob
    @Column(name = "STUDIES_SUMMARY_RESULT")
    private String studiesSummaryResult; // 辅助检查
    @Column(name = "DIAGNOSE_TIME", length = 20)
    private String diagnoseTime; // 诊断时间
    @Column(name = "DISEASE_CODE", length = 50)
    private String diseaseCode;    // 疾病代码
    @Column(name = "DISEASE_NAME", length = 250)
    private String diseaseName; // 疾病名称
    @Column(name = "WM_DISEASE_CODE", length = 400)
    private String wmDiseaseCode; // 西医疾病诊断编码
    @Column(name = "WM_DISEASE_NAME", length = 400)
    private String wmDiseaseName; // 西医疾病诊断名称

    @Column(name = "TCM_DISEASE_CODE", length = 250)
    private String tcmDiseaseCode; // 中医病名代码
    @Column(name = "TCM_DISEASE_NAME", length = 250)
    private String tcmDiseaseName; // 中医病名名称
    @Column(name = "TCM_SYNDROME_CODE", length = 250)
    private String tcmSyndromeCode; // 中医证候编码
    @Column(name = "TCM_SYNDROME_NAME", length = 250)
    private String tcmSyndromeName; // 中医证候名称
    @Column(name = "FILL_DOCTOR", length = 20)
    private String fillDoctor; // 诊断医生
    @Column(name = "DEPT_CODE", length = 20)
    private String deptCode; // 科室代码
    @Column(name = "DEPT_NAME", length = 50)
    private String deptName; // 科室名称
    @Column(name = "ORG_CODE", length = 9)
    private String orgCode; // 医疗机构代码
    @Column(name = "ORG_NAME", length = 100)
    private String orgName; // 医疗机构名称
    @Column(name = "OPERATOR_ID", length = 40)
    private String operatorId; // 操作人 ID
    @Column(name = "OPERATION_TIME", length = 50)
    private Timestamp operationTime; // 操作时间

//    @Transient
////    @ManyToOne
////    @JoinColumn(name = "patientId", referencedColumnName = "id", insertable = false, updatable = false)
//    private EmrPatientInfo patientInfo; // 患者基本信息
}
