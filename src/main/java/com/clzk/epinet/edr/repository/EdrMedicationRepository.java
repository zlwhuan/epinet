package com.clzk.epinet.edr.repository;

import com.clzk.epinet.base.repository.BaseRepository;
import com.clzk.epinet.edr.model.EdrMedication;
import com.clzk.epinet.edr.model.EdrTravelHistory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EdrMedicationRepository extends BaseRepository<EdrMedication> {
    List<EdrMedication> findAllByPatientId(Long patientId);
}
