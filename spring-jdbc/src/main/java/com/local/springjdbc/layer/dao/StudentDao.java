package com.local.springjdbc.layer.dao;

import java.util.List;

import com.local.springjdbc.dto.Student;
import com.local.springjdbc.dto.request.NewStudent;

public interface StudentDao {

	public int insert(String studentId, String name);
	
	public int[] batchInsert(List<NewStudent> students); 
	
	public int update(long id, String name);
	
	public int deleteById(long id);
	
	public int deleteByStudentId(String studentId);
	
	public Student findOneById(long id);
	
	public Student findOneByStudentId(String studentId);
	
	public List<Student> findAll();
	
}
