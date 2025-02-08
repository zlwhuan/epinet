package com.clzk.epinet.edr.repository;

import com.clzk.epinet.base.repository.BaseRepository;
import com.clzk.epinet.edr.model.EdrExamination;
import com.clzk.epinet.edr.model.EdrExposureHistory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EdrExaminationRepository extends BaseRepository<EdrExamination> {
    List<EdrExamination> findAllByPatientId(Long patientId);
}
