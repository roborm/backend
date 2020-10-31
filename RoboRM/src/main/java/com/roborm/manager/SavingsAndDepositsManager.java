package com.roborm.manager;

import java.util.List;

import com.roborm.exception.ResourceNotFoundException;
import com.roborm.model.SavingAndDeposits;
import com.roborm.repository.SavingAndDepositsRepository;

public class SavingsAndDepositsManager {
	
	private SavingAndDepositsRepository sadRepo;

	public SavingsAndDepositsManager(SavingAndDepositsRepository sadRepo) {
		
		this.sadRepo = sadRepo;
	}
	
	public List<SavingAndDeposits> findAll()
	{
		return sadRepo.findAll();
	}
	
	public List<SavingAndDeposits> findByUserId(Long userId)
	{
		return sadRepo.findByUserId(userId);
	}
	
	public SavingAndDeposits UpdateById( SavingAndDeposits savingAndDeposits) throws ResourceNotFoundException
	{
		SavingAndDeposits sad = sadRepo.findById(savingAndDeposits.getSavingId())
				.orElseThrow(() -> new ResourceNotFoundException("Saving And Deposits not found for this id :: " + savingAndDeposits.getSavingId()));
		
		sad.setFinInstId(savingAndDeposits.getFinInstId());
		sad.setBalanceAmt(savingAndDeposits.getBalanceAmt());
		sad.setIncome(savingAndDeposits.getIncome());
		sad.setExpense(savingAndDeposits.getExpense());
		
		final SavingAndDeposits updateSAD = sadRepo.save(sad);
		
		return updateSAD;
	
	}
}
