package com.clzk.epinet.emr.repository;

import com.clzk.epinet.base.repository.BaseRepository;
import com.clzk.epinet.emr.model.EmrExLabItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmrExLabItemRepository  extends BaseRepository<EmrExLabItem> {
    List<EmrExLabItem> findEmrExLabItemByExLabId(Long exLabId);
}
