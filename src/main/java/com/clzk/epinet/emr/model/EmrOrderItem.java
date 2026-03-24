package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 医嘱处方条目实体类
 * 用于存储国家传染病智能监测预警前置软件中电子病历（EMR）医嘱处方条目信息
 */
@Entity
@Table(name = "EMR_ORDER_ITEM")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmrOrderItem extends BaseEntity {

    @Id
    @Column(name = "ID", length = 80, nullable = false)
    private String id;

    /**
     * 医嘱处方 ID
     */
    @Column(name = "ORDER_ID", length = 80, nullable = false)
    private String orderId;

    /**
     * 药物代码
     */
    @Column(name = "DRUG_CODE", length = 50)
    private String drugCode;

    /**
     * 药物名称
     */
    @Column(name = "DRUG_NAME", length = 200)
    private String drugName;

    /**
     * 药物规格
     */
    @Column(name = "DRUG_SPECIFICATIONS", length = 100)
    private String drugSpecifications;

    /**
     * 单次用药剂量
     */
    @Column(name = "DRUG_DOSAGE_CODE", length = 20)
    private String drugDosageCode;

    /**
     * 药物使用剂量单位代码
     */
    @Column(name = "DRUG_DOSAGE_UNIT_CODE", length = 20)
    private String drugDosageUnitCode;

    /**
     * 药物使用剂量单位名称
     */
    @Column(name = "DRUG_DOSAGE_UNIT_NAME", length = 20)
    private String drugDosageUnitName;

    /**
     * 药物使用总剂量
     */
    @Column(name = "DRUG_DOSAGE_TOTAL", length = 50)
    private String drugDosageTotal;

    /**
     * 中药饮片处方
     */
    @Column(name = "TCM_PRESCRIPTION", length = 10)
    private String tcmPrescription;

    /**
     * 中药饮片剂数（剂）
     */
    @Column(name = "TCM_NUMBER")
    private Integer tcmNumber;

    /**
     * 中药饮片煎煮法
     */
    @Column(name = "TCM_DECOCTION_METHOD", length = 50)
    private String tcmDecoctionMethod;

    /**
     * 中药用药方法
     */
    @Column(name = "TCM_USE_METHOD", length = 50)
    private String tcmUseMethod;

    /**
     * 操作人 ID
     */
    @Column(name = "OPERATOR_ID", length = 40)
    private String operatorId;

    /**
     * 操作时间
     */
    @Column(name = "OPERATION_TIME", updatable = false)
    private LocalDateTime operationTime;
}