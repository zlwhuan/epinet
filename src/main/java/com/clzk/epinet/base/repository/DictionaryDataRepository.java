package com.clzk.epinet.base.repository;

import com.clzk.epinet.base.dto.DictionaryDataDTO;
import com.clzk.epinet.base.model.DictionaryData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DictionaryDataRepository extends JpaRepository<DictionaryData, Long> {

    @Query("SELECT new com.clzk.epinet.base.dto.DictionaryDataDTO(d.code, d.name, d.description) FROM DictionaryData d WHERE d.categoryCode = :categoryCode")
    List<DictionaryDataDTO> findByCategoryCode(@Param("categoryCode") String categoryCode);


}
