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
import com.roborm.manager.LiabilityManager;
import com.roborm.model.Liability;
import com.roborm.repository.LiabilityRepository;

@RestController
@RequestMapping("/api/liability")
public class LiabilityController {

	@Autowired
	private LiabilityRepository liabilityRepository;
	
	@GetMapping("/")
    public List<Liability> getAllLiability() {
        return liabilityRepository.findAll();
    }
	
	@GetMapping("/liabilities/{id}")
	public ResponseEntity<Liability> getFinInstById(@PathVariable(value = "id") Long liabilityId)
			throws ResourceNotFoundException {
		Liability liability = liabilityRepository.findById(liabilityId)
				.orElseThrow(() -> new ResourceNotFoundException("Asset not found for this id : " + liabilityId));
		return ResponseEntity.ok().body(liability);
	}

	@PostMapping("/add")
	public Liability createLiability(@Valid @RequestBody Liability liability) {
		return liabilityRepository.save(liability);
	}

	@PutMapping("/update")
	public ResponseEntity<Liability> updateLiabilityUserIdById(@Valid @RequestBody Liability newLiability)
			throws ResourceNotFoundException {
		LiabilityManager liability = new LiabilityManager(liabilityRepository);
		return ResponseEntity.ok().body(liability.UpdateUserIdAmtById(newLiability.getLiabilityId(), newLiability));
	}
}
