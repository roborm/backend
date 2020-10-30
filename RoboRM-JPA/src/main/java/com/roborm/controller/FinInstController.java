package com.roborm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
