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
@Table(name = "emr_discharge_info")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmrDischargeInfo extends BaseEntity {

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
    private Timestamp admissionDate; // 入院日期时间
    private String admissionDesc; // 入院描述
    private String admissionDiagnosisCode; // 入院诊断代码
    private String admissionDiagnosisName; // 入院诊断名称
    @Lob
    @Column(name = "studies_summary_result")
    private String studiesSummaryResult; // 辅助检查
    @Lob
    @Column(name = "observation_result")
    private String observationResult; // 观察结果
    @Column(name = "treatment", length = 100)
    private String treatment; // 住院治疗
    private String treatmentDesc; // 治疗描述
    private String tcmDecoctionMethod; // 中药煎煮法
    private String tcmUseMethod; // 中药用药方法
    private String dischargeDesc; // 出院描述
    private Timestamp dischargeDate; // 出院日期时间
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
