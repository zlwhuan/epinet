package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 检验报告实体类
 */
@Entity
@Table(name = "emr_ex_lab")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmrExLab extends BaseEntity {

    /**
     * 患者基本信息 ID
     */
    @Column(name = "patient_id")
    private Long patientId;

    /**
     * 就诊记录类型代码
     */
    @Column(name = "activity_type_code")
    private String activityTypeCode;

    /**
     * 就诊记录类型名称
     */
    @Column(name = "activity_type_name")
    private String activityTypeName;

    /**
     * 就诊流水号
     */
    @Column(name = "serial_number")
    private String serialNumber;

    /**
     * 患者姓名
     */
    @Column(name = "patient_name")
    private String patientName;

    /**
     * 身份证件类别代码
     */
    @Column(name = "id_card_type_code")
    private String idCardTypeCode;

    /**
     * 身份证件类别名称
     */
    @Column(name = "id_card_type_name")
    private String idCardTypeName;

    /**
     * 身份证件号码
     */
    @Column(name = "id_card")
    private String idCard;

    /**
     * 病房号
     */
    @Column(name = "ward_no")
    private String wardNo;

    /**
     * 病区名称
     */
    @Column(name = "ward_name")
    private String wardName;

    /**
     * 病床号
     */
    @Column(name = "bed_no")
    private String bedNo;

    /**
     * 电子申请单编号
     */
    @Column(name = "application_form_no")
    private String applicationFormNo;

    /**
     * 检验申请科室代码
     */
    @Column(name = "apply_dept_code")
    private String applyDeptCode;

    /**
     * 检验申请科室名称
     */
    @Column(name = "apply_dept_name")
    private String applyDeptName;

    /**
     * 检验申请机构代码
     */
    @Column(name = "apply_org_code")
    private String applyOrgCode;

    /**
     * 检验申请机构名称
     */
    @Column(name = "apply_org_name")
    private String applyOrgName;

    /**
     * 检验申请医师
     */
    @Column(name = "apply_physician_id")
    private String applyPhysicianId;

    /**
     * 标本类别代码
     */
    @Column(name = "specimen_category_code")
    private String specimenCategoryCode;

    /**
     * 标本类别名称
     */
    @Column(name = "specimen_category_name")
    private String specimenCategoryName;

    /**
     * 检验标本号
     */
    @Column(name = "specimen_no")
    private String specimenNo;

    /**
     * 标本采样日期时间
     */
    @Column(name = "specimen_sampling_date")
    private String specimenSamplingDate;

    /**
     * 接收标本日期时间
     */
    @Column(name = "specimen_receiving_date")
    private String specimenReceivingDate;

    /**
     * 检验医师
     */
    @Column(name = "examination_physician_id")
    private String examinationPhysicianId;

    /**
     * 检验日期
     */
    @Column(name = "examination_date")
    private String examinationDate;

    /**
     * 检验报告单编号
     */
    @Column(name = "examination_report_no")
    private String examinationReportNo;

    /**
     * 检验报告结果-客观所见
     */
    @Column(name = "examination_objective_desc")
    private String examinationObjectiveDesc;

    /**
     * 检验报告结果-主观提示
     */
    @Column(name = "examination_subjective_desc")
    private String examinationSubjectiveDesc;

    /**
     * 检验报告备注
     */
    @Column(name = "examination_notes")
    private String examinationNotes;

    /**
     * 检验报告日期
     */
    @Column(name = "examination_report_date")
    private String examinationReportDate;

    /**
     * 报告医师
     */
    @Column(name = "examination_report_id")
    private String examinationReportId;

    /**
     * 检验报告机构编码
     */
    @Column(name = "org_code")
    private String orgCode;

    /**
     * 检验报告机构名称
     */
    @Column(name = "org_name")
    private String orgName;

    /**
     * 检验报告科室代码
     */
    @Column(name = "dept_code")
    private String deptCode;

    /**
     * 检验报告科室名称
     */
    @Column(name = "dept_name")
    private String deptName;

    /**
     * 操作人 ID
     */
    @Column(name = "operator_id")
    private String operatorId;

    /**
     * 操作时间
     */
    @Column(name = "operation_time")
    private String operationTime;

    @Transient
    private List<EmrExLabItem> exLabItemList; // 检验报告明细信息
}
