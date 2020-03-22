
package com.local.springjdbc.layer.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.local.springjdbc.dto.Student;
import com.local.springjdbc.layer.dao.mapper.StudentRowMapper;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insert(final String studentId, final String name) throws DataAccessException {
		return this.jdbcTemplate.update("INSERT INTO student(studentid, name) VALUES(?, ?)", studentId, name);
	}
	
	@Override
	public int update(final long id, final String name) throws DataAccessException {
		return this.jdbcTemplate.update("UPDATE student SET name=? WHERE id=?", name, id);
	}

	@Override
	public int delete(final long id) throws DataAccessException {
		return this.jdbcTemplate.update("DELETE FROM student WHERE id=?", id);
	}

	@Override
	public Student findOne(final long id) throws DataAccessException {
		String query = "SELECT * FROM student WHERE id=?";
		Student student = this.jdbcTemplate.queryForObject(query, new Object[] {id}, new StudentRowMapper());
		return student;
	}

	@Override
	public List<Student> findAll() throws DataAccessException {
		String query = "SELECT * FROM student ORDER BY datecreated DESC";
		List<Student> students = this.jdbcTemplate.query(query, new StudentRowMapper());
		return students;
	}

}
