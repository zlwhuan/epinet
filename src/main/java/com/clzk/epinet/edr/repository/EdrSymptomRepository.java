package com.clzk.epinet.edr.repository;

import com.clzk.epinet.base.repository.BaseRepository;
import com.clzk.epinet.edr.model.EdrSymptom;
import com.clzk.epinet.edr.model.EdrTravelHistory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EdrSymptomRepository extends BaseRepository<EdrSymptom> {
    List<EdrSymptom> findAllByPatientId(Long patientId);
}
