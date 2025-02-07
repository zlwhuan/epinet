package com.clzk.epinet.emr.repository;

import com.clzk.epinet.base.repository.BaseRepository;
import com.clzk.epinet.emr.model.EmrOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmrOrderRepository  extends BaseRepository<EmrOrder> {
    List<EmrOrder> findAllByPatientId(Long patientId);
}
