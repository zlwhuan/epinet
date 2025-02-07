package com.clzk.epinet.emr.controller;

import com.clzk.epinet.emr.model.EmrActivityInfo;
import com.clzk.epinet.emr.model.EmrPatientInfo;
import com.clzk.epinet.emr.repository.EmrActivityInfoRepository;
import com.clzk.epinet.emr.repository.EmrPatientInfoRepository;
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

    @Autowired
    private EmrPatientInfoRepository patientRepository;

    @Autowired
    private EmrActivityInfoRepository activityInfoRepository;

    @QueryMapping
    public List<EmrPatientInfo> getPatientInfo(@Argument String idCard) {
        return patientRepository.findEmrPatientInfoByIdCard(idCard);
    }

    @SchemaMapping(typeName = "EmrPatientInfo", field = "activityList")
    public List<EmrActivityInfo> getActivityInfo(EmrActivityInfo emrActivityInfo) {
        return activityInfoRepository.findByPatientId(emrActivityInfo.getPatientId());
    }

    @QueryMapping
    public List<EmrActivityInfo> getActivityList(@Argument Long patientId) {
        return activityInfoRepository.findByPatientId(patientId);
    }

}
