package com.clzk.epinet.edr.model;

import com.clzk.epinet.base.model.BaseEntity;
import lombok.EqualsAndHashCode;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * 个人主数据信息
 * 记录个人基本信息，包括姓名、身份证号、性别、出生日期等。
 */
@Entity
@Table(name = "edr_personal_master_data")
@Data
@EqualsAndHashCode(callSuper = true)
public class EdrPersonalMasterData extends BaseEntity {

    private String mpiId;                 // 主索引 ID
    private String patientName;           // 患者姓名
    private String idCard;                // 身份证号
    private String birthDate;             // 出生日期
    private String genderCode;            // 性别代码
    private String nationalityCode;       // 国籍代码
    private String nationCode;            // 民族代码
    private String permanentAddrCode;    // 户籍地区编码
    private String permanentAddrDetail;  // 户籍详细地址
    private String currentAddrCode;      // 现住地址编码
    private String currentAddrDetail;    // 现住详细地址
    private String maritalStatusCode;    // 婚姻状况代码
    private String contactsTel;           // 联系电话
    private String contactsIdCard;       // 监护人身份证号
    private String contacts;               // 联系人/监护人姓名
    private String tempIdCard;           // 临时身份证号
    private String formerName;            // 曾用姓名
    private String createOrg;             // 创建机构
    private String updateOrg;             // 修改机构
    private String createUser;            // 创建人
    private String createTime;            // 创建时间
    private String updateUser;            // 修改人
    private String updateTime;            // 修改时间

    @Transient
    private List<EdrConfirmedDiagnosis> confirmedDiagnosisList; // 确诊结果信息
    @Transient
    private List<EdrDeath> deathList; // 死亡信息
    @Transient
    private List<EdrExamination> examinationList; // 检查信息
    @Transient
    private List<EdrExposureHistory> exposureHistoryList; // 暴露史信息
    @Transient
    private List<EdrHospitalization> hospitalizationList; // 住院信息
    @Transient
    private List<EdrImagingExamination> imagingExaminationList; // 影像检查信息
    @Transient
    private List<EdrLaboratoryTesting> laboratoryTestingList; // 实验室检测信息
    @Transient
    private List<EdrMedication> medicationList; // 用药信息
    @Transient
    private List<EdrPersonalStatus> personalStatusList; // 个人状态信息
    @Transient
    private List<EdrPrimaryDiagnosis> primaryDiagnosisList; // 初步诊断信息
    @Transient
    private List<EdrSymptom> symptomList; // 症状信息
    @Transient
    private List<EdrTreatment> treatmentList; // 治疗信息
    @Transient
    private List<EdrTravelHistory> travelHistoryList; // 出行史信息


}
