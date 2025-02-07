package com.clzk.epinet.edr.model;

import com.clzk.epinet.base.model.BaseEntity;
import lombok.EqualsAndHashCode;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * 治疗信息
 * 记录患者的治疗方案、治疗开始时间及结束时间。
 */
@Entity
@Table(name = "edr_treatment_info")
@Data
@EqualsAndHashCode(callSuper = true)
public class EdrTreatmentInfo extends BaseEntity {
    private String mpiId;                       // 主索引 ID
    private String treatmentTypeCode;          // 治疗类型代码
    private String registrationNo;             // 登记号/治疗号
    private String treatmentShcemeCode;        // 治疗方案代码
    private String beginTreatmentDate;         // 开始治疗日期
    private String stopTreatmentDate;          // 停止治疗日期
    private String endTreatmentReasonCode;    // 停止治疗原因代码
    private String nonTreatmentReasonCode;    // 未接受治疗原因代码
    private String recoveryDays;               // 病例无残留麻痹从麻痹至正常时间
    private String treatmentCategoryCode;      // 治疗类别代码
    private String createOrg;                  // 创建机构
    private String updateOrg;                  // 修改机构
    private String createUser;                 // 创建人
    private String createTime;                 // 创建时间
    private String updateUser;                 // 修改人
    private String updateTime;                 // 修改时间
    private Long patientId;                  // 个人主状态信息 ID
}
