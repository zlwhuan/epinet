package com.clzk.epinet.emr.repository;

import com.clzk.epinet.base.repository.BaseRepository;
import com.clzk.epinet.emr.model.EmrDischargeInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmrDischargeInfoRepository  extends BaseRepository<EmrDischargeInfo> {
    List<EmrDischargeInfo> findAllByPatientId(Long patientId);
}
