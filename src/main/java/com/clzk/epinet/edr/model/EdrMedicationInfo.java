package com.clzk.epinet.edr.model;

import com.clzk.epinet.base.model.BaseEntity;
import lombok.EqualsAndHashCode;
import jakarta.persistence.*;
import lombok.Data;

/**
 * 治疗用药信息
 * 记录患者所用药物的名称、剂量及使用频率。
 */
@Entity
@Table(name = "edr_medication_info")
@Data
@EqualsAndHashCode(callSuper = true)
public class EdrMedicationInfo extends BaseEntity {

    private String mpiId;                   // 主索引 ID
    private String drugCode;                // 通用药物代码
    private String drugDoseCode;           // 药物使用次剂量
    private String drugDosageCode;         // 药物剂型代码
    private String drugFrequency;           // 每日用药次数
    private String drugDosageRouteCode;   // 服药方法代码
    private String drugGivenQuantity;      // 药物使用总剂量
    private String drugBeginDate;          // 开始服药日期
    private String drugEndDate;            // 结束服药日期
    private String createOrg;               // 创建机构
    private String updateOrg;               // 修改机构
    private String createUser;              // 创建人
    private String createTime;              // 创建时间
    private String updateUser;              // 修改人
    private String updateTime;              // 修改时间
    private Long patientId;               // 个人主状态信息 ID
    private String treatmentId;             // 治疗用药主表 ID

}
