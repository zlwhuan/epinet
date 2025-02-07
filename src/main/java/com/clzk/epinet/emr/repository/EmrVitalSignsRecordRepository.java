package com.clzk.epinet.emr.repository;

import com.clzk.epinet.base.repository.BaseRepository;
import com.clzk.epinet.emr.model.EmrVitalSignsRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmrVitalSignsRecordRepository  extends BaseRepository<EmrVitalSignsRecord> {
    List<EmrVitalSignsRecord> findAllByPatientId(Long patientId);
}
