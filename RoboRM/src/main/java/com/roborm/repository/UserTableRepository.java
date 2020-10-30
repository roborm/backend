package com.roborm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roborm.model.UserTable;

@Repository
public interface UserTableRepository extends JpaRepository<UserTable, Long>{

}
