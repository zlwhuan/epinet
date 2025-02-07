package com.clzk.epinet.emr.repository;

import com.clzk.epinet.base.repository.BaseRepository;
import com.clzk.epinet.emr.model.EmrPatientInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmrPatientInfoRepository  extends BaseRepository<EmrPatientInfo> {
    List<EmrPatientInfo> findEmrPatientInfoByIdCard(String idCard);
}
