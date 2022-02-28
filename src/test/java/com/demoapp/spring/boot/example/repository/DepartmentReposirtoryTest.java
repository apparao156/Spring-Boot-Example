package com.demoapp.spring.boot.example.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.demoapp.spring.boot.example.entity.Department;

@DataJpaTest
class DepartmentReposirtoryTest {

//	@Autowired
//	private DepartmentReposirtory departmentRepository;
//	
//	@Autowired
//	private TestEntityManager entityManager;
//	
//	@BeforeEach
//	void setUp() {
//		
//		Department department = Department.builder()
//								.departmentName("Mechanical Engineering")
//								.departmentCode("ME - 011")
//								.departmentAddress("Delhi")
//								.build();
//		entityManager.persist(department);
//	}
//
//	@Test
//	public void whenFindById_thenReturnDepartment() {
//		
//		Department department = departmentRepository.findById(1L).get();
//		assertEquals(department.getDepartmentName(), "Mechanical Engineering");
//	}

}
