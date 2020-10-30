package com.roborm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roborm.model.UserTable;
import com.roborm.repository.UserTableRepository;

@RestController
@RequestMapping("/api/usertable")
public class UserTableController {
	
	@Autowired
	private UserTableRepository userTableRepository;
	
	@GetMapping("/usertable")
    public List<UserTable> getAllUserTable() {
        return userTableRepository.findAll();
    }
	
}
