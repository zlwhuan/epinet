package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import lombok.EqualsAndHashCode;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * 传染病报告卡 - 记录传染病报告信息
 */
@Entity
@Table(name = "emr_inf_report")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmrInfReport extends BaseEntity {

    @Column(length = 50)
    private Long patientId; // 患者基本信息 ID
    @Column(length = 50)
    private String serialNumber; // 就诊流水号
    @Column(length = 20)
    private String activityTypeCode; // 诊疗活动类型代码
    @Column(length = 100)
    private String activityTypeName; // 诊疗活动类型名称
    @Column(length = 100)
    private String patientName; // 患者姓名
    @Column(length = 50)
    private String idCardTypeCode; // 身份证件类别代码
    @Column(length = 100)
    private String idCardTypeName; // 身份证件类别名称
    @Column(length = 18)
    private String idCard; // 身份证件号码
    @Column(length = 10)
    private String genderCode; // 性别代码
    @Column(length = 20)
    private String genderName; // 性别名称
    @Column(length = 20)
    private String birthDate; // 出生日期
    @Column(length = 20)
    private String nationalityCode; // 国籍代码
    @Column(length = 100)
    private String nationalityName; // 国籍名称
    @Column(length = 20)
    private String nationCode; // 民族代码
    @Column(length = 100)
    private String nationName; // 民族名称
    @Column(length = 20)
    private String permanentAddrCode; // 户籍地区编码
    @Column(length = 100)
    private String permanentAddrName; // 户籍地区名称
    @Column(length = 100)
    private String permanentAddrDetail; // 户籍详细地址
    @Column(length = 20)
    private String currentAddrCode; // 现住地址代码
    @Column(length = 100)
    private String currentAddrName; // 现住地址名称
    @Column(length = 100)
    private String currentAddrDetail; // 现住详细地址
    @Column(length = 20)
    private String workUnit; // 工作单位
    @Column(length = 20)
    private String maritalStatusCode; // 婚姻状况代码
    @Column(length = 100)
    private String maritalStatusName; // 婚姻状况名称
    @Column(length = 20)
    private String educationCode; // 文化程度代码
    @Column(length = 100)
    private String educationName; // 文化程度名称
    @Column(length = 20)
    private String nultitudeTypeCode; // 人群分类代码
    @Column(length = 100)
    private String nultitudeTypeName; // 人群分类名称
    @Column(length = 100)
    private String nultitudeTypeOther; // 人群分类其它
    @Column(length = 20)
    private String tel; // 电话号码
    @Column(length = 20)
    private String contacts; // 联系人姓名
    @Column(length = 20)
    private String contactsTel; // 联系人电话
    @Column(length = 20)
    private String onsetDate; // 发病日期
    @Column(length = 20)
    private String diagnoseTime; // 诊断时间
    @Column(length = 20)
    private String diseaseCode; // 疾病诊断代码
    @Column(length = 100)
    private String diseaseName; // 疾病诊断名称
    @Column(length = 100)
    private String diseaseOther; // 其他疾病或病毒分型
    @Column(length = 20)
    private String diagnoseStateCode; // 病例分类代码
    @Column(length = 100)
    private String diagnoseStateName; // 病例分类名称
    @Column(length = 20)
    private String caseTypeCode; // 诊断状态代码
    @Column(length = 100)
    private String caseTypeName; // 诊断状态名称
    @Column(length = 20)
    private String deadDate; // 死亡日期
    @Column(length = 20)
    private String isDeadByThisCode; // 死亡是否与此病有关代码
    @Column(length = 100)
    private String isDeadByThisName; // 死亡是否与此病有关名称
    @Column(length = 20)
    private String symptomsCode; // 直接死亡诊断编码
    @Column(length = 100)
    private String symptomsName; // 直接死亡诊断名称
    @Column(length = 20)
    private String laboratoryDetectionVerdictCode; // 实验室检测结论代码
    @Column(length = 100)
    private String laboratoryDetectionVerdictName; // 实验室检测结论名称
    @Column(length = 20)
    private String detectionPositiveDate; // 检测阳性日期
    @Column(length = 20)
    private String detectionOrgCode; // 检测单位
    @Column(length = 100)
    private String dtDiagnose; // 实验室确诊日期
    @Column(length = 20)
    private String afpAreatype1Code; // 病人所属地类型代码
    @Column(length = 100)
    private String afpAreatype1Name; // 病人所属地类型名称
    @Column(length = 20)
    private String afpPalsyDate; // 麻痹日期
    @Column(length = 20)
    private String afpDoctorDate; // 就诊日期
    @Column(length = 20)
    private String afpAreatype2Code; // 就诊地址类型代码
    @Column(length = 100)
    private String afpAreatype2Name; // 就诊地址类型名称
    @Column(length = 20)
    private String afpAddrcodeCode; // 就诊地址编码
    @Column(length = 100)
    private String afpAddrcodeName; // 就诊地址名称
    @Column(length = 100)
    private String afpAddr; // 就诊地址
    @Column(length = 20)
    private String afpPalsySymptom; // 麻痹症状
    @Column(length = 20)
    private String reportDate; // 报告日期
    @Column(length = 20)
    private String discoveryModeCode; // 发现方式代码
    @Column(length = 100)
    private String discoveryModeName; // 发现方式名称
    @Column(length = 100)
    private String discoveryModeOther; // 发现方式其他
    @Column(length = 20)
    private String venerealDisCode; // 性病史代码
    @Column(length = 100)
    private String venerealDisName; // 性病史名称
    @Column(length = 100)
    private String bsTransmissionCode; // 感染途径代码
    @Column(length = 100)
    private String bsTransmissionName; // 感染途径名称
    @Column(length = 100)
    private String bsTransmissionOther; // 感染途径其他
    @Column(length = 20)
    private String contactTypeCode; // 接触方式代码
    @Column(length = 100)
    private String contactTypeName; // 接触方式名称
    @Column(length = 100)
    private String injectCount; // 注射毒品史与病人共用过注射器的人数
    @Column(length = 100)
    private String nonwebCount; // 非婚异性性接触史与病人有非婚性行为的人数
    @Column(length = 100)
    private String smCount; // 男男性行为史发生同性性行为的人数
    @Column(length = 100)
    private String contactOther; // 接触史其他
    @Column(length = 20)
    private String sinfectCode; // 生殖道沙眼衣原体感染代码
    @Column(length = 100)
    private String sinfectName; // 生殖道沙眼衣原体感染名称
    @Column(length = 20)
    private String severityCode; // 是否重症代码
    @Column(length = 100)
    private String severityName; // 是否重症名称
    @Column(length = 20)
    private String labResultCode; // 手足口病实验室结果代码
    @Column(length = 100)
    private String labResultName; // 手足口病实验室结果名称
    @Column(length = 20)
    private String hbsagCode; // 乙肝 HBsAg 阳性时间代码
    @Column(length = 100)
    private String hbsagName; // 乙肝 HBsAg 阳性时间名称
    @Column(length = 20)
    private String hbsagFirst; // 首次出现乙肝症状和体征时间
    @Column(length = 20)
    private String hbsagBuxiang; // 无症状/不详
    @Column(length = 20)
    private String hbsagAlt; // 乙肝本次 ALT
    @Column(length = 20)
    private String resultCode; // 抗-HBcIgM1：1000 检测结果代码 TODO???
    @Column(length = 100)
    private String hbcigResultName; // 抗-HBcIgM1：1000 检测结果名称
    @Column(length = 20)
    private String hbliverPunctureCode; // 肝穿结果（急慢性）代码
    @Column(length = 100)
    private String hbliverPunctureName; // 肝穿结果（急慢性）名称
    @Column(length = 20)
    private String hbsagChangeCode; // 恢复期血清 HBsAg 阴转，抗 HBs 阳转
    @Column(length = 100)
    private String hbsagChangeName; // 恢复期血清 HBsAg 阴转，抗 HBs 阳转
    @Column(length = 20)
    private String contactflagCode; // 密切接触者有无同症状代码
    @Column(length = 100)
    private String contactflagName; // 密切接触者有无同症状名称
    @Column(length = 20)
    private String fillDoctor; // 填卡医生
    @Column(length = 20)
    private String notes; // 备注
    @Column(length = 20)
    private String ncvSeverityCode; // 新冠临床严重程度代码
    @Column(length = 100)
    private String ncvSeverityName; // 新冠临床严重程度名称
    @Column(length = 20)
    private String foreignTypeCode; // 输入病例类型代码
    @Column(length = 100)
    private String foreignTypeName; // 输入病例类型名称
    @Column(length = 20)
    private String placeCode; // 输入来源地代码
    @Column(length = 100)
    private String placeName; // 输入来源地名称
    @Column(length = 20)
    private String reportZoneCode; // 报告地区代码
    @Column(length = 100)
    private String reportZoneName; // 报告地区名称
    @Column(length = 20)
    private String reportOrgCode; // 报告单位机构代码
    @Column(length = 100)
    private String reportOrgName; // 报告单位机构名称
    @Column(length = 20)
    private String deptCode; // 科室代码
    @Column(length = 100)
    private String deptName; // 科室名称
    @Column(length = 20)
    private String operatorId; // 操作人 ID
    @Column(length = 20)
    private String operationTime; // 操作时间
}
