package com.roborm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roborm.model.UserTable;

@Repository
public interface UserTableRepository extends JpaRepository<UserTable, Long>{

	List<UserTable> findByUserName(String userName);
	
	
}
