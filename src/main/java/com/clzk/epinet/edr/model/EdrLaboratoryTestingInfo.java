package com.clzk.epinet.edr.model;

import com.clzk.epinet.base.model.BaseEntity;
import lombok.EqualsAndHashCode;
import jakarta.persistence.*;
import lombok.Data;

/**
 * 实验室检测信息
 * 记录患者的实验室检测类型、结果及检测日期。
 */
@Entity
@Table(name = "edr_laboratory_testing_info")
@Data
@EqualsAndHashCode(callSuper = true)
public class EdrLaboratoryTestingInfo extends BaseEntity {
    private String mpiId;                          // 主索引 ID
    private String examinationItemCode;          // 检验项目代码
    private String specimenNo;                    // 检验标本号
    private String specimenCategory;              // 标本类别代码
    private String specimenSamplingDate;         // 标本采样日期时间
    private String specimenReceivingDate;        // 接收标本日期时间
    private String examinationDate;               // 检测日期
    private String examinationMethodCode;        // 检测方法类别代码
    private String sourceExaminationResultCode; // 检验定性结果代码
    private String examinationQuantification;     // 检验定量结果
    private String examinationQuantificationUnit;// 检验定量结果计量单位
    private String examinationQuantificationUpper; // 检验定量结果参考区间-上限
    private String examinationQuantificationLower; // 检验定量结果参考区间-下限
    private String examinationQuantificationRi;  // 检验定量结果超出或低于参考值
    private String examinationReportDate;        // 检测报告日期
    private String month;                          // 月序
    private String confirmStatusCode;            // 确诊状态
    private String createOrg;                     // 创建机构
    private String updateOrg;                     // 修改机构
    private String createUser;                    // 创建人
    private String createTime;                    // 创建时间
    private String updateUser;                    // 修改人
    private String updateTime;                    // 修改时间
    private String patientId;                     // 个人主状态信息 ID
}
