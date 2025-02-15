package com.clzk.epinet.edr.repository;

import com.clzk.epinet.base.repository.BaseRepository;
import com.clzk.epinet.edr.model.EdrTravelHistory;
import com.clzk.epinet.emr.model.EmrActivityInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EdrTravelHistoryRepository extends BaseRepository<EdrTravelHistory> {
    List<EdrTravelHistory> findAllByPatientId(Long patientId);
}
