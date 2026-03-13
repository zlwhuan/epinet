package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;
import java.util.List;


/**
 * 患者基本信息 - 记录患者的基本信息
 */
@Entity
@Table(name = "EMR_PATIENT_INFO")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmrPatientInfo extends BaseEntity {

    @Id
    @Column(name = "ID", length = 80)
    private String id;

    @Column(name = "PATIENT_NAME", length = 100)
    private String patientName; // 患者姓名
    @Column(name = "ID_CARD_TYPE_CODE", length = 2)
    private String idCardTypeCode; // 身份证件类别代码
    @Column(name = "ID_CARD_TYPE_NAME", length = 20)
    private String idCardTypeName; // 身份证件类别名称
    @Column(name = "ID_CARD", length = 50)
    private String idCard; // 身份证件号码
    @Column(name = "GENDER_CODE", length = 2)
    private String genderCode; // 性别代码 // 性别代码
//    @Column(name = "GENDER_NAME", length = 10)
    @Transient // 性别名称可以通过代码转换获得，不需要存储在数据库中
    private String genderName; // 性别名称
    @Column(name = "BIRTH_DATE")
    private String birthDate; // 出生日期
    @Column(name = "NATIONALITY_CODE", length = 5)
    private String nationalityCode; // 国籍代码
    @Column(name = "NATIONALITY_NAME", length = 50)
    private String nationalityName; // 国籍名称
    @Column(name = "NATION_CODE", length = 2)
    private String nationCode; // 民族代码
    @Column(name = "NATION_NAME", length = 50)
    private String nationName; // 民族名称
    @Column(name = "PERMANENT_ADDR_CODE", length = 9)
    private String permanentAddrCode; // 户籍地区编码
    @Column(name = "PERMANENT_ADDR_NAME", length = 100)
    private String permanentAddrName; // 户籍地址名称
    @Column(name = "PERMANENT_ADDR_DETAIL", length = 250)
    private String permanentAddrDetail; // 户籍详细地址
    @Column(name = "CURRENT_ADDR_CODE", length = 9)
    private String currentAddrCode; // 现住地址代码
    @Column(name = "CURRENT_ADDR_NAME", length = 100)
    private String currentAddrName; // 现住地址名称
    @Column(name = "CURRENT_ADDR_DETAIL", length = 250)
    private String currentAddrDetail; // 现住详细地址
    @Column(name = "WORKUNIT", length = 250)
    private String workUnit; // 工作单位
    @Column(name = "MARITAL_STATUS_CODE", length = 2)
    private String maritalStatusCode; // 婚姻状况代码
    @Column(name = "MARITAL_STATUS_NAME", length = 20)
    private String maritalStatusName; // 婚姻状况名称
    @Column(name = "EDUCATION_CODE", length = 2)
    private String educationCode; // 文化程度代码
    @Column(name = "EDUCATION_NAME", length = 20)
    private String educationName; // 文化程度名称
    @Column(name = "NULTITUDE_TYPE_CODE", length = 2)
    private String nultitudeTypeCode; // 人群分类代码
    @Column(name = "NULTITUDE_TYPE_NAME", length = 20)
    private String nultitudeTypeName; // 人群分类名称
    @Column(name = "NULTITUDE_TYPE_OTHER", length = 100)
    private String nultitudeTypeOther; // 人群分类其他
    @Column(name = "TEL", length = 70)
    private String tel; // 电话号码
    @Column(name = "CONTACTS", length = 100)
    private String contacts; // 联系人姓名
    @Column(name = "CONTACTS_TEL", length = 70)
    private String contactsTel; // 联系人电话
    @Column(name = "ORG_CODE", length = 9)
    private String orgCode; // 医疗机构代码
    @Column(name = "ORG_NAME", length = 100)
    private String orgName; // 医疗机构名称
    @Column(name = "OPERATOR_ID", length = 40)
    private String operatorId; // 操作人 ID
    @Column(name = "OPERATION_TIME", length = 50)
    private Timestamp operationTime; // 操作时间

//
//    @Transient
//    private List<EmrActivityInfo> activityList; // 患者诊疗活动信息
//
//    @Transient
//    private List<EmrAdmissionInfo> admissionList; // 患者入院记录信息
//
//    @Transient
//    private List<EmrAdmissionRecord> admissionRecordList; // 住院病案首页信息
//
//    @Transient
//    private List<EmrDailyCourse> dailyCourseList; // 患者日常病程记录信息
//
//    @Transient
//    private List<EmrDeathInfo> deathList; // 患者死亡记录信息
//
//    @Transient
//    private List<EmrDischargeInfo> dischargeList; // 患者出院记录信息
//
//    @Transient
//    private List<EmrExClinical> exClinicalList; // 患者检查信息
//
//    @Transient
//    private List<EmrExLab> exLabList; // 患者检验信息
//
//    @Transient
//    private List<EmrFirstCourse> firstCourseList; // 患者首次病程记录信息
//
//    @Transient
//    private List<EmrInfReport> infReportList; // 患者传染病报告信息
//
//    @Transient
//    private List<EmrOrder> orderList; // 患者医嘱信息
//
//    @Transient
//    private List<EmrOutpatientObs> outpatientObsList; // 患者门诊检查信息
//
//    @Transient
//    private List<EmrOutpatientRecord> outpatientRecordList; // 患者门诊记录信息
//
//    @Transient
//    private List<EmrVitalSignsRecord> vitalSignsRecordList; // 患者生命体征信息
}
