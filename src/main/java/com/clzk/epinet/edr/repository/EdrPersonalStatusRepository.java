package com.clzk.epinet.edr.repository;

import com.clzk.epinet.base.repository.BaseRepository;
import com.clzk.epinet.edr.model.EdrExamination;
import com.clzk.epinet.edr.model.EdrPersonalStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EdrPersonalStatusRepository extends BaseRepository<EdrPersonalStatus> {
    List<EdrPersonalStatus> findAllByMpiId(String mpiId);
}
