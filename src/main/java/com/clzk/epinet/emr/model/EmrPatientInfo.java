package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


/**
 * 患者基本信息 - 记录患者的基本信息
 */
@Entity
@Table(name = "emr_patient_info")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmrPatientInfo extends BaseEntity {

    private String patientId; // 患者 ID
    private String patientName; // 患者姓名
    private String idCardTypeCode; // 身份证件类别代码
    private String idCardTypeName; // 身份证件类别名称
    private String idCard; // 身份证件号码
    private String genderCode; // 性别代码
    private String genderName; // 性别名称
    private String birthDate; // 出生日期
    private String nationalityCode; // 国籍代码
    private String nationalityName; // 国籍名称
    private String nationCode; // 民族代码
    private String nationName; // 民族名称
    private String permanentAddrCode; // 户籍地区编码
    private String permanentAddrDetail; // 户籍详细地址
    private String currentAddrCode; // 现住地址代码
    private String currentAddrDetail; // 现住详细地址
    private String workunit; // 工作单位
    private String maritalStatusCode; // 婚姻状况代码
    private String maritalStatusName; // 婚姻状况名称
    private String educationCode; // 文化程度代码
    private String educationName; // 文化程度名称
    private String nultitudeTypeCode; // 人群分类代码
    private String nultitudeTypeName; // 人群分类名称
    private String nultitudeTypeOther; // 人群分类其他
    private String tel; // 电话号码
    private String contacts; // 联系人姓名
    private String contactsTel; // 联系人电话
    private String orgCode; // 医疗机构代码
    private String orgName; // 医疗机构名称
    private String operatorId; // 操作人 ID
    private String operationTime; // 操作时间

    @Transient
    private List<EmrActivityInfo> activityList; // 患者诊疗活动信息

    @Transient
    private List<EmrAdmissionInfo> admissionList; // 患者入院记录信息

    @Transient
    private List<EmrAdmissionRecord> admissionRecordList; // 住院病案首页信息

    @Transient
    private List<EmrDailyCourse> dailyCourseList; // 患者日常病程记录信息

    @Transient
    private List<EmrDeathInfo> deathList; // 患者死亡记录信息

    @Transient
    private List<EmrDischargeInfo> dischargeList; // 患者出院记录信息

    @Transient
    private List<EmrExClinical> exClinicalList; // 患者检查信息

    @Transient
    private List<EmrExLab> exLabList; // 患者检验信息

    @Transient
    private List<EmrFirstCourse> firstCourseList; // 患者首次病程记录信息

    @Transient
    private List<EmrInfReport> infReportList; // 患者传染病报告信息

    @Transient
    private List<EmrOrder> orderList; // 患者医嘱信息

    @Transient
    private List<EmrOutpatientObs> outpatientObsList; // 患者门诊检查信息

    @Transient
    private List<EmrOutpatientRecord> outpatientRecordList; // 患者门诊记录信息

    @Transient
    private List<EmrVitalSignsRecord> vitalSignsRecordList; // 患者生命体征信息
}
