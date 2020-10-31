package com.roborm.manager;

import java.util.List;

import org.springframework.stereotype.Service;

import com.roborm.exception.ResourceNotFoundException;
import com.roborm.model.Asset;
import com.roborm.model.UserTable;
import com.roborm.repository.UserTableRepository;

@Service
public class UserTableManager {

	private UserTableRepository userTableRepository;

	public UserTableManager(UserTableRepository userTableRepository) {
		this.userTableRepository = userTableRepository;
	}

	public List<UserTable> findAll() {
		return userTableRepository.findAll();
	}

	// Find by userId
	public Long findById(Long id) throws ResourceNotFoundException {
		UserTable userTable = userTableRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User ID not found for this id :: " + id));
		return userTable.getUserId();
	}

	// Find by userName
	public UserTable findByName(String name) throws ResourceNotFoundException {
		UserTable userTable = userTableRepository.findByUserName(name);
		return userTable;
	}

	// Update userPassword by userName
	public UserTable UpdateUserPasswordByUserName(UserTable newUserTable) throws ResourceNotFoundException {
		UserTable userTable = userTableRepository.findByUserName(newUserTable.getUserName());

		userTable.setUserPassword(newUserTable.getUserPassword());

		final UserTable updateUserTable = userTableRepository.save(userTable);
		return updateUserTable;
	}

}
