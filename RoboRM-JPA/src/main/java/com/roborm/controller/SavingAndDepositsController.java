package com.roborm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
