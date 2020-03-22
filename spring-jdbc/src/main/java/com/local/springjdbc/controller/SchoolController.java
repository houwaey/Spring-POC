package com.local.springjdbc.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.local.springjdbc.dto.Student;
import com.local.springjdbc.dto.request.NewStudent;
import com.local.springjdbc.dto.request.UpdateStudent;

public interface SchoolController {

	public ResponseEntity<Void> addNewStudent(NewStudent student);
	
	public ResponseEntity<Void> updateStudent(UpdateStudent student);
	
	public ResponseEntity<Void> deleteStudent(long id);
	
	public ResponseEntity<Student> findStudentById(long id);
	
	public ResponseEntity<List<Student>> findAllStudents();
	
}
