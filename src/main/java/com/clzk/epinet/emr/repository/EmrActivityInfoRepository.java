package com.clzk.epinet.emr.repository;

import com.clzk.epinet.base.repository.BaseRepository;
import com.clzk.epinet.emr.model.EmrActivityInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmrActivityInfoRepository extends BaseRepository<EmrActivityInfo> {
    List<EmrActivityInfo> findAllByPatientId(Long patientId);
}
