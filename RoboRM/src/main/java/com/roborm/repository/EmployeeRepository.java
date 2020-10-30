package com.roborm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roborm.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}