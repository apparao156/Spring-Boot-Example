package com.demoapp.spring.boot.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.demoapp.spring.boot.example.entity.Department;
import com.demoapp.spring.boot.example.repository.DepartmentReposirtory;

@SpringBootTest
class DepartmentSerivceTest {

	@Autowired
	private DepartmentService departmentSerice;
	
	@MockBean
	private DepartmentReposirtory departmentRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		
		Department department = Department.builder()
								.departmentName("IT")
								.departmentAddress("Hyderabad")
								.departmentCode("IT-01")
								.departmentId(1L)
								.build();
		
		Mockito.when(departmentRepository.findBydepartmentNameIgnoreCase("IT"))
		         						 .thenReturn(department);
	}							

	/* Service Latesr Testing */ 
	@Test	
	@DisplayName("Get Data based on Valid Department Name")
	public void whenValidDepartName_thenDepartmentSHouldFound() {
		String departmentName = "IT";
		Department found = departmentSerice.fetchDepartmentByName(departmentName);		
		
		assertEquals(departmentName, found.getDepartmentName());
	}
	
}
