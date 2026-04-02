package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * 电子病历（EMR）医嘱处方实体类
 */
@Entity
@Table(name = "TEST_ORDER")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmrOrder extends BaseEntity {

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
     * 处方编号
     */
    @Column(name = "PRESCRIPTION_NO", length = 50)
    private String prescriptionNo;

    /**
     * 处方类别代码
     */
    @Column(name = "PRESCRIPTION_TYPE_CODE", length = 10)
    private String prescriptionTypeCode;

    /**
     * 处方开立日期
     */
    @Column(name = "PRESCRIPTION_ISSUANCE_DATE")
    private Timestamp prescriptionIssuanceDate;

    /**
     * 处方有效天数
     */
    @Column(name = "PRESCRIPTION_VALIDITY_DAYS")
    private Integer prescriptionValidityDays;

    /**
     * 医嘱处方执行日期
     */
    @Column(name = "EXCUTE_DATE")   // 注意：数据库字段为 EXCUTE_DATE（拼写与 Java 字段一致）
    private Timestamp executeDate;

    /**
     * 处方开立医师
     */
    @Column(name = "PRESCRIPTION_ISSUANCE_ID", length = 50)
    private String prescriptionIssuanceId;

    /**
     * 处方发药药剂师
     */
    @Column(name = "PRESCRIPTION_DISPENSING_ID", length = 50)
    private String prescriptionDispensingId;

    /**
     * 处方备注信息
     */
    @Column(name = "PRESCRIPTION_NOTES")
    private String prescriptionNotes;

    /**
     * 医疗机构代码
     */
    @Column(name = "ORG_CODE", length = 9)
    private String orgCode;

    /**
     * 医疗机构名称
     */
    @Column(name = "ORG_NAME", length = 100)
    private String orgName;

    /**
     * 科室代码
     */
    @Column(name = "DEPT_CODE", length = 20)
    private String deptCode;

    /**
     * 科室名称
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