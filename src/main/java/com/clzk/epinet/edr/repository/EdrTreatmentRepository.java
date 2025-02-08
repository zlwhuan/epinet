package com.clzk.epinet.edr.repository;

import com.clzk.epinet.base.repository.BaseRepository;
import com.clzk.epinet.edr.model.EdrDeath;
import com.clzk.epinet.edr.model.EdrTreatment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EdrTreatmentRepository extends BaseRepository<EdrTreatment> {
    List<EdrTreatment> findAllByPatientId(Long patientId);
}
