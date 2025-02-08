package com.clzk.epinet.edr.repository;

import com.clzk.epinet.base.repository.BaseRepository;
import com.clzk.epinet.edr.model.EdrHospitalization;
import com.clzk.epinet.edr.model.EdrImagingExamination;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EdrHospitalizationRepository extends BaseRepository<EdrHospitalization> {
    List<EdrHospitalization> findAllByPatientId(Long patientId);
}
