package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import lombok.EqualsAndHashCode;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 检验报告项目实体类
 */
@Entity
@Table(name = "emr_ex_lab_item")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmrExLabItem extends BaseEntity {

    /**
     * 检验报告ID
     */
    @Column(name = "ex_lab_id")
    private String exLabId;

    /**
     * 院内检验项目代码
     */
    @Column(name = "item_code")
    private String itemCode;

    /**
     * 院内检验项目名称
     */
    @Column(name = "item_name")
    private String itemName;

    /**
     * 检验定性结果代码
     */
    @Column(name = "source_examination_result_code")
    private String sourceExaminationResultCode;

    /**
     * 检验定性结果名称
     */
    @Column(name = "source_examination_result_name")
    private String sourceExaminationResultName;

    /**
     * 标化检验定性结果代码
     */
    @Column(name = "examination_result_code")
    private String examinationResultCode;

    /**
     * 标化检验定性结果名称
     */
    @Column(name = "examination_result_name")
    private String examinationResultName;

    /**
     * 检验定量结果
     */
    @Column(name = "examination_quantification")
    private String examinationQuantification;

    /**
     * 检验定量结果计量单位
     */
    @Column(name = "examination_quantification_unit")
    private String examinationQuantificationUnit;

    /**
     * 检验定量结果参考区间-上限
     */
    @Column(name = "examination_quantification_upper")
    private String examinationQuantificationUpper;

    /**
     * 检验定量结果参考区间-下限
     */
    @Column(name = "examination_quantification_lower")
    private String examinationQuantificationLower;

    /**
     * 检验定量结果超出或低于参考值
     */
    @Column(name = "examination_quantification_ri")
    private String examinationQuantificationRi;


    /** 操作人 ID */
    @Column(name = "operator_id")
    private String operatorId;

    /** 操作时间 */
    @Column(name = "operation_time")
    private LocalDateTime operationTime;
}
