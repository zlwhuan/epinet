package com.clzk.epinet.edr.model;

import com.clzk.epinet.base.model.BaseEntity;
import lombok.EqualsAndHashCode;
import jakarta.persistence.*;
import lombok.Data;

/**
 * 症状信息
 * 记录患者的症状表现、严重程度及发生时间。
 */
@Entity
@Table(name = "edr_symptom_info")
@Data
@EqualsAndHashCode(callSuper = true)
public class EdrSymptom extends BaseEntity {
    private String mpiId;                 // 主索引 ID
    private String activityTime;          // 就诊日期时间
    private String currentAddrCode;      // 患者现住址
    private String symptomCode;           // 症状代码
    private String afpPalsyDate;         // 症状出现日期
    private String createOrg;             // 创建机构
    private String updateOrg;             // 修改机构
    private String createUser;            // 创建人
    private String createTime;            // 创建时间
    private String updateUser;            // 修改人
    private String updateTime;            // 修改时间
    private Long patientId;             // 个人主状态信息 ID
}
