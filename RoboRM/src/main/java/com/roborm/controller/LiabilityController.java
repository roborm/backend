package com.roborm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roborm.model.Liability;
import com.roborm.repository.LiabilityRepository;

@RestController
@RequestMapping("/api/liability")
public class LiabilityController {

	@Autowired
	private LiabilityRepository liabilityRepository;
	
	@GetMapping("/fininsts")
    public List<Liability> getAllLiability() {
        return liabilityRepository.findAll();
    }
}
