
package com.local.springjdbc.layer.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.local.springjdbc.dto.Student;
import com.local.springjdbc.dto.request.NewStudent;
import com.local.springjdbc.exception.DaoException;
import com.local.springjdbc.exception.NoAffectedRowsException;
import com.local.springjdbc.exception.NoRecordFoundException;
import com.local.springjdbc.exception.NotFoundException;
import com.local.springjdbc.layer.dao.mapper.StudentRowMapper;
import com.local.springjdbc.util.Message;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insert(final String studentId, final String name) {
		try {
			return this.jdbcTemplate.update("INSERT INTO student(studentid, name) VALUES(?, ?)", studentId, name);
		} catch (DataIntegrityViolationException e) {
			throw new NoAffectedRowsException(Message.NO_AFFECTED_ROWS, e.getMessage());
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
	@Override
	public int[] batchInsert(List<NewStudent> students) {
		try {
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
		} catch (DataIntegrityViolationException e) {
			throw new NoAffectedRowsException(Message.NO_AFFECTED_ROWS, e.getMessage());
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
	@Override
	public int update(final long id, final String name) {
		try {
			int count = 0;
			count = this.jdbcTemplate.update("UPDATE student SET name=? WHERE id=?", name, id);
			if (count == 0) {
				throw new NoAffectedRowsException();
			}
			return count;
		} catch (NoAffectedRowsException e) {
			throw e;
		} catch (DataIntegrityViolationException e) {
			throw new NoAffectedRowsException(Message.NO_AFFECTED_ROWS, e.getMessage());
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public int deleteById(final long id) {
		try {
			return this.jdbcTemplate.update("DELETE FROM student WHERE id=?", id);
		} catch (DataIntegrityViolationException e) {
			throw new NoAffectedRowsException(Message.NO_AFFECTED_ROWS, e.getMessage());
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
	@Override
	public int deleteByStudentId(String studentId) {
		try {
			int count = 0;
			count = this.jdbcTemplate.update("DELETE FROM student WHERE studentid=?", studentId);
			if (count == 0) {
				throw new NoAffectedRowsException();
			}
			return count;
		} catch (NoAffectedRowsException e) {
			throw e;
		} catch (DataIntegrityViolationException e) {
			throw new NoAffectedRowsException(Message.NO_AFFECTED_ROWS, e.getMessage());
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public Student findOneById(final long id) {
		try {
			return this.jdbcTemplate.queryForObject(
					"SELECT * FROM student WHERE id=?"
					, new Object[] {id}
					, new StudentRowMapper());
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException(HttpStatus.NOT_FOUND, Message.STUDENT_NOT_FOUND, e.getMessage());
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
	@Override
	public Student findOneByStudentId(String studentId) {
		try {
			return this.jdbcTemplate.queryForObject(
					"SELECT * FROM student WHERE studentid=?"
					, new Object[] {studentId}
					, new StudentRowMapper());
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException(HttpStatus.NOT_FOUND, Message.STUDENT_NOT_FOUND, e.getMessage());
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public List<Student> findAll() {
		try {
			List<Student> students =  this.jdbcTemplate.query(
					"SELECT * FROM student ORDER BY datecreated DESC"
					, new StudentRowMapper());
			if (students.size() <= 0) {
				throw new NoRecordFoundException(HttpStatus.NOT_FOUND, Message.STUDENTS_NOT_FOUND, Message.NO_RECORD_FOUND.value());
			}
			return students;
		} catch (DaoException e) {
			throw e;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

}
