package com.clzk.epinet.edr.model;

import com.clzk.epinet.base.model.BaseEntity;
import lombok.EqualsAndHashCode;
import jakarta.persistence.*;
import lombok.Data;

/**
 * 暴露史信息
 * 记录患者是否接触过传染病源或有风险行为。
 */
@Entity
@Table(name = "edr_exposure_history_info")
@Data
@EqualsAndHashCode(callSuper = true)
public class EdrExposureHistory extends BaseEntity {

    private String mpiId;                 // 主索引 ID
    private String contactflagCode;       // 密切接触者有无同症状代码
    private String venerealDisCode;      // 性病史代码
    private String contactTypeCode;      // 接触方式代码
    private String injectCount;           // 与病人共用过注射器的人数
    private String nonwebCount;           // 与病人有非婚性行为的人数
    private String smCount;               // 发生同性性行为的人数
    private String contactObjectCode;    // 接触对象代码
    private String contactTime;           // 接触时间
    private String discoveryModeCode;    // 发现方式代码
    private String createOrg;             // 创建机构
    private String updateOrg;             // 修改机构
    private String createUser;            // 创建人
    private String createTime;            // 创建时间
    private String updateUser;            // 修改人
    private String updateTime;            // 修改时间
    private Long patientId;             // 个人主状态信息 ID
}
