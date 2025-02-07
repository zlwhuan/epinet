package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import lombok.EqualsAndHashCode;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 医嘱处方条目实体类
 * 用于存储国家传染病智能监测预警前置软件中电子病历（EMR）医嘱处方条目信息
 */
@Entity
@Table(name = "emr_order_item")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmrOrderItem extends BaseEntity {

    /**
     * 医嘱处方 ID
     */
    @Column(name = "order_id", nullable = false)
    private Long orderId;

    /**
     * 药物代码
     */
    @Column(name = "drug_code", nullable = false)
    private String drugCode;

    /**
     * 药物名称
     */
    @Column(name = "drug_name", nullable = false)
    private String drugName;

    /**
     * 药物规格
     */
    @Column(name = "drug_specifications")
    private String drugSpecifications;

    /**
     * 单次用药剂量
     */
    @Column(name = "drug_dosage_code")
    private String drugDosageCode;

    /**
     * 药物使用剂量单位代码
     */
    @Column(name = "drug_dosage_unit_code")
    private String drugDosageUnitCode;

    /**
     * 药物使用剂量单位名称
     */
    @Column(name = "drug_dosage_unit_name")
    private String drugDosageUnitName;

    /**
     * 药物使用总剂量
     */
    @Column(name = "drug_dosage_total")
    private String drugDosageTotal;

    /**
     * 中药饮片处方
     */
    @Column(name = "tcm_prescription")
    private String tcmPrescription;

    /**
     * 中药饮片剂数（剂）
     */
    @Column(name = "tcm_number")
    private Integer tcmNumber;

    /**
     * 中药饮片煎煮法
     */
    @Column(name = "tcm_decoction_method")
    private String tcmDecoctionMethod;

    /**
     * 中药用药方法
     */
    @Column(name = "tcm_use_method")
    private String tcmUseMethod;

    /**
     * 操作人 ID
     */
    @Column(name = "operator_id", nullable = false)
    private String operatorId;

    /**
     * 操作时间
     */
    @Column(name = "operation_time")
    private LocalDateTime operationTime;
}
