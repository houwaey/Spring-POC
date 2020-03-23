package com.local.springjdbc.layer.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.local.springjdbc.dto.Student;

public interface StudentDao {

	public int insert(String studentId, String name) throws DataAccessException;
	
	public int update(long id, String name) throws DataAccessException;
	
	public int deleteById(long id) throws DataAccessException;
	
	public int deleteByStudentId(String studentId) throws DataAccessException;
	
	public Student findOneById(long id) throws DataAccessException;
	
	public Student findOneByStudentId(String studentId) throws DataAccessException;
	
	public List<Student> findAll() throws DataAccessException;
	
}
