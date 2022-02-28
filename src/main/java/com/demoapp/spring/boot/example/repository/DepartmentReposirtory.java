package com.demoapp.spring.boot.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demoapp.spring.boot.example.entity.Department;

@Repository
public interface DepartmentReposirtory extends JpaRepository<Department, Long> {

	public Department findBydepartmentName(String departmentName);
	
	public Department findBydepartmentNameIgnoreCase(String departmentName);
}
