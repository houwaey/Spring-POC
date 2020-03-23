package com.local.springjdbc.layer.service;

import java.util.List;

import com.local.springjdbc.dto.Student;
import com.local.springjdbc.exception.DaoException;
import com.local.springjdbc.exception.InternalServerException;

public interface StudentService {

	public boolean addStudent(String studentId, String name) throws DaoException, InternalServerException;
	
	public boolean updateStudent(long id, String name) throws DaoException, InternalServerException;
	
	public boolean deleteStudentById(long id) throws DaoException, InternalServerException;
	
	public boolean deleteStudentByStudentId(String studentId) throws DaoException, InternalServerException;
	
	public Student findStudentById(long id) throws DaoException, InternalServerException;
	
	public Student findStudentByStudentId(String studentId) throws DaoException, InternalServerException;
	
	public List<Student> findAllStudents() throws DaoException, InternalServerException;
	
}
