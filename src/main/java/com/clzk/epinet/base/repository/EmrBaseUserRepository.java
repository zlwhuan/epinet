package com.clzk.epinet.base.repository;

import com.clzk.epinet.base.model.EmrBaseUser;
import com.clzk.epinet.base.model.EmrDic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmrBaseUserRepository extends JpaRepository<EmrBaseUser, Long> {

}
