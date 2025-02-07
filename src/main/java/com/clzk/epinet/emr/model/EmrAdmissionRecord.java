package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import lombok.EqualsAndHashCode;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * 住院病案首页信息 - 记录患者的住院病案首页信息
 */
@Entity
@Table(name = "emr_admission_record")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmrAdmissionRecord extends BaseEntity {

    private Long patientId; // 患者 ID
    private String serialNumber; // 住院号
    private String patientName; // 患者姓名
    private String idCardTypeCode; // 身份证件类别代码
    private String idCardTypeName; // 身份证件类别名称
    private String idCard; // 身份证件号码
    private String healthCardNo; // 居民健康卡号
    private String payMethodCode; // 医疗付费方式代码
    private String payMethodName; // 医疗付费方式名称
    private String admissionNum; // 住院次数
    private String regNo; // 病案号
    private String admissionDate; // 入院日期时间
    private String admissionDeptCode; // 入院科别代码
    private String admissionDeptName; // 入院科别名称
    private String wardNo; // 入院病房编号
    private String dischargeDate; // 出院日期时间
    private String dischargeDeptCode; // 出院科别代码
    private String dischargeDeptName; // 出院科别名称
    private String dischargeWard; // 出院病房
    private String admissionDays; // 实际住院天数
    private String wmOutpatientDiagnosisCode; // 门（急)诊诊断代码
    private String wmOutpatientDiagnosisName; // 门（急)诊诊断名称
    private String dischargeDiagnosisCode; // 出院诊断-主要西医诊断代码
    private String dischargeDiagnosisName; // 出院诊断-主要西医诊断名称
    private String wmOtherDiagnosisCode; // 出院诊断-其他诊断代码
    private String wmOtherDiagnosisName; // 出院诊断-其他诊断名称
    private String externalCausesCode; // 损伤中毒的外部原因疾病编码
    private String externalCausesName; // 损伤中毒的外部原因疾病名称
    private String externalCausesSystemName; // 损伤中毒的外部原因
    private String pathologicalDiagnosisCode; // 病理诊断编码
    private String pathologicalDiagnosisName; // 病理诊断名称
    private String pathologicalNo; // 病理号
    private String allergyCode; // 药物过敏标志
    private String allergyDrug; // 过敏药物
    private String autopsyCode; // 死亡患者尸检标志
    private String chiefPhysicianId; // 主治医师
    private String residentPhysicianId; // 住院医师
    private String acceptOrgCode; // 拟接收医疗机构代码
    private String acceptOrgName; // 拟接收医疗机构名称
    private String orgCode; // 医疗机构代码
    private String orgName; // 医疗机构名称
    private String deptCode; // 科室代码
    private String deptName; // 科室名称
    private String operatorId; // 操作人 ID
    private String operationTime; // 操作时间
}
