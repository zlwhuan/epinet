package com.clzk.epinet.edr.repository;

import com.clzk.epinet.base.repository.BaseRepository;
import com.clzk.epinet.edr.model.EdrLaboratoryTesting;
import com.clzk.epinet.edr.model.EdrMedication;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EdrLaboratoryTestingRepository extends BaseRepository<EdrLaboratoryTesting> {
    List<EdrLaboratoryTesting> findAllByPatientId(Long patientId);
}
