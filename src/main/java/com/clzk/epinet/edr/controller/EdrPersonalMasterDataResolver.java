package com.clzk.epinet.edr.controller;

import com.clzk.epinet.edr.model.*;
import com.clzk.epinet.edr.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Slf4j
public class EdrPersonalMasterDataResolver {

    @QueryMapping
    public List<EdrPersonalMasterData> getEdrPatientInfo(@Argument String idCard) {
        return personalMasterDataRepository.findAllByIdCard(idCard);
    }

    @SchemaMapping(typeName = "EdrPersonalMasterData", field = "confirmedDiagnosisList")
    public List<EdrConfirmedDiagnosis> getConfirmedDiagnosisList(EdrPersonalMasterData personalMasterData) {
        return confirmedDiagnosisRepository.findAllByPatientId(personalMasterData.getId());
    }

    @SchemaMapping(typeName = "EdrPersonalMasterData", field = "deathList")
    public List<EdrDeath> getDeathList(EdrPersonalMasterData personalMasterData) {
        return deathRepository.findAllByPatientId(personalMasterData.getId());
    }

    @SchemaMapping(typeName = "EdrPersonalMasterData", field = "examinationList")
    public List<EdrExamination> getExaminationList(EdrPersonalMasterData personalMasterData) {
        return examinationRepository.findAllByPatientId(personalMasterData.getId());
    }

    @SchemaMapping(typeName = "EdrPersonalMasterData", field = "exposureHistoryList")
    public List<EdrExposureHistory> getExposureHistoryList(EdrPersonalMasterData personalMasterData) {
        return exposureHistoryRepository.findAllByPatientId(personalMasterData.getId());
    }

    @SchemaMapping(typeName = "EdrPersonalMasterData", field = "hospitalizationList")
    public List<EdrHospitalization> getHospitalizationList(EdrPersonalMasterData personalMasterData) {
        return hospitalizationRepository.findAllByPatientId(personalMasterData.getId());
    }

    @SchemaMapping(typeName = "EdrPersonalMasterData", field = "imagingExaminationList")
    public List<EdrImagingExamination> getImagingExaminationList(EdrPersonalMasterData personalMasterData) {
        return imagingExamRepository.findAllByPatientId(personalMasterData.getId());
    }

    @SchemaMapping(typeName = "EdrPersonalMasterData", field = "laboratoryTestingList")
    public List<EdrLaboratoryTesting> getLaboratoryTestingList(EdrPersonalMasterData personalMasterData) {
        return laboratoryTestingRepository.findAllByPatientId(personalMasterData.getId());
    }

    @SchemaMapping(typeName = "EdrPersonalMasterData", field = "medicationList")
    public List<EdrMedication> getMedicationList(EdrPersonalMasterData personalMasterData) {
        return medicationRepository.findAllByPatientId(personalMasterData.getId());
    }

    @SchemaMapping(typeName = "EdrPersonalMasterData", field = "personalStatusList")
    public List<EdrPersonalStatus> getPersonalStatusList(EdrPersonalMasterData personalMasterData) {
        return personalStatusRepository.findAllByMpiId(personalMasterData.getMpiId());
    }

    @SchemaMapping(typeName = "EdrPersonalMasterData", field = "primaryDiagnosisList")
    public List<EdrPrimaryDiagnosis> getPrimaryDiagnosisList(EdrPersonalMasterData personalMasterData) {
        return primaryDiagnosisRepository.findAllByPatientId(personalMasterData.getId());
    }

    @SchemaMapping(typeName = "EdrPersonalMasterData", field = "symptomList")
    public List<EdrSymptom> getSymptomList(EdrPersonalMasterData personalMasterData) {
        return symptomRepository.findAllByPatientId(personalMasterData.getId());
    }

    @SchemaMapping(typeName = "EdrPersonalMasterData", field = "treatmentList")
    public List<EdrTreatment> getTreatmentList(EdrPersonalMasterData personalMasterData) {
        return treatmentRepository.findAllByPatientId(personalMasterData.getId());
    }

    @SchemaMapping(typeName = "EdrPersonalMasterData", field = "travelHistoryList")
    public List<EdrTravelHistory> getTravelHistoryList(EdrPersonalMasterData personalMasterData) {
        return travelHistoryRepository.findAllByPatientId(personalMasterData.getId());
    }

    @Autowired
    private EdrPersonalMasterDataRepository personalMasterDataRepository;
    @Autowired
    private EdrConfirmedDiagnosisRepository confirmedDiagnosisRepository;
    @Autowired
    private EdrDeathRepository deathRepository;
    @Autowired
    private EdrExaminationRepository examinationRepository;
    @Autowired
    private EdrExposureHistoryRepository exposureHistoryRepository;
    @Autowired
    private EdrHospitalizationRepository hospitalizationRepository;
    @Autowired
    private EdrImagingExamRepository imagingExamRepository;
    @Autowired
    private EdrLaboratoryTestingRepository laboratoryTestingRepository;
    @Autowired
    private EdrMedicationRepository medicationRepository;
    @Autowired
    private EdrPersonalStatusRepository personalStatusRepository;
    @Autowired
    private EdrPrimaryDiagnosisRepository primaryDiagnosisRepository;
    @Autowired
    private EdrSymptomRepository symptomRepository;
    @Autowired
    private EdrTreatmentRepository treatmentRepository;
    @Autowired
    private EdrTravelHistoryRepository travelHistoryRepository;

}
