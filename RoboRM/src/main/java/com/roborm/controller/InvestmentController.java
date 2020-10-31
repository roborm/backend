package com.roborm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roborm.exception.ResourceNotFoundException;
import com.roborm.manager.InvestmentManager;
import com.roborm.model.Investment;
import com.roborm.repository.InvestmentRepository;

@RestController
@RequestMapping("/api/investment")
public class InvestmentController {

	@Autowired
	private InvestmentRepository investmentRepository;
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/investment")
	public List<Investment> getAllInvestment() {
		return investmentRepository.findAll();
	}
	
	@GetMapping("/getUserInvestment")
    public ResponseEntity<List<Investment>> getInvestmentById(@Valid @RequestBody Investment inv) 
    {
		
		return ResponseEntity.ok().body(investmentRepository.findByUserId(inv.getUserId()));
		
    }
	
	@PutMapping("/update")
	public ResponseEntity<Investment> updateInsuranceById(@Valid @RequestBody Investment inv) throws ResourceNotFoundException
	{
		InvestmentManager invMgr = new InvestmentManager(investmentRepository);
		return ResponseEntity.ok().body(invMgr.UpdateById(inv));
	}
}