package com.roborm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roborm.model.Insurance;
import com.roborm.repository.InsuranceRepository;

@RestController
@RequestMapping("/api/insurance")
public class InsuranceController {
	
	@Autowired
	private InsuranceRepository insuranceRepository;
	
	@GetMapping("/insurance")
    public List<Insurance> getAllInsurance()
    {
		return insuranceRepository.findAll();
    }

	@PostMapping("/add")
    public Insurance createFinInst(@Valid @RequestBody Insurance ins) {
        return insuranceRepository.save(ins);
    }
	
	@GetMapping("/getUserInsurance/{id}")
    public ResponseEntity<List<Insurance>> getFinInstById(@PathVariable(value = "id") Long userId) 
    {
		
		return ResponseEntity.ok().body(insuranceRepository.findByUserId(userId)); 
		
    }
}
