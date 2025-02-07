package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import jakarta.persistence.Transient;
import lombok.EqualsAndHashCode;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 检查报告实体类
 * 对应 5.11 获取检查报告接口的返回参数
 */
@Entity
@Table(name = "emr_ex_clinical")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmrExClinical extends BaseEntity {


    /** 患者ID */
    @Column(name = "patient_id")
    private Long patientId;

    /** 诊疗活动类型代码 */
    @Column(name = "activity_type_code")
    private String activityTypeCode;

    /** 诊疗活动类型名称 */
    @Column(name = "activity_type_name")
    private String activityTypeName;

    /** 就诊流水号 */
    @Column(name = "serial_number")
    private String serialNumber;

    /** 患者姓名 */
    @Column(name = "patient_name")
    private String patientName;

    /** 证件类别代码 */
    @Column(name = "id_card_type_code")
    private String idCardTypeCode;

    /** 证件类别名称 */
    @Column(name = "id_card_type_name")
    private String idCardTypeName;

    /** 证件号码 */
    @Column(name = "id_card")
    private String idCard;

    /** 病区名称 */
    @Column(name = "ward_name")
    private String wardName;

    /** 病区号 */
    @Column(name = "ward_no")
    private String wardNo;

    /** 床号 */
    @Column(name = "bed_no")
    private String bedNo;

    /** 申请单号 */
    @Column(name = "application_form_no")
    private String applicationFormNo;

    /** 申请科室名称 */
    @Column(name = "apply_dept_name")
    private String applyDeptName;

    /** 申请科室代码 */
    @Column(name = "apply_dept_code")
    private String applyDeptCode;

    /** 申请机构代码 */
    @Column(name = "apply_org_code")
    private String applyOrgCode;

    /** 申请机构名称 */
    @Column(name = "apply_org_name")
    private String applyOrgName;

    /** 症状开始日期 */
    @Column(name = "symptom_start_date")
    private LocalDateTime symptomStartDate;

    /** 症状结束日期 */
    @Column(name = "symptom_end_date")
    private LocalDateTime symptomEndDate;

    /** 症状描述 */
    @Column(name = "symptom_desc")
    private String symptomDesc;

    /** 既往治疗情况 */
    @Column(name = "treatment_desc")
    private String treatmentDesc;

    /** 特殊检查代码 */
    @Column(name = "special_examination_code")
    private String specialExaminationCode;

    /** 检查类型代码 */
    @Column(name = "examination_type_code")
    private String examinationTypeCode;

    /** 检查类型名称 */
    @Column(name = "examination_type_name")
    private String examinationTypeName;

   /** 检查目标描述 */
    @Column(name = "examination_objective_desc")
    private String examinationObjectiveDesc;

    /** 检查主观描述 */
    @Column(name = "examination_subjective_desc")
    private String examinationSubjectiveDesc;

    /** 检查备注 */
    @Column(name = "examination_notes")
    private String examinationNotes;

    /** 检查报告编号 */
    @Column(name = "examination_report_no")
    private String examinationReportNo;

    /** 检查报告日期 */
    @Column(name = "examination_report_date")
    private LocalDateTime examinationReportDate;

    /** 检查报告ID */
    @Column(name = "examination_report_id")
    private String examinationReportId;

    /** 主诉 */
    @Column(name = "chief_complaint")
    private String chiefComplaint;

    /** 医疗机构代码 */
    @Column(name = "org_code")
    private String orgCode;

    /** 医疗机构名称 */
    @Column(name = "org_name")
    private String orgName;

    /** 申请科室代码 */
    @Column(name = "dept_code")
    private String deptCode;

    /** 申请科室名称 */
    @Column(name = "dept_name")
    private String deptName;

    /** 操作人ID */
    @Column(name = "operator_id")
    private String operatorId;

    /** 操作时间 */
    @Column(name = "operation_time")
    private LocalDateTime operationTime;

    /** 检查报告明细 */
    @Transient
    private List<EmrExClinicalItem> exClinicalItemList;
}
