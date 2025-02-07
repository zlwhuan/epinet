package com.clzk.epinet.emr.repository;

import com.clzk.epinet.base.repository.BaseRepository;
import com.clzk.epinet.emr.model.EmrOrderItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmrOrderItemRepository  extends BaseRepository<EmrOrderItem> {
    List<EmrOrderItem> findEmrOrderItemByOrderId(Long orderId);
}
