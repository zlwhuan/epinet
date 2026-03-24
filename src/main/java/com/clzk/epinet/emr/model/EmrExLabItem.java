package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 检验报告项目实体类
 */
@Entity
@Table(name = "EMR_EX_LAB_ITEM")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmrExLabItem extends BaseEntity {

    @Id
    @Column(name = "ID", length = 80, nullable = false)
    private String id;

    /**
     * 检验报告ID
     */
    @Column(name = "EX_LAB_ID", length = 80, nullable = false)
    private String exLabId;

    /**
     * 院内检验项目代码
     */
    @Column(name = "ITEM_CODE", length = 20)
    private String itemCode;

    /**
     * 院内检验项目名称
     */
    @Column(name = "ITEM_NAME", length = 100)
    private String itemName;

    /**
     * 检验定性结果代码
     */
    @Column(name = "SOURCE_EXAMINATION_RESULT_CODE", length = 50)
    private String sourceExaminationResultCode;

    /**
     * 检验定性结果名称
     */
    @Column(name = "SOURCE_EXAMINATION_RESULT_NAME", length = 100)
    private String sourceExaminationResultName;

    /**
     * 标化检验定性结果代码
     */
    @Column(name = "EXAMINATION_RESULT_CODE", length = 50)
    private String examinationResultCode;

    /**
     * 标化检验定性结果名称
     */
    @Column(name = "EXAMINATION_RESULT_NAME", length = 100)
    private String examinationResultName;

    /**
     * 检验定量结果
     */
    @Column(name = "EXAMINATION_QUANTIFICATION", length = 50)
    private String examinationQuantification;

    /**
     * 检验定量结果计量单位
     */
    @Column(name = "EXAMINATION_QUANTIFICATION_UNIT", length = 20)
    private String examinationQuantificationUnit;

    /**
     * 检验定量结果参考区间-下限
     */
    @Column(name = "EXAMINATION_QUANTIFICATION_LOWER", length = 50)
    private String examinationQuantificationLower;

    /**
     * 检验定量结果参考区间-上限
     */
    @Column(name = "EXAMINATION_QUANTIFICATION_UPPER", length = 50)
    private String examinationQuantificationUpper;

    /**
     * 检验定量结果超出或低于参考值
     */
    @Column(name = "EXAMINATION_QUANTIFICATION_RI", length = 20)
    private String examinationQuantificationRi;

    /** 操作人 ID */
    @Column(name = "OPERATOR_ID", length = 40)
    private String operatorId;

    /** 操作时间 */
    @Column(name = "OPERATION_TIME", updatable = false)
    private LocalDateTime operationTime;
}