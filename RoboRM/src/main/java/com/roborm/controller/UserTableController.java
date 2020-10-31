package com.roborm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roborm.exception.ResourceNotFoundException;
import com.roborm.manager.UserTableManager;
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

	@PostMapping("/add")
	public UserTable createUserTable(@Valid @RequestBody UserTable userTable) {
		return userTableRepository.save(userTable);
	}

	@PutMapping("/update")
	public ResponseEntity<UserTable> updateUserPasswordByUserName(@Valid @RequestBody UserTable newUserTable)
			throws ResourceNotFoundException {
		UserTableManager userTable = new UserTableManager(userTableRepository);
		return ResponseEntity.ok().body(userTable.UpdateUserPasswordByUserName(newUserTable));
	}

}
