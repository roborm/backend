package com.roborm.manager;

import java.util.List;

import org.springframework.stereotype.Service;

import com.roborm.exception.ResourceNotFoundException;
import com.roborm.model.FinInst;
import com.roborm.repository.FinInstRepository;

@Service
public class FinInstManager {
	private FinInstRepository finInstRepository;
	
	public FinInstManager(FinInstRepository finInstRepository)
	{
		this.finInstRepository = finInstRepository;
	}
	
	public List<FinInst> findAll()
	{
		return finInstRepository.findAll();
	}
	
	public String findById(Long id) throws ResourceNotFoundException
	{
		FinInst fi = finInstRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
		return fi.getFinInstName();
	}
	
	public FinInst UpdateNameandTypeById(Long id, FinInst newFI) throws ResourceNotFoundException
	{
		FinInst fi = finInstRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
		fi.setFinInstName(newFI.getFinInstName());
		fi.setFinInstType(newFI.getFinInstType());
		
		final FinInst updateFinInst = finInstRepository.save(fi);
		return updateFinInst;
	}
	
}
