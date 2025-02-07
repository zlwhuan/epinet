package com.clzk.epinet.edr.model;

import com.clzk.epinet.base.model.BaseEntity;
import lombok.EqualsAndHashCode;
import jakarta.persistence.*;
import lombok.Data;

/**
 * 死亡登记信息
 * 记录患者的死亡时间、死亡原因等信息。
 */
@Entity
@Table(name = "edr_death_info")
@Data
@EqualsAndHashCode(callSuper = true)
public class EdrDeathInfo extends BaseEntity {
    private String mpiId;                  // 主索引 ID
    private String deadDate;               // 死亡日期时间
    private String directCauseCode;       // 直接死亡原因编码（ICD10 代码）
    private String deathReasonTypeCode;  // 根本死因编码（ICD10 代码）
    private String deathReasonDetailCode; // 间接死因编码（ICD10 代码）
    private String deathInfoSourceCode;  // 死亡诊断编码（传染病诊断 ICD10 代码）
    private String createOrg;              // 创建机构
    private String updateOrg;              // 修改机构
    private String createUser;             // 创建人
    private String createTime;             // 创建时间
    private String updateUser;             // 修改人
    private String updateTime;             // 修改时间
    private Long patientId;              // 个人主状态信息 ID
}
