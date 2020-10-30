package com.roborm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roborm.model.FinInst;

@Repository
public interface FinInstRepository extends JpaRepository<FinInst, Long>{

}
