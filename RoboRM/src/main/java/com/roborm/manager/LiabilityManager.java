package com.roborm.manager;

import java.util.List;

import org.springframework.stereotype.Service;

import com.roborm.exception.ResourceNotFoundException;
import com.roborm.model.Liability;
import com.roborm.repository.LiabilityRepository;

@Service
public class LiabilityManager {
	private LiabilityRepository liabilityRepository;

	public LiabilityManager(LiabilityRepository liabilityRepository) {
		this.liabilityRepository = liabilityRepository;
	}

	public List<Liability> findAll() {
		return liabilityRepository.findAll();
	}

//Find by Liability ID	
	public Long findById(Long id) throws ResourceNotFoundException {
		Liability liability = liabilityRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Liability ID not found for this id :: " + id));
		return liability.getLiabilityId();
	}

//Find by User ID
	public Long findByUserId(Long id) throws ResourceNotFoundException {
		Liability liability = liabilityRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Liability User Id not found for this id :: " + id));
		return liability.getUserId();
	}

//Update userId and Amt by LiabilityId	 	
	public Liability UpdateUserIdAmtById(Long liabilityId, Liability newLiability) throws ResourceNotFoundException {
		Liability liability = liabilityRepository.findById(liabilityId).orElseThrow(
				() -> new ResourceNotFoundException("Liability User Id not found for this id :: " + liabilityId));
		liability.setUserId(newLiability.getUserId());
		liability.setAmt(newLiability.getAmt());

		final Liability updateLiability = liabilityRepository.save(liability);
		return updateLiability;
	}

}
