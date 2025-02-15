package com.clzk.epinet.emr.repository;

import com.clzk.epinet.base.repository.BaseRepository;
import com.clzk.epinet.emr.model.EmrExClinical;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmrExClinicalRepository  extends BaseRepository<EmrExClinical> {
    List<EmrExClinical> findAllByPatientId(Long patientId);
}
