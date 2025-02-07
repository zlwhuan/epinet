package com.clzk.epinet.emr.controller;

import com.clzk.epinet.emr.model.*;
import com.clzk.epinet.emr.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Slf4j
public class EmrPatientResolver {

    @QueryMapping
    public List<EmrPatientInfo> getPatientInfo(@Argument String idCard) {
        return patientRepository.findEmrPatientInfoByIdCard(idCard);
    }

    @SchemaMapping(typeName = "EmrPatientInfo", field = "activityList")
    public List<EmrActivityInfo> getActivityInfo(EmrPatientInfo emrPatientInfo) {
        return activityInfoRepository.findAllByPatientId(emrPatientInfo.getId());
    }

    @SchemaMapping(typeName = "EmrPatientInfo", field = "admissionList")
    public List<EmrAdmissionInfo> getAdmissionList(EmrPatientInfo emrPatientInfo) {
        return admissionInfoRepository.findAllByPatientId(emrPatientInfo.getId());
    }

    @SchemaMapping(typeName = "EmrPatientInfo", field = "admissionRecordList")
    public List<EmrAdmissionRecord> getAdmissionRecordList(EmrPatientInfo emrPatientInfo) {
        return admissionRecordRepository.findAllByPatientId(emrPatientInfo.getId());
    }

    @SchemaMapping(typeName = "EmrPatientInfo", field = "dailyCourseList")
    public List<EmrDailyCourse> getDailyCourseList(EmrPatientInfo emrPatientInfo) {
        return dailyCourseRepository.findAllByPatientId(emrPatientInfo.getId());
    }

    @SchemaMapping(typeName = "EmrPatientInfo", field = "deathList")
    public List<EmrDeathInfo> getDeathList(EmrPatientInfo emrPatientInfo) {
        return deathInfoRepository.findAllByPatientId(emrPatientInfo.getId());
    }

    @SchemaMapping(typeName = "EmrPatientInfo", field = "dischargeList")
    public List<EmrDischargeInfo> getDischargeList(EmrPatientInfo emrPatientInfo) {
        return dischargeInfoRepository.findAllByPatientId(emrPatientInfo.getId());
    }

    @SchemaMapping(typeName = "EmrPatientInfo", field = "exClinicalList")
    public List<EmrExClinical> getExClinicalList(EmrPatientInfo emrPatientInfo) {
        return exClinicalRepository.findAllByPatientId(emrPatientInfo.getId());
    }

    @SchemaMapping(typeName = "EmrPatientInfo", field = "exLabList")
    public List<EmrExLab> getExLabList(EmrPatientInfo emrPatientInfo) {
        return exLabRepository.findAllByPatientId(emrPatientInfo.getId());
    }

    @SchemaMapping(typeName = "EmrPatientInfo", field = "firstCourseList")
    public List<EmrFirstCourse> getFirstCourseList(EmrPatientInfo emrPatientInfo) {
        return firstCourseRepository.findAllByPatientId(emrPatientInfo.getId());
    }

    @SchemaMapping(typeName = "EmrPatientInfo", field = "infReportList")
    public List<EmrInfReport> getInfReportList(EmrPatientInfo emrPatientInfo) {
        return infReportRepository.findAllByPatientId(emrPatientInfo.getId());
    }

    @SchemaMapping(typeName = "EmrPatientInfo", field = "orderList")
    public List<EmrOrder> getOrderList(EmrPatientInfo emrPatientInfo) {
        return orderRepository.findAllByPatientId(emrPatientInfo.getId());
    }

    @SchemaMapping(typeName = "EmrPatientInfo", field = "outpatientObsList")
    public List<EmrOutpatientObs> getOutpatientObsList(EmrPatientInfo emrPatientInfo) {
        return outpatientObsRepository.findAllByPatientId(emrPatientInfo.getId());
    }

    @SchemaMapping(typeName = "EmrPatientInfo", field = "outpatientRecordList")
    public List<EmrOutpatientRecord> getOutpatientRecordList(EmrPatientInfo emrPatientInfo) {
        return outpatientRecordRepository.findAllByPatientId(emrPatientInfo.getId());
    }

    @SchemaMapping(typeName = "EmrPatientInfo", field = "vitalSignsRecordList")
    public List<EmrVitalSignsRecord> getVitalSignsRecordList(EmrPatientInfo emrPatientInfo) {
        return vitalSignsRecordRepository.findAllByPatientId(emrPatientInfo.getId());
    }

    @SchemaMapping(typeName = "EmrExClinical", field = "exClinicalItemList")
    public List<EmrExClinicalItem> getExClinicalItemList(EmrExClinical emrExClinical) {
        return emrExClinicalItemRepository.findEmrExClinicalItemByExClinicalId(emrExClinical.getId());
    }

    @SchemaMapping(typeName = "EmrExLab", field = "exLabItemList")
    public List<EmrExLabItem> getExLabItemList(EmrExLab emrExLab) {
        return exLabItemRepository.findEmrExLabItemByExLabId(emrExLab.getId());
    }

    @SchemaMapping(typeName = "EmrOrder", field = "orderItemList")
    public List<EmrOrderItem> getOrderItemList(EmrOrder emrOrder) {
        return orderItemRepository.findEmrOrderItemByOrderId(emrOrder.getId());
    }


//    @QueryMapping
//    public List<EmrActivityInfo> getActivityList(@Argument Long patientId) {
//        return activityInfoRepository.findAllByPatientId(patientId);
//    }

    @Autowired
    private EmrPatientInfoRepository patientRepository;

    @Autowired
    private EmrActivityInfoRepository activityInfoRepository;

    @Autowired
    private EmrAdmissionInfoRepository admissionInfoRepository;

    @Autowired
    private EmrAdmissionRecordRepository admissionRecordRepository;

    @Autowired
    private EmrDailyCourseRepository dailyCourseRepository;

    @Autowired
    private EmrDeathInfoRepository deathInfoRepository;

    @Autowired
    private EmrDischargeInfoRepository dischargeInfoRepository;

    @Autowired
    private EmrExClinicalRepository exClinicalRepository;

    @Autowired
    private EmrExClinicalItemRepository emrExClinicalItemRepository;

    @Autowired
    private EmrExLabRepository exLabRepository;

    @Autowired
    private EmrExLabItemRepository exLabItemRepository;

    @Autowired
    private EmrFirstCourseRepository firstCourseRepository;

    @Autowired
    private EmrInfReportRepository infReportRepository;

    @Autowired
    private EmrOrderRepository orderRepository;

    @Autowired
    private EmrOrderItemRepository orderItemRepository;

    @Autowired
    private EmrOutpatientObsRepository outpatientObsRepository;

    @Autowired
    private EmrOutpatientRecordRepository outpatientRecordRepository;

    @Autowired
    private EmrVitalSignsRecordRepository vitalSignsRecordRepository;

}
