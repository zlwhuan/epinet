package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

/**
 * 检验报告实体类
 */
@Entity
@Table(name = "EMR_EX_LAB")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmrExLab extends BaseEntity {

    @Id
    @Column(name = "ID", length = 80, nullable = false)
    private String id;

    /**
     * 患者基本信息 ID
     */
    @Column(name = "PATIENT_ID", length = 80, nullable = false)
    private String patientId;

    /**
     * 就诊记录类型代码
     */
    @Column(name = "ACTIVITY_TYPE_CODE", length = 2)
    private String activityTypeCode;

    /**
     * 就诊记录类型名称
     */
    @Column(name = "ACTIVITY_TYPE_NAME", length = 20)
    private String activityTypeName;

    /**
     * 就诊流水号
     */
    @Column(name = "SERIAL_NUMBER", length = 20)
    private String serialNumber;

    /**
     * 患者姓名
     */
    @Column(name = "PATIENT_NAME", length = 100)
    private String patientName;

    /**
     * 身份证件类别代码
     */
    @Column(name = "ID_CARD_TYPE_CODE", length = 2)
    private String idCardTypeCode;

    /**
     * 身份证件类别名称
     */
    @Column(name = "ID_CARD_TYPE_NAME", length = 20)
    private String idCardTypeName;

    /**
     * 身份证件号码
     */
    @Column(name = "ID_CARD", length = 50)
    private String idCard;

    /**
     * 病房号
     */
    @Column(name = "WARD_NO", length = 10)
    private String wardNo;

    /**
     * 病区名称
     */
    @Column(name = "WARD_NAME", length = 50)
    private String wardName;

    /**
     * 病床号
     */
    @Column(name = "BED_NO", length = 10)
    private String bedNo;

    /**
     * 电子申请单编号
     */
    @Column(name = "APPLICATION_FORM_NO", length = 50)
    private String applicationFormNo;

    /**
     * 检验申请科室代码
     */
    @Column(name = "APPLY_DEPT_CODE", length = 20)
    private String applyDeptCode;

    /**
     * 检验申请科室名称
     */
    @Column(name = "APPLY_DEPT_NAME", length = 100)
    private String applyDeptName;

    /**
     * 检验申请机构代码
     */
    @Column(name = "APPLY_ORG_CODE", length = 20)
    private String applyOrgCode;

    /**
     * 检验申请机构名称
     */
    @Column(name = "APPLY_ORG_NAME", length = 100)
    private String applyOrgName;

    /**
     * 检验申请医师
     */
    @Column(name = "APPLY_PHYSICIAN_ID", length = 50)
    private String applyPhysicianId;

    /**
     * 标本类别代码
     */
    @Column(name = "SPECIMEN_CATEGORY_CODE", length = 10)
    private String specimenCategoryCode;

    /**
     * 标本类别名称
     */
    @Column(name = "SPECIMEN_CATEGORY_NAME", length = 50)
    private String specimenCategoryName;

    /**
     * 检验标本号
     */
    @Column(name = "SPECIMEN_NO", length = 50)
    private String specimenNo;

    /**
     * 标本采样日期时间
     */
    @Column(name = "SPECIMEN_SAMPLING_DATE")
    private Timestamp specimenSamplingDate;

    /**
     * 接收标本日期时间
     */
    @Column(name = "SPECIMEN_RECEIVING_DATE")
    private Timestamp specimenReceivingDate;

    /**
     * 检验医师
     */
    @Column(name = "EXAMINATION_PHYSICIAN_ID", length = 50)
    private String examinationPhysicianId;

    /**
     * 检验日期
     */
    @Column(name = "EXAMINATION_DATE")
    private Timestamp examinationDate;

    /**
     * 检验报告单编号
     */
    @Column(name = "EXAMINATION_REPORT_NO", length = 50)
    private String examinationReportNo;

    /**
     * 检验报告结果-客观所见
     */
    @Lob
    @Column(name = "EXAMINATION_OBJECTIVE_DESC")
    private String examinationObjectiveDesc;

    /**
     * 检验报告结果-主观提示
     */
    @Lob
    @Column(name = "EXAMINATION_SUBJECTIVE_DESC")
    private String examinationSubjectiveDesc;

    /**
     * 检验报告备注
     */
    @Lob
    @Column(name = "EXAMINATION_NOTES")
    private String examinationNotes;

    /**
     * 检验报告日期
     */
    @Column(name = "EXAMINATION_REPORT_DATE")
    private Timestamp examinationReportDate;

    /**
     * 报告医师
     */
    @Column(name = "EXAMINATION_REPORT_ID", length = 50)
    private String examinationReportId;

    /**
     * 检验报告机构编码
     */
    @Column(name = "ORG_CODE", length = 9)
    private String orgCode;

    /**
     * 检验报告机构名称
     */
    @Column(name = "ORG_NAME", length = 100)
    private String orgName;

    /**
     * 检验报告科室代码
     */
    @Column(name = "DEPT_CODE", length = 20)
    private String deptCode;

    /**
     * 检验报告科室名称
     */
    @Column(name = "DEPT_NAME", length = 50)
    private String deptName;

    /**
     * 操作人 ID
     */
    @Column(name = "OPERATOR_ID", length = 40)
    private String operatorId;

    /**
     * 操作时间
     */
    @Column(name = "OPERATION_TIME", updatable = false)
    private Timestamp operationTime;
}