package com.clzk.epinet.edr.model;

import com.clzk.epinet.base.model.BaseEntity;
import lombok.EqualsAndHashCode;
import jakarta.persistence.*;
import lombok.Data;

/**
 * 初步诊断信息
 * 记录患者的初步诊断信息，包括诊断时间、疾病代码等。
 */
@Entity
@Table(name = "edr_primary_diagnosis")
@Data
@EqualsAndHashCode(callSuper = true)
public class EdrPrimaryDiagnosis extends BaseEntity {
    private String mpiId;                  // 主索引 ID
    private String activityTime;           // 就诊日期时间
    private String currentAddrCode;       // 患者现住址
    private String initialDiagnosisCode;  // 初步诊断代码
    private String orgCode;                // 诊断机构代码
    private String createOrg;              // 创建机构
    private String updateOrg;              // 修改机构
    private String createUser;             // 创建人
    private String createTime;             // 创建时间
    private String updateUser;             // 修改人
    private String updateTime;             // 修改时间
    private String patientId;              // 个人主状态信息 ID
}
