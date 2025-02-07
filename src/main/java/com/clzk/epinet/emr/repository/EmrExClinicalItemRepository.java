package com.clzk.epinet.emr.repository;

import com.clzk.epinet.base.repository.BaseRepository;
import com.clzk.epinet.emr.model.EmrExClinicalItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmrExClinicalItemRepository  extends BaseRepository<EmrExClinicalItem> {
    List<EmrExClinicalItem> findEmrExClinicalItemByExClinicalId(Long exClinicalId);
}
