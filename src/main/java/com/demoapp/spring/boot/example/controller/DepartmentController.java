package com.demoapp.spring.boot.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demoapp.spring.boot.example.entity.Department;
import com.demoapp.spring.boot.example.error.DepartmentNotFoundException;
import com.demoapp.spring.boot.example.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		LOGGER.info("Inside saveDepartment of DepartmentController");
		return departmentService.saveDepartment(department); 
	}
	
	@GetMapping("/departmentlist")
	public List<Department> fetchDepartmentList(){
		LOGGER.info("Inside fetchDepartmentList of DepartmentController");
		return departmentService.fetchDepartmentList();
	}
	
	@GetMapping("/departmentid/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
		return departmentService.fetchDepartmentById(departmentId);
	}
	
	@DeleteMapping("/departmentid/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
		departmentService.deleteDepartmentById(departmentId);
		return "Department Deleted Sucessfully";
	}
	
	@PutMapping("/departmentid/{id}")
	public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {
		return departmentService.updateDepartment(departmentId, department);
	}
	
	@GetMapping("/department/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
		return departmentService.fetchDepartmentByName(departmentName);
	}
	
}
