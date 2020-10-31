package com.roborm.manager;

import java.util.List;

import com.roborm.exception.ResourceNotFoundException;
import com.roborm.model.Insurance;
import com.roborm.repository.InsuranceRepository;

public class InsuranceManager {
	
	private InsuranceRepository insRepo;
	
	public InsuranceManager (InsuranceRepository insRepo)
	{
		this.insRepo = insRepo;
	}
	
	public List<Insurance> findAll()
	{
		return insRepo.findAll();
	}
	
	public List<Insurance> findByUserId(Long userId) 
	{
		return insRepo.findByUserId(userId);
	}
}
