package com.clzk.epinet.emr.repository;

import com.clzk.epinet.base.repository.BaseRepository;
import com.clzk.epinet.emr.model.EmrFirstCourse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmrFirstCourseRepository  extends BaseRepository<EmrFirstCourse> {
    List<EmrFirstCourse> findAllByPatientId(Long patientId);
}
