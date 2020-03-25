
package com.local.springjdbc.layer.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.local.springjdbc.dto.Student;
import com.local.springjdbc.dto.request.NewStudent;
import com.local.springjdbc.layer.dao.mapper.StudentRowMapper;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insert(final String studentId, final String name) {
		return this.jdbcTemplate.update("INSERT INTO student(studentid, name) VALUES(?, ?)", studentId, name);
	}
	
	@Override
	public int[] batchInsert(List<NewStudent> students) {
		return this.jdbcTemplate.batchUpdate("INSERT INTO student(studentid, name) VALUES(?, ?)", 
				new BatchPreparedStatementSetter() {
						@Override
						public void setValues(PreparedStatement ps, int i) throws SQLException {
							ps.setString(1, students.get(i).getStudentId());
							ps.setString(2, students.get(i).getName());
						}
						
						@Override
						public int getBatchSize() {
							return  students.size();
						}
					}
				);
	}
	
	@Override
	public int update(final long id, final String name) {
		return this.jdbcTemplate.update("UPDATE student SET name=? WHERE id=?", name, id);
	}

	@Override
	public int deleteById(final long id) {
		return this.jdbcTemplate.update("DELETE FROM student WHERE id=?", id);
	}
	
	@Override
	public int deleteByStudentId(String studentId) {
		return this.jdbcTemplate.update("DELETE FROM student WHERE studentid=?", studentId);
	}

	@Override
	public Student findOneById(final long id) {
		String query = "SELECT * FROM student WHERE id=?";
		Student student = this.jdbcTemplate.queryForObject(query, new Object[] {id}, new StudentRowMapper());
		return student;
	}
	
	@Override
	public Student findOneByStudentId(String studentId) {
		String query = "SELECT * FROM student WHERE studentid=?";
		Student student = this.jdbcTemplate.queryForObject(query, new Object[] {studentId}, new StudentRowMapper());
		return student;
	}

	@Override
	public List<Student> findAll() {
		String query = "SELECT * FROM student ORDER BY datecreated DESC";
		List<Student> students = this.jdbcTemplate.query(query, new StudentRowMapper());
		return students;
	}

}
