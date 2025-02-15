package com.clzk.epinet.edr.repository;

import com.clzk.epinet.base.repository.BaseRepository;
import com.clzk.epinet.edr.model.EdrImagingExamination;
import com.clzk.epinet.edr.model.EdrLaboratoryTesting;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EdrImagingExamRepository extends BaseRepository<EdrImagingExamination> {
    List<EdrImagingExamination> findAllByPatientId(Long patientId);
}
