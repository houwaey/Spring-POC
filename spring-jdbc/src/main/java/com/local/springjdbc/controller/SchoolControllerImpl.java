package com.local.springjdbc.controller;

import java.util.List;

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
import com.local.springjdbc.layer.service.StudentService;

@RequestMapping("/school")
@RestController
public class SchoolControllerImpl implements SchoolController {

	@Autowired
	private StudentService serviceStudent;
	
	@PostMapping("/student")
	@Override
	public ResponseEntity<Void> addNewStudent(@RequestBody final NewStudent student) {
		boolean result = this.serviceStudent.addStudent(student.getStudentId(), student.getName());
		if (result) {
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/students")
	@Override
	public ResponseEntity<Void> addNewStudents(@RequestBody final List<NewStudent> students) {
		boolean result = this.serviceStudent.addStudents(students);
		if (result) {
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/student")
	@Override
	public ResponseEntity<Void> updateStudent(@RequestBody final UpdateStudent student) {
		boolean result = this.serviceStudent.updateStudent(student.getId(), student.getName());
		if (result) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/student/id/{id}")
	@Override
	public ResponseEntity<Void> deleteStudentById(@PathVariable final long id) {
		boolean result = this.serviceStudent.deleteStudentById(id);
		if (result) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/student/student-id/{studentId}")
	@Override
	public ResponseEntity<Void> deleteStudentByStudentId(@PathVariable String studentId) {
		boolean result = this.serviceStudent.deleteStudentByStudentId(studentId);
		if (result) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/student/id/{id}")
	@Override
	public ResponseEntity<Student> findStudentById(@PathVariable final long id) {
		Student student = this.serviceStudent.findStudentById(id);
		if (student != null) {
			return new ResponseEntity<Student>(student, HttpStatus.OK);
		}
		return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/student/student-id/{studentId}")
	@Override
	public ResponseEntity<Student> findStudentByStudentId(@PathVariable String studentId) {
		Student student = this.serviceStudent.findStudentByStudentId(studentId);
		if (student != null) {
			return new ResponseEntity<Student>(student, HttpStatus.OK);
		}
		return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/students")
	@Override
	public ResponseEntity<List<Student>> findAllStudents() {
		List<Student> students = this.serviceStudent.findAllStudents();
		if (students != null && students.size() > 0) {
			return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
		}
		return new ResponseEntity<List<Student>>(HttpStatus.NOT_FOUND);
	}

}
