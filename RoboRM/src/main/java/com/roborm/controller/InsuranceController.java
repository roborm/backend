package com.roborm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roborm.exception.ResourceNotFoundException;
import com.roborm.manager.InsuranceManager;
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
	
	@GetMapping("/getUserInsurance")
    public ResponseEntity<List<Insurance>> getInsuranceById(@Valid @RequestBody Insurance ins) 
    {
		
		return ResponseEntity.ok().body(insuranceRepository.findByUserId(ins.getUserId()));
		
    }
	
	@PutMapping("/update")
	public ResponseEntity<Insurance> updateInsuranceById(@Valid @RequestBody Insurance ins) throws ResourceNotFoundException
	{
		InsuranceManager insMgr = new InsuranceManager(insuranceRepository);
		return ResponseEntity.ok().body(insMgr.UpdateById(ins));
	}
	
	@PostMapping("/autoadd")
	public ResponseEntity<Insurance> insertNewInsuranceByCSV(@Valid @RequestBody Insurance ins) throws ResourceNotFoundException
	{
		InsuranceManager insMgr = new InsuranceManager(insuranceRepository);
		return ResponseEntity.ok().body(insMgr.UpdateById(ins));
	}
}
