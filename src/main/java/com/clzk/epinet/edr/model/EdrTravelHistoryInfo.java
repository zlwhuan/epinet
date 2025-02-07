package com.clzk.epinet.edr.model;

import com.clzk.epinet.base.model.BaseEntity;
import lombok.EqualsAndHashCode;
import jakarta.persistence.*;
import lombok.Data;

/**
 * 旅居史信息
 */
@Entity
@Table(name = "edr_travel_history_info")
@Data
@EqualsAndHashCode(callSuper = true)
public class EdrTravelHistoryInfo extends BaseEntity {
    private String mpiId;                   // 主索引 ID
    private String foreignTypeCode;        // 输入病例类型代码（0.否 1.是）
    private String placeCode;               // 输入来源地代码（国家和地区代码）
    private String residenceDays;           // 发病时在现住址居住时间
    private String epidemicSourceRiskCode;// 疫源风险（0.否 1.是）
    private String createOrg;               // 创建机构
    private String updateOrg;               // 修改机构
    private String createUser;              // 创建人
    private String createTime;              // 创建时间
    private String updateUser;              // 修改人
    private String updateTime;              // 修改时间
    private Long patientId;               // 个人主状态信息 ID
}
