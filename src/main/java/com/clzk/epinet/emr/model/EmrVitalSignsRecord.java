package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import lombok.EqualsAndHashCode;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * 生命体征护理记录单信息实体类
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "emr_vital_signs_record")
public class EmrVitalSignsRecord extends BaseEntity {

    /** 患者基本信息ID */
    @Column(name = "patient_id")
    private Long patientId;

    /** 就诊记录类型代码 */
    @Column(name = "activity_type_code")
    private String activityTypeCode;

    /** 就诊记录类型名称 */
    @Column(name = "activity_type_name")
    private String activityTypeName;

    /** 就诊流水号 */
    @Column(name = "serial_number")
    private String serialNumber;

    /** 患者姓名 */
    @Column(name = "patient_name")
    private String patientName;

    /** 身份证件类别代码 */
    @Column(name = "id_card_type_code")
    private String idCardTypeCode;

    /** 身份证件类别名称 */
    @Column(name = "id_card_type_name")
    private String idCardTypeName;

    /** 身份证件号码 */
    @Column(name = "id_card")
    private String idCard;

    /** 记录日期时间 */
    @Column(name = "create_date")
    private String createDate;

    /** 是否使用呼吸机代码 */
    @Column(name = "ventilator_used_code")
    private String ventilatorUsedCode;

    /** 是否使用呼吸机 */
    @Column(name = "ventilator_used_name")
    private String ventilatorUsedName;

    /** 是否重症监护代码 */
    @Column(name = "critical_care_code")
    private String criticalCareCode;

    /** 是否重症监护名称 */
    @Column(name = "critical_care_name")
    private String criticalCareName;

    /** 医疗机构代码 */
    @Column(name = "org_code")
    private String orgCode;

    /** 医疗机构名称 */
    @Column(name = "org_name")
    private String orgName;

    /** 科室代码 */
    @Column(name = "dept_code")
    private String deptCode;

    /** 科室名称 */
    @Column(name = "dept_name")
    private String deptName;

    /** 操作人ID */
    @Column(name = "operator_id")
    private String operatorId;

    /** 操作时间 */
    @Column(name = "operation_time")
    private String operationTime;
}
