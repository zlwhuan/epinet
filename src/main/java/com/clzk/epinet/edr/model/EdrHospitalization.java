package com.clzk.epinet.edr.model;

import com.clzk.epinet.base.model.BaseEntity;
import lombok.EqualsAndHashCode;
import jakarta.persistence.*;
import lombok.Data;

/**
 * 出入院信息
 * 记录患者的入院、出院时间及诊断信息。
 */
@Entity
@Table(name = "edr_hospitalization_info")
@Data
@EqualsAndHashCode(callSuper = true)
public class EdrHospitalization extends BaseEntity {
    private String mpiId;                       // 主索引 ID
    private String admissionDate;               // 入院日期
    private String dischargeDate;               // 出院日期
    private String admissionDiagnosisCode;     // 入院传染病诊断编码
    private String dischargeDiagnosisCode;     // 出院诊断编码
    private String diseaseProgressionCode;     // 病情转归代码
    private String createOrg;                   // 创建机构编码
    private String updateOrg;                   // 修改机构编码
    private String createUser;                  // 创建人 ID
    private String createTime;                  // 创建时间
    private String updateUser;                  // 修改人 ID
    private String updateTime;                  // 修改时间
    private Long patientId;                   // 个人主状态信息 ID
}
