package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

/**
 * 入院记录信息 - 记录患者的入院基本信息
 */
@Entity
@Table(name = "emr_admission_info")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmrAdmissionInfo extends BaseEntity {

    @Id
    @Column(name = "id", length = 80)
    private String id;

    @Column(name = "patient_id", length = 80)
    private String patientId; // 患者 ID
    @Column(name = "serial_number", length = 20)
    private String serialNumber; // 住院号
    @Column(name = "ward_name", length = 50)
    private String wardName; // 病区名称
    @Column(name = "ward_no", length = 10)
    private String wardNo; // 入院病房编号
    private String bedNo; // 病床号
    @Column(name = "patient_name", length = 100)
    private String patientName; // 患者姓名
    @Column(name = "id_card_type_code", length = 2)
    private String idCardTypeCode; // 身份证件类别代码
    @Column(name = "id_card_type_name", length = 20)
    private String idCardTypeName; // 身份证件类别名称
    @Column(name = "id_card", length = 50)
    private String idCard; // 身份证件号码
    private Timestamp admissionDate; // 入院日期时间
    @Lob
    @Column(name = "chief_complaint")
    private String chiefComplaint; // 主诉
    @Lob
    @Column(name = "present_illness_his")
    private String presentIllnessHis; // 现病史
    private String healthStatusCode; // 一般健康状况标志
    @Lob
    @Column(name = "past_illness_his")
    private String pastIllnessHis; // 疾病史(含外伤）
    private String infectionCode; // 患者传染性标志
    @Lob
    @Column(name = "infection_his")
    private String infectionHis; // 传染病史
    @Lob
    @Column(name = "vaccination_his")
    private String vaccinationHis; // 预防接种史
    @Lob
    @Column(name = "operation_his")
    private String operationHis; // 手术史
    @Lob
    @Column(name = "blood_transfusion")
    private String bloodTransfusion; // 输血史
    @Lob
    @Column(name = "allergy_his")
    private String allergyHis; // 过敏史
    @Lob
    @Column(name = "personal_his")
    private String personalHis; // 个人史
    @Lob
    @Column(name = "marital_his")
    private String maritalHis; // 婚姻史
    @Lob
    @Column(name = "menstrual_his")
    private String menstrualHis; // 月经史
    @Lob
    @Column(name = "family_his")
    private String familyHis; // 家族史
    @Lob
    @Column(name = "physical_examination")
    private String physicalExamination; // 体格检查
    @Lob
    @Column(name = "specialized_examination")
    private String specializedExamination; // 专科情况
    @Lob
    @Column(name = "studies_summary_result")
    private String studiesSummaryResult; // 辅助检查
    @Lob
    @Column(name = "observation_result")
    private String observationResult; // 中医“四诊”观察结果
    @Column(name = "treatment", length = 100)
    private String treatment; // 治则治法
    @Column(name = "wm_inital_diagnosis_code", length = 400)
    private String wmInitalDiagnosisCode; // 初步诊断-西医诊断编码
    @Column(name = "wm_inital_diagnosis_name", length = 400)
    private String wmInitalDiagnosisName; // 初步诊断-西医诊断名称
    @Column(name = "tcm_inital_diagnosis_code", length = 250)
    private String tcmInitalDiagnosisCode; // 初步诊断-中医病名代码
    @Column(name = "tcm_inital_diagnosis_name", length = 250)
    private String tcmInitalDiagnosisName; // 初步诊断-中医病名名称
    @Column(name = "tcm_inital_syndrome_code", length = 250)
    private String tcmInitalSyndromeCode; // 初步诊断-中医证候代码
    @Column(name = "tcm_inital_syndrome_name", length = 250)
    private String tcmInitalSyndromeName; // 初步诊断-中医证候名称
    private Timestamp initalDiagnosisDate; // 初步诊断日期
    @Column (name = "wm_revised_diagnosis_code", length = 400)
    private String wmRevisedDiagnosisCode; // 修正诊断-西医诊断代码
    @Column (name = "wm_revised_diagnosis_name", length = 400)
    private String wmRevisedDiagnosisName; // 修正诊断-西医诊断名称
    @Column (name = "tcm_revised_diagnosis_code", length = 250)
    private String tcmRevisedDiagnosisCode; // 修正诊断-中医病名代码
    @Column (name = "tcm_revised_diagnosis_name", length = 250)
    private String tcmRevisedDiagnosisName; // 修正诊断-中医病名名称
    @Column (name = "tcm_revised_syndrome_code", length = 250)
    private String tcmRevisedSyndromeCode; // 修正诊断-中医证候代码
    @Column (name = "tcm_revised_syndrome_name", length = 250)
    private String tcmRevisedSyndromeName; // 修正诊断-中医证候名称
    private Timestamp revisedDiagnosisDate; // 修正诊断日期
    @Column (name = "wm_confirmed_diagnosis_code", length = 400)
    private String wmConfirmedDiagnosisCode; // 确定诊断-西医诊断代码
    @Column (name = "wm_confirmed_diagnosis_name", length = 400)
    private String wmConfirmedDiagnosisName; // 确定诊断-西医诊断名称
    @Column (name = "tcm_confirmed_diagnosis_code", length = 250)
    private String tcmConfirmedDiagnosisCode; // 确定诊断-中医病名代码
    @Column (name = "tcm_confirmed_diagnosis_name", length = 250)
    private String tcmConfirmedDiagnosisName; // 确定诊断-中 医病名名称
    @Column (name = "tcm_confirmed_syndrome_code", length = 250)
    private String tcmConfirmedSyndromeCode; // 确定诊断-中医证候代码
    @Column (name = "tcm_confirmed_syndrome_name", length = 250)
    private String tcmConfirmedSyndromeName; // 确定诊断-中医证候名称
    private Timestamp confirmedDiagnosisDate; // 确定诊断日期
    @Column (name = "complementary_diagnosis_code", length = 50)
    private String complementaryDiagnosisCode; // 补充诊断编码
    @Column (name = "complementary_diagnosis_name", length = 250)
    private String complementaryDiagnosisName; // 补充诊断名称

    private Timestamp complementaryDiagnosisDate; // 补充诊断日期
    @Column (name = "admission_diagnosis_order", length = 2)
    private String admissionDiagnosisOrder; // 入院诊断顺位
    @Column (name = "visiting_physician_id", length = 50)
    private String visitingPhysicianId; // 接诊医师
    @Column (name = "resident_physician_id", length = 50)
    private String residentPhysicianId; // 住院医师
    @Column (name = "chief_physician_id", length = 50)
    private String chiefPhysicianId; // 主治医师
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
