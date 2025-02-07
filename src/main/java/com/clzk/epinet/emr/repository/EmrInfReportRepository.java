package com.clzk.epinet.emr.repository;

import com.clzk.epinet.base.repository.BaseRepository;
import com.clzk.epinet.emr.model.EmrInfReport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmrInfReportRepository  extends BaseRepository<EmrInfReport> {
    List<EmrInfReport> findAllByPatientId(Long patientId);
}
