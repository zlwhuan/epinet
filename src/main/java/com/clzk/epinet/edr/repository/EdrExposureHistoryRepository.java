package com.clzk.epinet.edr.repository;

import com.clzk.epinet.base.repository.BaseRepository;
import com.clzk.epinet.edr.model.EdrExposureHistory;
import com.clzk.epinet.edr.model.EdrHospitalization;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EdrExposureHistoryRepository extends BaseRepository<EdrExposureHistory> {
    List<EdrExposureHistory> findAllByPatientId(Long patientId);
}
