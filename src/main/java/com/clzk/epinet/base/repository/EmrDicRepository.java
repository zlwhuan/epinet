package com.clzk.epinet.base.repository;

import com.clzk.epinet.base.model.EmrDic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmrDicRepository extends JpaRepository<EmrDic, Long> {

    @Query("SELECT d FROM EmrDic d WHERE d.categoryCode = :categoryCode")
    List<EmrDic> findByCategoryCode(String categoryCode);


    @Query("SELECT d FROM EmrDic d WHERE d.categoryCode = :categoryCode and d.isNew = :isNew order by d.name")
    List<EmrDic> findByCategoryCode(String categoryCode, Boolean isNew);

}
