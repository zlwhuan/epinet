package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

/**
 * 患者死亡信息实体类
 */
@Entity
@Table(name = "emr_death_info")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmrDeathInfo extends BaseEntity {

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
     * 诊疗过程描述
     */
    @Column(name = "treatment_desc")
    private String treatmentDesc;

    /**
     * 死亡日期时间
     */
    @Column(name = "dead_date")
    private Timestamp deadDate;

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
    @Column (name = "chief_physician_id", length = 50)
    private String chiefPhysicianId;

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
     * 操作人 ID
     */
    @Column(name = "operator_id", length = 40)
    private String operatorId;

    /**
     * 操作时间
     */
    @Column(name = "operation_time")
    private Timestamp operationTime;
}
