package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

/**
 * 住院首次病程记录信息 - 记录患者的住院首次病程信息
 */
@Entity
@Table(name = "emr_first_course")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmrFirstCourse extends BaseEntity {

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
    private String createTime; // 记录创建时间
    @Lob
    @Column(name = "chief_complaint")
    private String chiefComplaint; // 主诉
    @Lob
    @Column(name = "present_illness_his")
    private String presentIllnessHis; // 病例特点
    @Lob
    @Column(name = "observation_result")
    private String observationResult; // 中医“四诊”观察结果
    private String diagnosisBasis; // 诊断依据
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
    @Column(name = "wm_diff_diagnosis_code", length = 400)
    private String wmDiffDiagnosisCode; // 鉴别诊断-西医诊断代码
    @Column(name = "wm_diff_diagnosis_name", length = 400)
    private String wmDiffDiagnosisName; // 鉴别诊断-西医诊断名称
    @Column(name = "tcm_primary_diagnosis_code", length = 250)
    private String tcmPrimaryDiagnosisCode; // 鉴别诊断-中医病名代码
    @Column(name = "tcm_primary_diagnosis_name", length = 250)
    private String tcmPrimaryDiagnosisName; // 鉴别诊断-中医病名名称
    @Column(name = "tcm_primary_syndrome_code", length = 250)
    private String tcmPrimarySyndromeCode; // 鉴别诊断-中医证候代码
    @Column(name = "tcm_primary_syndrome_name", length = 250)
    private String tcmPrimarySyndromeName; // 鉴别诊断-中医证候名称
    @Column(name = "treatment", length = 100)
    private String treatment; // 治则治法
    @Lob
    @Column(name = "treatment_plan")
    private String treatmentPlan; // 诊疗计划
    @Column(name = "disease_progression_code", length = 1)
    private String diseaseProgressionCode; // 病情转归代码
    @Column(name = "disease_progression_name", length = 50)
    private String diseaseProgressionName; // 病情转归名称
    @Column(name = "org_code", length = 9)
    private String orgCode; // 医疗机构代码
    @Column (name = "resident_physician_id", length = 50)
    private String residentPhysicianId; // 住院医师
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
