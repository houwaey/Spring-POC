package com.local.springjdbc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.local.springjdbc.dto.request.NewStudent;
import com.local.springjdbc.dto.request.UpdateStudent;

@SpringBootTest
@AutoConfigureMockMvc
public class TestSchoolController {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void test_addNewStudent() throws Exception {
		this.mockMvc
			.perform(post("/school/student")
				.content(asJsonString(new NewStudent("A-001", "Paulo Marquez")))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isCreated());
	}
	
	@Test
	public void test_updateStudent() throws Exception {
		this.mockMvc
			.perform(put("/school/student")
				.content(asJsonString(new UpdateStudent(4, "John Doe")))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}
	
	@Test
	public void test_deleteStudent() throws Exception {
		this.mockMvc
			.perform(delete("/school/student/{id}", 5)
				.contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isGone());
	}
	
	@Test
	public void test_findStudentById() throws Exception {
		this.mockMvc
			.perform(get("/school/student/{id}", 5)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isFound());
	}
	
	@Test
	public void test_findAllStudents() throws Exception {
		this.mockMvc
			.perform(get("/school/students"))
			.andDo(print())
			.andExpect(status().isFound());
	}
	
	private String asJsonString(final Object object) {
		try {
			return new ObjectMapper().writeValueAsString(object);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}