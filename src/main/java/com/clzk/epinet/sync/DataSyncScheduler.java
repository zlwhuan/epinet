package com.clzk.epinet.sync;

import com.clzk.epinet.edr.model.*;
import com.clzk.epinet.emr.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DataSyncScheduler {

    private final DataSyncService dataSyncService;

    // 维护接口 URL 和 实体类 的映射
    private static final Map<Class<?>, String> API_URL_MAPPING = new HashMap<>();

    static {
        API_URL_MAPPING.put(EdrPersonalMasterData.class, "/api/getPersonalMasterDataInfo");
        API_URL_MAPPING.put(EdrPersonalStatus.class, "/api/getPersonalStatus");
        API_URL_MAPPING.put(EdrDeath.class, "/api/getDeathInfo");
        API_URL_MAPPING.put(EdrPrimaryDiagnosis.class, "/api/getPrimaryDiagnosisInfo");
        API_URL_MAPPING.put(EdrSymptom.class, "/api/getSymptomInfo");
        API_URL_MAPPING.put(EdrExamination.class, "/api/getExaminationInfo");
        API_URL_MAPPING.put(EdrImagingExamination.class, "/api/getImagingExaminationInfo");
        API_URL_MAPPING.put(EdrConfirmedDiagnosis.class, "/api/getConfirmedDiagnosisInfo");
        API_URL_MAPPING.put(EdrTreatment.class, "/api/getTreatmentInfo");
        API_URL_MAPPING.put(EdrMedication.class, "/api/getMedicationInfo");
        API_URL_MAPPING.put(EdrHospitalization.class, "/api/getHospitalizationInfo");
        API_URL_MAPPING.put(EdrLaboratoryTesting.class, "/api/getLaboratoryTestingInfo");
        API_URL_MAPPING.put(EdrExposureHistory.class, "/api/getExposureHistoryInfo");
        API_URL_MAPPING.put(EdrTravelHistory.class, "/api/getTravelHistoryInfo");
        API_URL_MAPPING.put(EmrPatientInfo.class, "/api/getEmrPatientInfo");
        API_URL_MAPPING.put(EmrActivityInfo.class, "/api/getEmrActivityInfo");
        API_URL_MAPPING.put(EmrInfReport.class, "/api/getEmrInfReport");
        API_URL_MAPPING.put(EmrOutpatientRecord.class, "/api/getEmrOutpatientRecord");
        API_URL_MAPPING.put(EmrOutpatientObs.class, "/api/getEmrOutpatientObs");
        API_URL_MAPPING.put(EmrAdmissionInfo.class, "/api/getEmrAdmissionInfo");
        API_URL_MAPPING.put(EmrFirstCourse.class, "/api/getEmrFirstCourse");
        API_URL_MAPPING.put(EmrDailyCourse.class, "/api/getEmrDailyCourse");
        API_URL_MAPPING.put(EmrAdmissionRecord.class, "/api/getEmrAdmissionRecord");
        API_URL_MAPPING.put(EmrDischargeInfo.class, "/api/getEmrDischargeInfo");
        API_URL_MAPPING.put(EmrExClinical.class, "/api/getEmrExClinical");
        API_URL_MAPPING.put(EmrExClinicalItem.class, "/api/getEmrExClinicalItem");
        API_URL_MAPPING.put(EmrExLab.class, "/api/getEmrExLab");
        API_URL_MAPPING.put(EmrExLabItem.class, "/api/getEmrExLabItem");
        API_URL_MAPPING.put(EmrOrder.class, "/api/getEmrOrder");
        API_URL_MAPPING.put(EmrOrderItem.class, "/api/getEmrOrderItem");
        API_URL_MAPPING.put(EmrVitalSignsRecord.class, "/api/getEmrVitalSignsRecord");
        API_URL_MAPPING.put(BaseUser.class, "/api/getBaseUser");
        API_URL_MAPPING.put(BaseDept.class, "/api/getBaseDept");
        API_URL_MAPPING.put(EmrDeathInfo.class, "/api/getEmrDeathInfo");
    }

    @Scheduled(fixedRate = 60000) // 每 60 秒同步所有接口
    public void syncAllData() {
//        log.info("Starting full data synchronization...");

        API_URL_MAPPING.forEach((entityClass, apiUrl) -> {
            try {
                dataSyncService.syncData(entityClass, apiUrl);
            } catch (Exception e) {
//                log.error("Error syncing data for {}: {}", entityClass.getSimpleName(), e.getMessage());
            }
        });

//        log.info("Full data synchronization completed.");
    }
}
