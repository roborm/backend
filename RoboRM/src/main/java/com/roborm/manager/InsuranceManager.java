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
	
	public Insurance UpdateById(Insurance insurance) throws ResourceNotFoundException
	{
		Insurance ins = insRepo.findById(insurance.getInsuranceId()).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + insurance.getInsuranceId()));
		
		ins.setInsuranceType(insurance.getInsuranceType());
		ins.setFinInstId(insurance.getFinInstId());
		ins.setPremiumAmt(insurance.getPremiumAmt());
		ins.setSumAssured(insurance.getSumAssured());
		ins.setHospitalBenefitAmt(insurance.getHospitalBenefitAmt());
		ins.setCoverage(insurance.getCoverage());
		
		final Insurance updateIns = insRepo.save(ins);
		return updateIns;
				
	}
	
	public Insurance autoUpdateByCSVandId(Insurance insurance) throws ResourceNotFoundException
	{
		Insurance ins = insRepo.findById(insurance.getInsuranceId()).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + insurance.getInsuranceId()));
		
		ins.setInsuranceType(insurance.getInsuranceType());
		ins.setFinInstId(insurance.getFinInstId());
		ins.setPremiumAmt(insurance.getPremiumAmt());
		ins.setSumAssured(insurance.getSumAssured());
		ins.setHospitalBenefitAmt(insurance.getHospitalBenefitAmt());
		ins.setCoverage(insurance.getCoverage());
		
		final Insurance updateIns = insRepo.save(ins);
		return updateIns;
				
	}
}
