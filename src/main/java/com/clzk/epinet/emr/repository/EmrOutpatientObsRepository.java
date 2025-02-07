package com.clzk.epinet.emr.repository;

import com.clzk.epinet.base.repository.BaseRepository;
import com.clzk.epinet.emr.model.EmrOutpatientObs;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmrOutpatientObsRepository  extends BaseRepository<EmrOutpatientObs> {
    List<EmrOutpatientObs> findAllByPatientId(Long patientId);
}
