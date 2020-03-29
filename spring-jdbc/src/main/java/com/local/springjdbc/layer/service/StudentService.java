package com.local.springjdbc.layer.service;

import java.util.List;

import com.local.springjdbc.dto.Student;
import com.local.springjdbc.dto.request.NewStudent;

public interface StudentService {

	public boolean addStudent(String studentId, String name);
	
	public boolean addStudents(List<NewStudent> students);
	
	public boolean updateStudent(long id, String name);
	
	public boolean deleteStudentById(long id);
	
	public boolean deleteStudentByStudentId(String studentId);
	
	public Student findStudentById(long id);
	
	public Student findStudentByStudentId(String studentId);
	
	public List<Student> findAllStudents();
	
}
