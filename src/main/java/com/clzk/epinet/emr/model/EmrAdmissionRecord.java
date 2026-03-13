package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

/**
 * 住院病案首页信息 - 记录患者的住院病案首页信息
 */
@Entity
@Table(name = "emr_admission_record")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmrAdmissionRecord extends BaseEntity {

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
    @Column(name = "health_card_no", length = 18)
    private String healthCardNo; // 居民健康卡号
    @Column(name = "pay_method_code", length = 2)
    private String payMethodCode; // 医疗付费方式代码
    @Column(name = "pay_method_name", length = 50)
    private String payMethodName; // 医疗付费方式名称
    @Column(name = "admission_num", length = 3)
    private String admissionNum; // 住院次数
    @Column(name = "reg_no", length = 18)
    private String regNo; // 病案号
    private Timestamp admissionDate; // 入院日期时间

    @Column(name = "admission_dept_code", length = 20)
    private String admissionDeptCode; // 入院科别代码

    @Column(name = "admission_dept_name", length = 50)
    private String admissionDeptName; // 入院科别名称
    @Column(name = "ward_no", length = 10)
    private String wardNo; // 入院病房编号
    private Timestamp dischargeDate; // 出院日期时间
    @Column(name = "discharge_dept_code", length = 20)
    private String dischargeDeptCode; // 出院科别代码
    @Column(name = "discharge_dept_name", length = 50)
    private String dischargeDeptName; // 出院科别名称
    @Column(name = "discharge_ward", length = 10)
    private String dischargeWard; // 出院病房
    @Column(name = "admission_days", length = 4)
    private String admissionDays; // 实际住院天数

    @Column(name = "wm_outpatient_diagnosis_code", length = 400)
    private String wmOutpatientDiagnosisCode; // 门（急)诊诊断代码
    @Column(name = "wm_outpatient_diagnosis_name", length = 400)
    private String wmOutpatientDiagnosisName; // 门（急)诊诊断名称
    @Column(name = "discharge_diagnosis_code", length = 400)
    private String dischargeDiagnosisCode; // 出院诊断-主要西医诊断代码
    @Column(name = "discharge_diagnosis_name", length = 400)
    private String dischargeDiagnosisName; // 出院诊断-主要西医诊断名称
    @Column(name = "wm_other_diagnosis_code", length = 400)
    private String wmOtherDiagnosisName; // 出院诊断-其他诊断名称
    @Column(name = "external_causes_code", length = 50)
    private String externalCausesCode; // 损伤中毒的外部原因疾病编码
    @Column(name = "external_causes_name", length = 200)
    private String externalCausesName; // 损伤中毒的外部原因疾病名称
    @Lob
    @Column(name = "external_causes_system_name")
    private String externalCausesSystemName; // 损伤中毒的外部原因
    @Column(name = "pathological_diagnosis_code", length = 50)
    private String pathologicalDiagnosisCode; // 病理诊断编码
    @Column(name = "pathological_diagnosis_name", length = 200)
    private String pathologicalDiagnosisName; // 病理诊断名称
    @Column(name = "pathological_no", length = 50)
    private String pathologicalNo; // 病理号
    @Column(name = "allergy_code", length = 1)
    private String allergyCode; // 药物过敏标志
    @Lob
    @Column(name = "allergy_drug", length = 50)
    private String allergyDrug; // 过敏药物
    @Column(name = "autopsy_code", length = 1)
    private String autopsyCode; // 死亡患者尸检标志
    @Column (name = "chief_physician_id", length = 50)
    private String chiefPhysicianId; // 主治医师
    @Column (name = "resident_physician_id", length = 50)
    private String residentPhysicianId; // 住院医师
    @Column (name = "accept_org_code", length = 9)
    private String acceptOrgCode; // 拟接收医疗机构代码
    @Column (name = "accept_org_name", length = 70)
    private String acceptOrgName; // 拟接收医疗机构名称
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
