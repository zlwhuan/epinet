package com.clzk.epinet.edr.model;

import com.clzk.epinet.base.model.BaseEntity;
import lombok.EqualsAndHashCode;
import jakarta.persistence.*;
import lombok.Data;

/**
 * 确诊结果信息
 * 记录患者最终确诊的疾病信息及确诊日期。
 */
@Entity
@Table(name = "edr_confirmed_diagnosis")
@Data
@EqualsAndHashCode(callSuper = true)
public class EdrConfirmedDiagnosisInfo extends BaseEntity {
    private String mpiId;                         // 主索引 ID
    private String visitTypeCode;                // 首复诊类型
    private String diagnoseClassificationCode;   // 诊断类别代码
    private String diagnoseStateCode;            // 病例分类代码
    private String diagnoseTime;                  // 诊断日期时间
    private String onsetDate;                     // 发病日期
    private String diseaseCode;                   // 疾病诊断代码
    private String caseTypeCode;                 // 诊断状态代码
    private String ncvSeverityCode;              // 临床严重程度代码
    private String diagnosisOrgCode;             // 诊断地点代码
    private String deptCode;                      // 科室代码
    private String statisticsFlagCode;           // 发病统计标识
    private String syndromeCode;                  // 症候群标签
    private String iliCode;                       // 流感样病例标签
    private String opflag;                         // 确诊状态
    private String createOrg;                     // 创建机构
    private String updateOrg;                     // 修改机构
    private String createUser;                    // 创建人
    private String createTime;                    // 创建时间
    private String updateUser;                    // 修改人
    private String updateTime;                    // 修改时间
    private Long patientId;                     // 个人主状态信息 ID
}
