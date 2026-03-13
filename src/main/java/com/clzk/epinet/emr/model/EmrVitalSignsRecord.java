package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

/**
 * 生命体征护理记录单信息实体类
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "emr_vital_signs_record")
public class EmrVitalSignsRecord extends BaseEntity {

    @Id
    @Column(name = "id", length = 80)
    private String id;

    /**
     * 患者基本信息ID
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
     * 记录日期时间
     */
    @Column(name = "create_date")
    private Timestamp createDate;

    /**
     * 是否使用呼吸机代码
     */
    @Column(name = "ventilator_used_code")
    private String ventilatorUsedCode;

    /**
     * 是否使用呼吸机
     */
    @Column(name = "ventilator_used_name")
    private String ventilatorUsedName;

    /**
     * 是否重症监护代码
     */
    @Column(name = "critical_care_code")
    private String criticalCareCode;

    /**
     * 是否重症监护名称
     */
    @Column(name = "critical_care_name")
    private String criticalCareName;

    /**
     * 医疗机构代码
     */
    @Column(name = "org_code", length = 9)
    private String orgCode;

    /**
     * 医疗机构名称
     */
    @Column(name = "org_name", length = 100)
    private String orgName;

    /**
     * 科室代码
     */
    @Column(name = "dept_code", length = 20)
    private String deptCode;

    /**
     * 科室名称
     */
    @Column(name = "dept_name", length = 50)
    private String deptName;

    /**
     * 操作人ID
     */
    @Column(name = "operator_id", length = 40)
    private String operatorId;

    /**
     * 操作时间
     */
    @Column(name = "operation_time")
    private Timestamp operationTime;
}
