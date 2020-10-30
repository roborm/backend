package com.roborm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roborm.model.Investment;
import com.roborm.repository.InvestmentRepository;

@RestController
@RequestMapping("/api/investment")
public class InvestmentController {

	@Autowired
	private InvestmentRepository investmentRepository;

	@GetMapping("/investment")
	public List<Investment> getAllInvestment() {
		return investmentRepository.findAll();
	}
}