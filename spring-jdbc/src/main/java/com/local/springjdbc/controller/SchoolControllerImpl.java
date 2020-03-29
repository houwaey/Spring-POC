package com.local.springjdbc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.local.springjdbc.dto.Student;
import com.local.springjdbc.dto.request.NewStudent;
import com.local.springjdbc.dto.request.UpdateStudent;
import com.local.springjdbc.dto.response.ApiResponse;
import com.local.springjdbc.layer.service.StudentService;

@RequestMapping("/school")
@RestController
public class SchoolControllerImpl implements SchoolController {

	@Autowired
	private StudentService serviceStudent;
	
	@PostMapping("/student")
	@Override
	public ResponseEntity<?> addNewStudent(@Valid @RequestBody final NewStudent student) {
		this.serviceStudent.addStudent(student.getStudentId(), student.getName());
		return new ResponseEntity<ApiResponse<?>>(
				new ApiResponse<Void>(HttpStatus.CREATED)
				, HttpStatus.CREATED);
	}
	
	@PostMapping("/students")
	@Override
	public ResponseEntity<?> addNewStudents(@RequestBody final List<NewStudent> students) {
		this.serviceStudent.addStudents(students);
		return new ResponseEntity<ApiResponse<?>>(
				new ApiResponse<Void>(HttpStatus.CREATED)
				, HttpStatus.CREATED);
	}

	@PutMapping("/student")
	@Override
	public ResponseEntity<?> updateStudent(@RequestBody final UpdateStudent student) {
		this.serviceStudent.updateStudent(student.getId(), student.getName());
		return new ResponseEntity<ApiResponse<?>>(
				new ApiResponse<Void>(HttpStatus.OK)
				, HttpStatus.OK);
	}

	@DeleteMapping("/student/id/{id}")
	@Override
	public ResponseEntity<?> deleteStudentById(@PathVariable final long id) {
		this.serviceStudent.deleteStudentById(id);
		return new ResponseEntity<ApiResponse<?>>(
				new ApiResponse<Void>(HttpStatus.OK)
				, HttpStatus.OK);
	}
	
	@DeleteMapping("/student/student-id/{studentId}")
	@Override
	public ResponseEntity<?> deleteStudentByStudentId(@PathVariable String studentId) {
		this.serviceStudent.deleteStudentByStudentId(studentId);
		return new ResponseEntity<ApiResponse<?>>(
				new ApiResponse<Void>(HttpStatus.OK)
				, HttpStatus.OK);
	}
	
	@GetMapping("/student/id/{id}")
	@Override
	public ResponseEntity<?> findStudentById(@PathVariable final long id) {
		Student student = this.serviceStudent.findStudentById(id);
		return new ResponseEntity<ApiResponse<Student>>(
				new ApiResponse<Student>(student, HttpStatus.OK)
				, HttpStatus.OK);
	} 
	
	@GetMapping("/student/student-id/{studentId}")
	@Override
	public ResponseEntity<?> findStudentByStudentId(@PathVariable String studentId) {
		Student student = this.serviceStudent.findStudentByStudentId(studentId);
		return new ResponseEntity<ApiResponse<Student>>(
				new ApiResponse<Student>(student, HttpStatus.OK)
				, HttpStatus.OK);
	}

	@GetMapping("/students")
	@Override
	public ResponseEntity<?> findAllStudents() {
		List<Student> students = this.serviceStudent.findAllStudents();
		return new ResponseEntity<ApiResponse<List<Student>>>(
				new ApiResponse<List<Student>>(students, HttpStatus.OK)
				, HttpStatus.OK);
	}

}
