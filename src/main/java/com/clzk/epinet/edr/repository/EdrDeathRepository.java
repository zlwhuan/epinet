package com.clzk.epinet.edr.repository;


import com.clzk.epinet.base.repository.BaseRepository;
import com.clzk.epinet.edr.model.EdrDeath;
import com.clzk.epinet.edr.model.EdrExamination;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EdrDeathRepository extends BaseRepository<EdrDeath> {
    List<EdrDeath> findAllByPatientId(Long patientId);
}
