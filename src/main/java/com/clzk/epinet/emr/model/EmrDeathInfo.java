package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import lombok.EqualsAndHashCode;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * 患者死亡信息实体类
 */
@Entity
@Table(name = "emr_death_info")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmrDeathInfo extends BaseEntity {

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
     * 诊疗过程描述
     */
    @Column(name = "treatment_desc")
    private String treatmentDesc;

    /**
     * 死亡日期时间
     */
    @Column(name = "dead_date")
    private String deadDate;

    /**
     * 直接死亡原因编码
     */
    @Column(name = "direct_cause_code")
    private String directCauseCode;

    /**
     * 直接死亡原因名称
     */
    @Column(name = "direct_cause_name")
    private String directCauseName;

    /**
     * 死亡诊断代码
     */
    @Column(name = "death_diagnosis_code")
    private String deathDiagnosisCode;

    /**
     * 死亡诊断名称
     */
    @Column(name = "death_diagnosis_name")
    private String deathDiagnosisName;

    /**
     * 主治医师 ID
     */
    @Column(name = "chief_physician_id")
    private String chiefPhysicianId;

    /**
     * 医疗机构代码
     */
    @Column(name = "org_code")
    private String orgCode;

    /**
     * 医疗机构名称
     */
    @Column(name = "org_name")
    private String orgName;

    /**
     * 科室代码
     */
    @Column(name = "dept_code")
    private String deptCode;

    /**
     * 科室名称
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
}
