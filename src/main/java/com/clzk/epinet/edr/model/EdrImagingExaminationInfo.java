package com.clzk.epinet.edr.model;

import com.clzk.epinet.base.model.BaseEntity;
import lombok.EqualsAndHashCode;
import jakarta.persistence.*;
import lombok.Data;

/**
 * 影像学检查信息
 * 记录患者的影像检查类型、检查结果及检查日期。
 */
@Entity
@Table(name = "edr_imaging_exam")
@Data
@EqualsAndHashCode(callSuper = true)
public class EdrImagingExaminationInfo extends BaseEntity {
    private String mpiId;                 // 主索引 ID
    private String activityTime;          // 就诊日期时间
    private String timestamp;              // 报告日期
    private String examinationItemCode;  // 检查项目代码
    private String examinationItemDes;   // 检查项目描述
    private String orgCode;               // 检查机构代码
    private String month;                  // 月序
    private String createOrg;             // 创建机构
    private String updateOrg;             // 修改机构
    private String createUser;            // 创建人
    private String createTime;            // 创建时间
    private String updateUser;            // 修改人
    private String updateTime;            // 修改时间
    private Long patientId;             // 个人主状态信息 ID
}
