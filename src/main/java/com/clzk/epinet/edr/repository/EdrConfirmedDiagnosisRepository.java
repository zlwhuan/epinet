package com.clzk.epinet.edr.repository;

import com.clzk.epinet.base.repository.BaseRepository;
import com.clzk.epinet.edr.model.EdrConfirmedDiagnosis;
import com.clzk.epinet.edr.model.EdrDeath;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EdrConfirmedDiagnosisRepository extends BaseRepository<EdrConfirmedDiagnosis> {
    List<EdrConfirmedDiagnosis> findAllByPatientId(Long patientId);
}
