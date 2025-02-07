package com.clzk.epinet.emr.repository;

import com.clzk.epinet.base.repository.BaseRepository;
import com.clzk.epinet.emr.model.EmrExLab;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmrExLabRepository  extends BaseRepository<EmrExLab> {
    List<EmrExLab> findAllByPatientId(Long patientId);
}
