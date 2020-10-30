package com.roborm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roborm.model.SavingAndDeposits;

@Repository
public interface SavingAndDepositsRepository extends JpaRepository<SavingAndDeposits, Long>{

}
