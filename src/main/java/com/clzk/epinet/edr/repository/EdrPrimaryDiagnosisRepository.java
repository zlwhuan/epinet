package com.clzk.epinet.edr.repository;

import com.clzk.epinet.base.repository.BaseRepository;
import com.clzk.epinet.edr.model.EdrPrimaryDiagnosis;
import com.clzk.epinet.edr.model.EdrSymptom;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EdrPrimaryDiagnosisRepository extends BaseRepository<EdrPrimaryDiagnosis> {
    List<EdrPrimaryDiagnosis> findAllByPatientId(Long patientId);
}
