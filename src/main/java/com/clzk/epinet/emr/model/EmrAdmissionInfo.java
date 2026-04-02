package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

/**
 * 入院记录信息 - 记录患者的入院基本信息
 */
@Entity
@Table(name = "TEST_ADMISSION_INFO")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmrAdmissionInfo extends BaseEntity {

    @Id
    @Column(name = "ID", length = 80, nullable = false)
    private String id;

    @Column(name = "PATIENT_ID", length = 80, nullable = false)
    private String patientId;

    @Column(name = "SERIAL_NUMBER", length = 20, nullable = false)
    private String serialNumber;

    @Column(name = "WARD_NAME", length = 50)
    private String wardName;

    @Column(name = "WARD_NO", length = 10)
    private String wardNo;

    @Column(name = "BED_NO", length = 10)
    private String bedNo;

    @Column(name = "PATIENT_NAME", length = 100, nullable = false)
    private String patientName;

    @Column(name = "ID_CARD_TYPE_CODE", length = 2)
    private String idCardTypeCode;

    @Column(name = "ID_CARD_TYPE_NAME", length = 20)
    private String idCardTypeName;

    @Column(name = "ID_CARD", length = 50)
    private String idCard;

    @Column(name = "ADMISSION_DATE")
    private Timestamp admissionDate;

    @Column(name = "CHIEF_COMPLAINT")
    private String chiefComplaint;

    @Column(name = "PRESENT_ILLNESS_HIS")
    private String presentIllnessHis;

    @Column(name = "HEALTH_STATUS_CODE", length = 2)
    private String healthStatusCode;

    @Column(name = "PAST_ILLNESS_HIS")
    private String pastIllnessHis;

    @Column(name = "INFECTION_CODE", length = 2)
    private String infectionCode;

    @Column(name = "NFECTION_HIS")   // 注意：INSERT 中是 NFECTION_HIS（可能是拼写错误）
    private String infectionHis;

    @Column(name = "VACCINATION_HIS")
    private String vaccinationHis;

    @Column(name = "OPERATION_HIS")
    private String operationHis;

    @Column(name = "BLOOD_TRANSFUSION")
    private String bloodTransfusion;

    @Column(name = "ALLERGY_HIS")
    private String allergyHis;

    @Column(name = "PERSONAL_HIS")
    private String personalHis;

    @Column(name = "MARITAL_HIS")
    private String maritalHis;

    @Column(name = "MENSTRUAL_HIS")
    private String menstrualHis;

    @Column(name = "FAMILY_HIS")
    private String familyHis;

    @Column(name = "PHYSICAL_EXAMINATION")
    private String physicalExamination;

    @Column(name = "SPECIALIZED_EXAMINATION")
    private String specializedExamination;

    @Column(name = "STUDIES_SUMMARY_RESULT")
    private String studiesSummaryResult;

    @Column(name = "OBSERVATION_RESULT")
    private String observationResult;

    @Column(name = "TREATMENT", length = 100)
    private String treatment;

    @Column(name = "WM_INITAL_DIAGNOSIS_CODE", length = 400)
    private String wmInitalDiagnosisCode;

    @Column(name = "WM_INITAL_DIAGNOSIS_NAME", length = 400)
    private String wmInitalDiagnosisName;

    @Column(name = "TCM_INITAL_DIAGNOSIS_CODE", length = 250)
    private String tcmInitalDiagnosisCode;

    @Column(name = "TCM_INITAL_DIAGNOSIS_NAME", length = 250)
    private String tcmInitalDiagnosisName;

    @Column(name = "TCM_INITAL_SYNDROME_CODE", length = 250)
    private String tcmInitalSyndromeCode;

    @Column(name = "TCM_INITAL_SYNDROME_NAME", length = 250)
    private String tcmInitalSyndromeName;

    @Column(name = "INITAL_DIAGNOSIS_DATE")
    private Timestamp initalDiagnosisDate;

    @Column(name = "WM_REVISED_DIAGNOSIS_CODE", length = 400)
    private String wmRevisedDiagnosisCode;

    @Column(name = "WM_REVISED_DIAGNOSIS_NAME", length = 400)
    private String wmRevisedDiagnosisName;

    @Column(name = "TCM_REVISED_DIAGNOSIS_CODE", length = 250)
    private String tcmRevisedDiagnosisCode;

    @Column(name = "TCM_REVISED_DIAGNOSIS_NAME", length = 250)
    private String tcmRevisedDiagnosisName;

    @Column(name = "TCM_REVISED_SYNDROME_CODE", length = 250)
    private String tcmRevisedSyndromeCode;

    @Column(name = "TCM_REVISED_SYNDROME_NAME", length = 250)
    private String tcmRevisedSyndromeName;

    @Column(name = "REVISED_DIAGNOSIS_DATE")
    private Timestamp revisedDiagnosisDate;

    @Column(name = "WM_CONFIRMED_DIAGNOSIS_CODE", length = 400)
    private String wmConfirmedDiagnosisCode;

    @Column(name = "WM_CONFIRMED_DIAGNOSIS_NAME", length = 400)
    private String wmConfirmedDiagnosisName;

    @Column(name = "TCM_CONFIRMED_DIAGNOSIS_CODE", length = 250)
    private String tcmConfirmedDiagnosisCode;

    @Column(name = "TCM_CONFIRMED_DIAGNOSIS_NAME", length = 250)
    private String tcmConfirmedDiagnosisName;

    @Column(name = "TCM_CONFIRMED_SYNDROME_CODE", length = 250)
    private String tcmConfirmedSyndromeCode;

    @Column(name = "TCM_CONFIRMED_SYNDROME_NAME", length = 250)
    private String tcmConfirmedSyndromeName;

    @Column(name = "CONFIRMED_DIAGNOSIS_DATE")
    private Timestamp confirmedDiagnosisDate;

    @Column(name = "COMPLEMENTARY_DIAGNOSIS_CODE", length = 50)
    private String complementaryDiagnosisCode;

    @Column(name = "COMPLEMENTARY_DIAGNOSIS_NAME", length = 250)
    private String complementaryDiagnosisName;

    @Column(name = "COMPLEMENTARY_DIAGNOSIS_DATE")
    private Timestamp complementaryDiagnosisDate;

    @Column(name = "ADMISSION_DIAGNOSIS_ORDER", length = 2)
    private String admissionDiagnosisOrder;

    @Column(name = "VISITING_PHYSICIAN_ID", length = 50)
    private String visitingPhysicianId;

    @Column(name = "RESIDENT_PHYSICIAN_ID", length = 50)
    private String residentPhysicianId;

    @Column(name = "CHIEF_PHYSICIAN_ID", length = 50)
    private String chiefPhysicianId;

    @Column(name = "ORG_CODE", length = 9)
    private String orgCode;

    @Column(name = "ORG_NAME", length = 100)
    private String orgName;

    @Column(name = "DEPT_CODE", length = 20)
    private String deptCode;

    @Column(name = "DEPT_NAME", length = 50)
    private String deptName;

    @Column(name = "OPERATOR_ID", length = 40)
    private String operatorId;

    @Column(name = "OPERATION_TIME", updatable = false)
    private Timestamp operationTime;
}