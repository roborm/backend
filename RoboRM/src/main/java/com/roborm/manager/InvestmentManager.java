package com.roborm.manager;

import java.util.List;

import com.roborm.exception.ResourceNotFoundException;
import com.roborm.model.Investment;
import com.roborm.repository.InvestmentRepository;

public class InvestmentManager {
	
	private InvestmentRepository invRepo;

	public InvestmentManager(InvestmentRepository invRepo) {
		this.invRepo = invRepo;
	}
	
	public List<Investment> findAll()
	{
		return invRepo.findAll();
	}
	
	public List<Investment> findByUserId(Long userId)
	{
		return invRepo.findByUserId(userId);
	}
	
	public Investment UpdateById(Investment investment) throws ResourceNotFoundException
	{
		Investment inv = invRepo.findById(investment.getInvestmentId())
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + investment.getInvestmentId()));
		
		inv.setAmt(investment.getAmt());
		
		final Investment updateInv = invRepo.save(inv);
		
		return updateInv;
	}
	
	public Investment AddAmtById(Investment investment) throws ResourceNotFoundException
	{
		Investment inv = invRepo.findById(investment.getInvestmentId())
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + investment.getInvestmentId()));
		
		inv.setAmt(inv.getAmt()+investment.getAmt());
		
		final Investment updateInv = invRepo.save(inv);
		
		return updateInv;
	}

}
