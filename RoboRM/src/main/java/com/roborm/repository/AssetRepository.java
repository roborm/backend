package com.roborm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roborm.model.Asset;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long>{
	 List<Asset> findByUserId(Long userId);
}
