package com.clzk.epinet.emr.repository;

import com.clzk.epinet.base.repository.BaseRepository;
import com.clzk.epinet.emr.model.EmrOutpatientRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmrOutpatientRecordRepository  extends BaseRepository<EmrOutpatientRecord> {
    List<EmrOutpatientRecord> findAllByPatientId(Long patientId);
}
