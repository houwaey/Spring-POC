package com.local.springjdbc.layer.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.local.springjdbc.dto.Student;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		
		student.setId(rs.getLong("id"));
		student.setStudentId(rs.getString("studentid"));
		student.setName(rs.getString("name"));
		student.setDateCreated(rs.getDate("datecreated"));
		
		return student;
	}

}
