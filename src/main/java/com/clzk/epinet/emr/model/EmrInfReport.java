package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

/**
 * 传染病报告卡 - 记录传染病报告信息
 */
@Entity
@Table(name = "emr_inf_report")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmrInfReport extends BaseEntity {

    @Id
    @Column(name = "id", length = 80)
    private String id;

    @Column(name = "patient_id", length = 80)
    private String patientId; // 患者基本信息 ID
    @Column(name = "serial_number", length = 20)
    private String serialNumber; // 就诊流水号
    @Column(name = "activity_type_code",length = 2)
    private String activityTypeCode; // 诊疗活动类型代码
    @Column(name = "activity_type_name", length = 20)
    private String activityTypeName; // 诊疗活动类型名称
    @Column(name = "patient_name", length = 100)
    private String patientName; // 患者姓名
    @Column(name = "id_card_type_code", length = 2)
    private String idCardTypeCode; // 身份证件类别代码
    @Column(name = "id_card_type_name", length = 20)
    private String idCardTypeName; // 身份证件类别名称
    @Column(name = "id_card", length = 50)
    private String idCard; // 身份证件号码
    @Column(name = "gender_code", length = 2)
    private String genderCode; // 性别代码 // 性别代码
    @Column(name = "gender_name", length = 10)
    private String genderName; // 性别名称
    private Timestamp birthDate; // 出生日期
    @Column(name = "nationality_code", length = 5)
    private String nationalityCode; // 国籍代码
    @Column(name = "nationality_name", length = 50)
    private String nationalityName; // 国籍名称
    @Column(name = "nation_code", length = 2)
    private String nationCode; // 民族代码
    @Column(name = "nation_name", length = 50)
    private String nationName; // 民族名称
    @Column(name = "permanent_addr_code", length = 9)
    private String permanentAddrCode; // 户籍地区编码
    @Column(name = "permanent_addr_name", length = 100)
    private String permanentAddrName; // 户籍地区名称
    @Column(name = "permanent_addr_detail", length = 250)
    private String permanentAddrDetail; // 户籍详细地址
    @Column(name = "current_addr_code", length = 9)
    private String currentAddrCode; // 现住地址代码
    @Column(name = "current_addr_name", length = 100)
    private String currentAddrName;// 现住地址名称
    @Column(name = "current_addr_detail", length = 250)
    private String currentAddrDetail; // 现住详细地址
    @Column(name = "work_unit", length = 250)
    private String workUnit; // 工作单位
    @Column(name = "marital_status_code", length = 2)
    private String maritalStatusCode; // 婚姻状况代码
    @Column(name = "marital_status_name", length = 20)
    private String maritalStatusName; // 婚姻状况名称
    @Column(name = "education_code", length = 2)
    private String educationCode; // 文化程度代码
    @Column(name = "education_name", length = 20)
    private String educationName; // 文化程度名称
    @Column(name = "nultitude_type_code", length = 2)
    private String nultitudeTypeCode; // 人群分类代码
    @Column(name = "nultitude_type_name", length = 20)
    private String nultitudeTypeName; // 人群分类名称
    @Column(name = "nultitude_type_other", length = 100)
    private String nultitudeTypeOther; // 人群分类其它
    @Column(name = "tel", length = 70)
    private String tel; // 电话号码
    @Column(name = "contacts", length = 100)
    private String contacts; // 联系人姓名
    @Column(name = "contacts_tel", length = 70)
    private String contactsTel; // 联系人电话
    private Timestamp onsetDate; // 发病日期
    private Timestamp diagnoseTime; // 诊断时间
    @Column(name = "disease_code", length = 50)
    private String diseaseCode;    // 疾病诊断代码
    @Column(name = "disease_name", length = 250)
    private String diseaseName; // 疾病诊断名称
    @Column(name = "disease_other", length = 50)
    private String diseaseOther; // 其他疾病或病毒分型
    @Column(name = "diagnose_state_code", length = 2)
    private String diagnoseStateCode; // 病例分类代码
    @Column(name = "diagnose_state_name", length = 20)
    private String diagnoseStateName; // 病例分类名称
    @Column(name = "case_type_code", length = 2)
    private String caseTypeCode; // 诊断状态代码
    @Column(name = "case_type_name", length = 2)
    private String caseTypeName; // 诊断状态名称
    private Timestamp deadDate; // 死亡日期
    @Column(name = "is_dead_by_this_code", length = 2)
    private String isDeadByThisCode; // 死亡是否与此病有关代码
    @Column(name = "is_dead_by_this_name", length = 5)
    private String isDeadByThisName; // 死亡是否与此病有关名称
    @Column(name = "symptoms_code", length = 50)
    private String symptomsCode; // 直接死亡诊断编码
    @Column(name = "symptoms_name", length = 200)
    private String symptomsName; // 直接死亡诊断名称
    @Column(name = "laboratory_detection_verdict_code", length = 2)
    private String laboratoryDetectionVerdictCode; // 实验室检测结论代码
    @Column(name = "laboratory_detection_verdict_name", length = 40)
    private String laboratoryDetectionVerdictName; // 实验室检测结论名称
    private Timestamp detectionPositiveDate; // 检测阳性日期
    @Column(name = "detection_org_code", length = 80)
    private String detectionOrgCode; // 检测单位
    private Timestamp dtDiagnose; // 实验室确诊日期
    @Column(name = "afp_areatype1_code", length = 2)
    private String afpAreatype1Code; // 病人所属地类型代码
    @Column(name = "afp_areatype1_name", length = 10)
    private String afpAreatype1Name; // 病人所属地类型名称
    private Timestamp afpPalsyDate; // 麻痹日期
    private Timestamp afpDoctorDate; // 就诊日期
    @Column(name = "afp_areatype2_code", length = 2)
    private String afpAreatype2Code; // 就诊地址类型代码
    @Column(name = "afp_areatype2_name", length = 20)
    private String afpAreatype2Name; // 就诊地址类型名称
    @Column(name = "afp_addrcode_code", length = 9)
    private String afpAddrcodeCode; // 就诊地址编码
    @Column(name = "afp_addrcode_name", length = 150)
    private String afpAddrcodeName; // 就诊地址名称
    @Column(name = "afp_addr", length = 200)
    private String afpAddr; // 就诊地址
    @Column(name = "afp_palsy_symptom", length = 200)
    private String afpPalsySymptom; // 麻痹症状
    private Timestamp reportDate; // 报告日期
    @Column(name = "discovery_mode_code", length = 20)
    private String discoveryModeCode; // 发现方式代码
    @Column(name = "discovery_mode_name", length = 50)
    private String discoveryModeName; // 发现方式名称
    @Column(name = "discovery_mode_other", length = 50)
    private String discoveryModeOther; // 发现方式其他
    @Column(name = "venereal_dis_code", length = 2)
    private String venerealDisCode; // 性病史代码
    @Column(name = "venereal_dis_name", length = 50)
    private String venerealDisName; // 性病史名称
    @Column(name = "bs_transmission_code", length = 5)
    private String bsTransmissionCode; // 感染途径代码
    @Column(name = "bs_transmission_name", length = 50)
    private String bsTransmissionName; // 感染途径名称
    @Column(name = "bs_transmission_other", length = 100)
    private String bsTransmissionOther; // 感染途径其他
    @Column(name = "contact_type_code", length = 10)
    private String contactTypeCode; // 接触方式代码
    @Column(name = "contact_type_name", length = 80)
    private String contactTypeName; // 接触方式名称
    @Column(name = "inject_count", length = 5)
    private String injectCount; // 注射毒品史与病人共用过注射器的人数
    @Column(name = "nonweb_count", length = 5)
    private String nonwebCount; // 非婚异性性接触史与病人有非婚性行为的人数
    @Column(name = "sm_count", length = 5)
    private String smCount; // 男男性行为史发生同性性行为的人数
    @Column(name = "contact_other", length = 80)
    private String contactOther; // 接触史其他
    @Column(name = "sinfect_code", length = 5)
    private String sinfectCode; // 生殖道沙眼衣原体感染代码
    @Column(name = "sinfect_name", length = 10)
    private String sinfectName; // 生殖道沙眼衣原体感染名称
    @Column(name = "severity_code", length = 5)
    private String severityCode; // 是否重症代码
    @Column(name = "severity_name", length = 20)
    private String severityName; // 是否重症名称

    @Column(name = "lab_result_code", length = 5)
    private String labResultCode; // 手足口病实验室结果代码

    @Column(name = "lab_result_name", length = 20)
    private String labResultName; // 手足口病实验室结果名称

    @Column(name = "hbsag_code", length = 5)
    private String hbsagCode; // 乙肝 HBsAg 阳性时间代码

    @Column(name = "hbsag_name", length = 20)
    private String hbsagName; // 乙肝 HBsAg 阳性时间名称


    private Timestamp hbsagFirst; // 首次出现乙肝症状和体征时间

    @Column(name = "hbsag_buxiang_code", length = 10)
    private String hbsagBuxiang; // 无症状/不详

    @Column(name = "hbsag_alt", length = 10)
    private String hbsagAlt; // 乙肝本次 ALT

    @Column(name = "hbcig_result_code", length = 10)
    private String hbcigResultCode; // 抗-HBcIgM1：1000 检测结果代码
    @Column(name = "hbcig_result_name", length = 15)
    private String hbcigResultName; // 抗-HBcIgM1：1000 检测结果名称

    @Column(name = "hbliver_puncture_code", length = 10)
    private String hbliverPunctureCode; // 肝穿结果（急慢性）代码
    @Column(name = "hbliver_puncture_name", length = 10)
    private String hbliverPunctureName; // 肝穿结果（急慢性）名称
    @Column(name = "hbsag_change_code", length = 10)
    private String hbsagChangeCode; // 恢复期血清 HBsAg 阴转，抗 HBs 阳转
    @Column(name = "hbsag_change_name", length = 10)
    private String hbsagChangeName; // 恢复期血清 HBsAg 阴转，抗 HBs 阳转
    @Column(name = "contactflag_code", length = 5)
    private String contactflagCode; // 密切接触者有无同症状代码
    @Column(name = "contactflag_name", length = 5)
    private String contactflagName; // 密切接触者有无同症状名称
    @Column(name = "fill_doctor", length = 20)
    private String fillDoctor; // 填卡医生
    @Lob
    @Column(name = "notes")
    private String notes; // 备注
    @Column(name = "ncv_severity_code", length = 2)
    private String ncvSeverityCode; // 新冠临床严重程度代码
    @Column(name = "ncv_severity_name", length = 10)
    private String ncvSeverityName; // 新冠临床严重程度名称

    @Column(name = "foreign_type_code", length = 2)
    private String foreignTypeCode; // 输入病例类型代码
    @Column(name = "foreign_type_name", length = 10)
    private String foreignTypeName; // 输入病例类型名称
    @Column(name = "place_code", length = 12)
    private String placeCode; // 输入来源地代码
    @Column(name = "place_name", length = 50)
    private String placeName; // 输入来源地名称
    @Column(name = "report_zone_code", length = 9)
    private String reportZoneCode; // 报告地区代码
    @Column(name = "report_zone_name", length = 100)
    private String reportZoneName; // 报告地区名称
    @Column(name = "report_org_code", length = 9)
    private String reportOrgCode; // 报告单位机构代码
    @Column(name = "report_org_name", length = 150)
    private String reportOrgName; // 报告单位机构名称
    @Column(name = "dept_name", length = 50)
    private String deptName; // 科室名称
    @Column(name = "dept_code", length = 20)
    private String deptCode; // 科室代码
    @Column(name = "operator_id", length = 40)
    private String operatorId; // 操作人 ID
    private Timestamp operationTime; // 操作时间
}
