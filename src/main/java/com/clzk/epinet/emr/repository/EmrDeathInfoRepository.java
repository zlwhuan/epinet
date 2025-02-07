package com.clzk.epinet.emr.repository;

import com.clzk.epinet.base.repository.BaseRepository;
import com.clzk.epinet.emr.model.EmrDeathInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmrDeathInfoRepository  extends BaseRepository<EmrDeathInfo> {
    List<EmrDeathInfo> findAllByPatientId(Long patientId);
}
