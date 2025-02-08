package com.clzk.epinet.edr.repository;

import com.clzk.epinet.base.repository.BaseRepository;
import com.clzk.epinet.edr.model.EdrPersonalMasterData;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EdrPersonalMasterDataRepository extends BaseRepository<EdrPersonalMasterData> {
    List<EdrPersonalMasterData> findAllByIdCard(String idCard);

}
