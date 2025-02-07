package com.clzk.epinet.emr.repository;

import com.clzk.epinet.base.repository.BaseRepository;
import com.clzk.epinet.emr.model.EmrAdmissionRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmrAdmissionRecordRepository extends BaseRepository<EmrAdmissionRecord> {
    List<EmrAdmissionRecord> findAllByPatientId(Long patientId);
}
