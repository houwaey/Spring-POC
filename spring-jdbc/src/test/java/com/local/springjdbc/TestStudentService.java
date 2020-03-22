package com.local.springjdbc;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.local.springjdbc.dto.Student;
import com.local.springjdbc.layer.service.StudentService;

@SpringBootTest
public class TestStudentService {
	
	@Autowired
	private StudentService serviceStudent;
	
	@Test
	public void helloWorld() {
		System.out.println("Hello World!");
	}
	
	@Test
	public void test_addStudent() {
		boolean result = this.serviceStudent.addStudent("A-001", "John Paulo Marquez");
		System.out.println("Insert Result: " + result);
	}
	
	@Test
	public void test_updateStudent() {
		boolean result = this.serviceStudent.updateStudent(1, "Touiyake Ford");
		System.out.println("Update Result: " + result);
	}
	
	@Test
	public void test_deleteStudent() {
		boolean result = this.serviceStudent.deleteStudent(1);
		System.out.println("Delete Result: " + result);
	}
	
	@Test
	public void test_findStudentById() {
		Student student = this.serviceStudent.findStudentById(1);
		if (student != null) {
			System.out.println(student);
		}
	}
	
	@Test
	public void test_findAllStudents() {
		List<Student> students = this.serviceStudent.findAllStudents();
		if (students.size() > 0) {
			for (Student student : students) {
				System.out.println(student);
			}
		}
	}
	
}
