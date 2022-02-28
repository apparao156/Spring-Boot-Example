package com.demoapp.spring.boot.example.controller;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.demoapp.spring.boot.example.entity.Department;
import com.demoapp.spring.boot.example.error.DepartmentNotFoundException;
import com.demoapp.spring.boot.example.service.DepartmentService;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private DepartmentService departmentService;
	
	private Department department;
	
	@BeforeEach
	void setUp() throws Exception {
		
		department = Department.builder()
					.departmentAddress("Ahmedabad")
					.departmentCode("IT-06")
					.departmentName("IT")
					.departmentId(1L)
					.build();
		
	}

	@Test
	void saveDepartment() throws Exception {

		Department inputdepartment = Department.builder()
					.departmentAddress("Ahmedabad")
					.departmentCode("IT-06")
					.departmentName("IT")
					.departmentId(1L)
					.build();
		
		Mockito.when(departmentService.saveDepartment(inputdepartment))
				.thenReturn(department);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/departments")
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON)
				.content("    {\r\n"
						+ "        \"departmentName\": \"IT\",\r\n"
						+ "        \"departmentAddress\": \"Ahmedabad\",\r\n"
						+ "        \"departmentCode\": \"IT-06\"\r\n"
						+ "    }"))
				.andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	
	@Test
	void fetchDepartmentById() throws DepartmentNotFoundException {
		
//		Mockito.when(departmentService.fetchDepartmentById(1L))
//				.thenReturn(department);
		
//		mockMvc.perform(get("/departmentid/1")
//				.contentType(org.springframework.http.MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk())
//				.andExpect(jsonPath(expression: "$.departmentName")
//						.value(department.getDepartmentName()));
		
	}

}
