package com.roborm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roborm.model.Insurance;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long>{
	
	

}
