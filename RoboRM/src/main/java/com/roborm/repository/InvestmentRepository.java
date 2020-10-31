package com.roborm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roborm.model.Investment;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment, Long> {
	
	List<Investment> findByUserId(Long userId);

}
