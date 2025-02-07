package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 电子病历（EMR）医嘱处方实体类
 */
@Entity
@Table(name = "emr_order")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmrOrder extends BaseEntity {

    /**
     * 患者基本信息 ID
     */
    @Column(name = "patient_id")
    private String patientId;

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
     * 处方编号
     */
    @Column(name = "prescription_no")
    private String prescriptionNo;

    /**
     * 处方类别代码
     */
    @Column(name = "prescription_type_code")
    private String prescriptionTypeCode;

    /**
     * 处方开立日期
     */
    @Column(name = "prescription_issuance_date")
    private LocalDateTime prescriptionIssuanceDate;

    /**
     * 处方有效天数
     */
    @Column(name = "prescription_validity_days")
    private Integer prescriptionValidityDays;

    /**
     * 医嘱处方执行日期
     */
    @Column(name = "execute_date")
    private LocalDateTime executeDate;

    /**
     * 处方开立医师
     */
    @Column(name = "prescription_issuance_id")
    private String prescriptionIssuanceId;

    /**
     * 处方发药药剂师
     */
    @Column(name = "prescription_dispensing_id")
    private String prescriptionDispensingId;

    /**
     * 处方备注信息
     */
    @Column(name = "prescription_notes")
    private String prescriptionNotes;

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
    private LocalDateTime operationTime;

    @Transient
    private List<EmrOrderItem> orderItemList; // 医嘱处方明细信息
}
