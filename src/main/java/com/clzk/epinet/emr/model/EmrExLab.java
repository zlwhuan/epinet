package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;
import java.util.List;

/**
 * 检验报告实体类
 */
@Entity
@Table(name = "emr_ex_lab")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmrExLab extends BaseEntity {


    @Id
    @Column(name = "id", length = 80)
    private String id;
    /**
     * 患者基本信息 ID
     */
    @Column(name = "patient_id", length = 80)
    private String patientId;

    /**
     * 就诊记录类型代码
     */
    @Column(name = "activity_type_code",length = 2)
    private String activityTypeCode;

    /**
     * 就诊记录类型名称
     */
    @Column(name = "activity_type_name", length = 20)
    private String activityTypeName;

    /**
     * 就诊流水号
     */
    @Column(name = "serial_number", length = 20)
    private String serialNumber;

    /**
     * 患者姓名
     */
    @Column(name = "patient_name", length = 100)
    private String patientName;

    /**
     * 身份证件类别代码
     */
    @Column(name = "id_card_type_code", length = 2)
    private String idCardTypeCode;

    /**
     * 身份证件类别名称
     */
    @Column(name = "id_card_type_name", length = 20)
    private String idCardTypeName;

    /**
     * 身份证件号码
     */
    @Column(name = "id_card", length = 50)
    private String idCard;

    /**
     * 病房号
     */
    @Column(name = "ward_no", length = 10)
    private String wardNo;

    /**
     * 病区名称
     */
    @Column(name = "ward_name", length = 50)
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
    private Timestamp specimenSamplingDate;

    /**
     * 接收标本日期时间
     */
    @Column(name = "specimen_receiving_date")
    private Timestamp specimenReceivingDate;

    /**
     * 检验医师
     */
    @Column(name = "examination_physician_id")
    private String examinationPhysicianId;

    /**
     * 检验日期
     */
    @Column(name = "examination_date")
    private Timestamp examinationDate;

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
    private Timestamp examinationReportDate;

    /**
     * 报告医师
     */
    @Column(name = "examination_report_id")
    private String examinationReportId;

    /**
     * 检验报告机构编码
     */
    @Column(name = "org_code", length = 9)
    private String orgCode;

    /**
     * 检验报告机构名称
     */
    @Column(name = "org_name", length = 100)
    private String orgName;

    /**
     * 检验报告科室代码
     */
    @Column(name = "dept_code", length = 20)
    private String deptCode;

    /**
     * 检验报告科室名称
     */
    @Column(name = "dept_name", length = 50)
    private String deptName;

    /**
     * 操作人 ID
     */
    @Column(name = "operator_id", length = 40)
    private String operatorId;

    /**
     * 操作时间
     */
    @Column(name = "operation_time")
    private Timestamp operationTime;

    @Transient
    private List<EmrExLabItem> exLabItemList; // 检验报告明细信息
}
