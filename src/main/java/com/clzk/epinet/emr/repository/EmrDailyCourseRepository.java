package com.clzk.epinet.emr.repository;

import com.clzk.epinet.base.repository.BaseRepository;
import com.clzk.epinet.emr.model.EmrDailyCourse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmrDailyCourseRepository  extends BaseRepository<EmrDailyCourse> {
    List<EmrDailyCourse> findAllByPatientId(Long patientId);
}
