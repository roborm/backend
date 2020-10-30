package com.roborm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.roborm.model.FinInst;
import com.roborm.repository.FinInstRepository;

@Service
public class FinInstService {
	private FinInstRepository finInstRepository;
	
	public FinInstService(FinInstRepository finInstRepository)
	{
		this.finInstRepository = finInstRepository;
	}
	
	public List<FinInst> findAll()
	{
		return finInstRepository.findAll();
	}
	
	public Optional<FinInst> findById(Long id)
	{
		return finInstRepository.findById(id);
	}
	
}
