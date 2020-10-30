package com.roborm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roborm.model.Liability;

@Repository
public interface LiabilityRepository extends JpaRepository<Liability, Long> {

}
