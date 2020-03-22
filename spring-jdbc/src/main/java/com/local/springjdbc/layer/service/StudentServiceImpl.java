package com.local.springjdbc.layer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.local.springjdbc.dto.Student;
import com.local.springjdbc.exception.DaoException;
import com.local.springjdbc.exception.InternalServerException;
import com.local.springjdbc.exception.NoAffectedRowsException;
import com.local.springjdbc.exception.NoRecordFoundException;
import com.local.springjdbc.exception.NotFoundException;
import com.local.springjdbc.layer.dao.StudentDao;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao daoStudent;
	
	@Override
	public boolean addStudent(final String studentId, final String name) throws DaoException, InternalServerException {
		try {
			int result = this.daoStudent.insert(studentId, name);
			if (result <= 0) {
				throw new NoAffectedRowsException("No affected row(s)");
			}
			return true;
		} catch (DataAccessException e) {
			throw new InternalServerException("Database connection failure");
		}
	}
	
	@Override
	public boolean updateStudent(final long id, final String name) throws DaoException, InternalServerException {
		try {
			int result = this.daoStudent.update(id, name);
			if (result <= 0) {
				throw new NoAffectedRowsException("No affected row(s)");
			}
			return true;
		} catch (DataAccessException e) {
			throw new InternalServerException("Database connection failure");
		}
	}

	@Override
	public boolean deleteStudent(final long id) throws DaoException, InternalServerException {
		try {
			int result = this.daoStudent.delete(id);
			if (result <= 0) {
				throw new NoAffectedRowsException("No affected row(s)");
			}
			return true;
		} catch (DataAccessException e) {
			throw new InternalServerException("Database connection failure");
		}
	}

	@Override
	public Student findStudentById(final long id) throws DaoException, InternalServerException {
		try {
			Student student = this.daoStudent.findOne(id);
			if (student == null) {
				throw new NotFoundException("Student not found");
			}
			return student;
		} catch (DataAccessException e) {
			throw new InternalServerException("Database connection failure");
		}
	}

	@Override
	public List<Student> findAllStudents() throws DaoException, InternalServerException {
		try {
			List<Student> students = this.daoStudent.findAll();
			if (students == null || students.size() <= 0) {
				throw new NoRecordFoundException("No student's record(s) found");
			}
			return students;
		} catch (DataAccessException e) {
			throw new InternalServerException("Database connection failure");
		}
	}

}
