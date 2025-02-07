package com.clzk.epinet.edr.model;

import com.clzk.epinet.base.model.BaseEntity;
import lombok.EqualsAndHashCode;
import jakarta.persistence.*;
import lombok.Data;

/**
 * 个人状态信息
 * 记录个人的健康状态、工作单位、药物过敏史等信息。
 */
@Entity
@Table(name = "edr_personal_status")
@Data
@EqualsAndHashCode(callSuper = true)
public class EdrPersonalStatus extends BaseEntity {

    private String mpiId;                 // 主索引 ID
    private String workunit;               // 工作单位
    private String educationCode;         // 文化程度代码
    private String nultitudeTypeCode;    // 人群分类代码
    private String allergyDrug;           // 药物过敏史
    private String diseaseCode;           // 关注病种
    private String diagnoseStateCode;    // 病例分类代码
    private String flowStatusCode;       // 流动状态代码
    private String riskRatingCode;       // 风险分级代码
    private String screeningStatusCode;  // 排查状态代码
    private String createOrg;             // 创建机构
    private String updateOrg;             // 修改机构
    private String createUser;            // 创建人
    private String createTime;            // 创建时间
    private String updateUser;            // 修改人
    private String updateTime;            // 修改时间

}
