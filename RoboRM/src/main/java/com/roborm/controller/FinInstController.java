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
import com.roborm.manager.FinInstManager;
import com.roborm.model.FinInst;
import com.roborm.repository.FinInstRepository;

@RestController
@RequestMapping("/api/fininst")
public class FinInstController {
	
	@Autowired
	private FinInstRepository finInstRepository;
	
	@GetMapping("/fininsts")
    public List<FinInst> getAllFinInst() {
        return finInstRepository.findAll();
    }
	
	@GetMapping("/fininsts/{id}")
    public ResponseEntity<FinInst> getFinInstById(@PathVariable(value = "id") Long finInstId) 
    	throws ResourceNotFoundException{
		FinInst fi = finInstRepository.findById(finInstId)
		          .orElseThrow(() -> new ResourceNotFoundException("FI not found for this id : " + finInstId));
		        return ResponseEntity.ok().body(fi);
    }
	
	@PostMapping("/add")
    public FinInst createFinInst(@Valid @RequestBody FinInst finInst) {
        return finInstRepository.save(finInst);
    }
	
	@PutMapping("/update")
    public ResponseEntity<FinInst> updateBankNameById(@Valid @RequestBody FinInst newFI) throws ResourceNotFoundException {
		FinInstManager fs = new FinInstManager(finInstRepository);
		return ResponseEntity.ok().body(fs.UpdateNameandTypeById(newFI.getFinInstId(), newFI));
	}
}

