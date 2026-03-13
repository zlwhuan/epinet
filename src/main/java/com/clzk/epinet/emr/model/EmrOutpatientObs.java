package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

/**
 * 门（急）诊留观记录信息 - 记录患者的急诊留观情况
 */
@Entity
@Table(name = "emr_outpatient_observation")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmrOutpatientObs extends BaseEntity {

    @Id
    @Column(name = "id", length = 80)
    private String id;

    @Column(name = "patient_id", length = 80)
    private String patientId; // 患者 ID
    @Column(name = "serial_number", length = 20)
    private String serialNumber; // 就诊流水号
    @Column(name = "patient_name", length = 100)
    private String patientName; // 患者姓名
    @Column(name = "id_card_type_code", length = 2)
    private String idCardTypeCode; // 身份证件类别代码
    @Column(name = "id_card_type_name", length = 20)
    private String idCardTypeName; // 身份证件类别名称
    @Column(name = "id_card", length = 50)
    private String idCard; // 身份证件号码
    @Column(name = "allergy_his_flag", length = 1)
    private String allergyHisFlag; // 过敏史标志
    @Lob
    @Column(name = "allergy_his")
    private String allergyHis; // 过敏史描述
    private Timestamp outpatientDate; // 就诊日期时间
    @Column(name = "inital_diagnosis_code", length = 1)
    private String initalDiagnosisCode; // 初步诊断代码
    @Lob
    @Column(name = "chief_complaint")
    private String chiefComplaint; // 主诉
    @Lob
    @Column(name = "present_illness_his")
    private String presentIllnessHis; // 现病史
    @Lob
    @Column(name = "past_illness_his")
    private String pastIllnessHis; // 既往史
    @Lob
    @Column(name = "physical_examination")
    private String physicalExamination; // 体格检查
    @Lob
    @Column(name = "observation_result")
    private String observationResult; // 中医“四诊”观察结果
    @Lob
    @Column(name = "studies_summary_result")
    private String studiesSummaryResult; // 辅助检查
    @Column(name = "wm_diagnosis_code", length = 400)
    private String wmDiagnosisCode; // 初步诊断-西医诊断代码
    @Column(name = "wm_diagnosis_name", length = 400)
    private String wmDiagnosisName; // 初步诊断-西医诊断名称
    @Column(name = "tcm_inital_diagnosis_code", length = 250)
    private String tcmInitalDiagnosisCode; // 初步诊断-中医病名代码
    @Column(name = "tcm_inital_diagnosis_name", length = 250)
    private String tcmInitalDiagnosisName; // 初步诊断-中医病名名称
    @Column(name = "tcm_inital_syndrome_code", length = 250)
    private String tcmInitalSyndromeCode; // 初步诊断-中医证候代码
    @Column(name = "tcm_inital_syndrome_name", length = 250)
    private String tcmInitalSyndromeName; // 初步诊断-中医证候名称
    @Column(name = "differentiation_basis", length = 100)
    private String differentiationBasis; // 辨证依据
    @Column(name = "treatment", length = 100)
    private String treatment; // 治则治法
    @Lob
    @Column(name = "course")
    private String course; // 急诊留观病程记录
    private Timestamp observationDate; // 收入观察室日期时间
    private String notes; // 注意事项
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
