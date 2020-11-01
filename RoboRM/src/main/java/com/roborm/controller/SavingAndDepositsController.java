package com.roborm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roborm.exception.ResourceNotFoundException;
import com.roborm.manager.SavingsAndDepositsManager;
import com.roborm.model.SavingAndDeposits;
import com.roborm.repository.SavingAndDepositsRepository;

@RestController
@RequestMapping("/api/savinganddeposits")
public class SavingAndDepositsController {

	@Autowired
	private SavingAndDepositsRepository savingAndDepositsRepository;
	
	@GetMapping("/savinganddeposits")
    public List<SavingAndDeposits> getAllSavingAndDeposits()
    {
		return savingAndDepositsRepository.findAll();
    }
	
	@GetMapping("/getUsersad")
	public ResponseEntity<List<SavingAndDeposits>> getSavingAndDepositsById(@Valid @RequestBody SavingAndDeposits sad)
	{
		return ResponseEntity.ok().body(savingAndDepositsRepository.findByUserId(sad.getUserId()));
	}
	
	@PostMapping("/add")
	public SavingAndDeposits addSAD (@Valid @RequestBody SavingAndDeposits sad)
	{
		return savingAndDepositsRepository.save(sad);
	}

	
	@PutMapping("/update")
	public ResponseEntity<SavingAndDeposits> updateSADByID(@Valid @RequestBody SavingAndDeposits sad) throws ResourceNotFoundException
	{
		SavingsAndDepositsManager sadMgr = new SavingsAndDepositsManager(savingAndDepositsRepository);
		return ResponseEntity.ok().body(sadMgr.UpdateById(sad));
	}
	
}
