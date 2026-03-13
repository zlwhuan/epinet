package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 检查报告项目表
 * 对应 5.12 获取检查报告项目接口的返回参数
 */
@Entity
@Table(name = "emr_ex_clinical_item")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmrExClinicalItem extends BaseEntity {

    @Id
    @Column(name = "id", length = 80)
    private String id;

    /** 检查报告 ID */
    @Column(name = "ex_clinical_id")
    private String exClinicalId;

    /** 检查项目代码 */
    @Column(name = "item_code")
    private String itemCode;

    /** 检查项目名称 */
    @Column(name = "item_name")
    private String itemName;

    /** 检查结果代码 */
    @Column(name = "examination_result_code")
    private String examinationResultCode;

    /** 检查结果名称 */
    @Column(name = "examination_result_name")
    private String examinationResultName;

    /** 检查定量结果 */
    @Column(name = "examination_quantification")
    private String examinationQuantification;

    /** 检查定量结果计量单位 */
    @Column(name = "examination_quantification_unit")
    private String examinationQuantificationUnit;

    /** 操作人 ID */
    @Column(name = "operator_id", length = 40)
    private String operatorId;

    /** 操作时间 */
    @Column(name = "operation_time")
    private LocalDateTime operationTime;
}
