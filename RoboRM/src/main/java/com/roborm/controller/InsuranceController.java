package com.roborm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
