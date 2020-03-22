package com.local.springjdbc.layer.service;

import java.util.List;

import com.local.springjdbc.dto.Student;
import com.local.springjdbc.exception.DaoException;
import com.local.springjdbc.exception.InternalServerException;

public interface StudentService {

	public boolean addStudent(final String studentId, final String name) throws DaoException, InternalServerException;
	
	public boolean updateStudent(final long id, final String name) throws DaoException, InternalServerException;
	
	public boolean deleteStudent(final long id) throws DaoException, InternalServerException;
	
	public Student findStudentById(final long id) throws DaoException, InternalServerException;
	
	public List<Student> findAllStudents() throws DaoException, InternalServerException;
	
}
