package com.local.springjdbc.layer.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.local.springjdbc.dto.Student;

public interface StudentDao {

	public int insert(String studentId, String name) throws DataAccessException;
	
	public int update(long id, String name) throws DataAccessException;
	
	public int delete(long id) throws DataAccessException;
	
	public Student findOne(long id) throws DataAccessException;
	
	public List<Student> findAll() throws DataAccessException;
	
}
