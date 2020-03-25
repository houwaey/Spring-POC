package com.local.springjdbc.layer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.local.springjdbc.dto.Student;
import com.local.springjdbc.dto.request.NewStudent;
import com.local.springjdbc.exception.DaoException;
import com.local.springjdbc.exception.InternalServerException;
import com.local.springjdbc.exception.NoAffectedRowsException;
import com.local.springjdbc.exception.NoRecordFoundException;
import com.local.springjdbc.exception.NotFoundException;
import com.local.springjdbc.layer.dao.StudentDao;
import com.local.springjdbc.util.Message;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao daoStudent;
	
	@Override
	public boolean addStudent(final String studentId, final String name) {
		try {
			return this.daoStudent.insert(studentId, name) > 0;
		} catch (DataIntegrityViolationException e) {
			throw new NoAffectedRowsException(Message.NO_AFFECTED_ROWS, e.getMessage());
		} catch (DataAccessException e) {
			throw new DaoException(Message.DAO_EXCEPTION.value(), e);
		} catch (Exception e) {
			throw new InternalServerException(Message.INTERNAL_SERVER_ERROR.value(), e);
		}
	}
	
	@Override
	public boolean addStudents(List<NewStudent> students) {
		try {
			int[] returns = this.daoStudent.batchInsert(students);
			System.out.println("returns: " + returns);
			return true;
		} catch (DataIntegrityViolationException e) {
			throw new NoAffectedRowsException(Message.NO_AFFECTED_ROWS, e.getMessage()); // TODO: handling
		} catch (DataAccessException e) {
			throw new DaoException(Message.DAO_EXCEPTION.value(), e);
		} catch (Exception e) {
			throw new InternalServerException(Message.INTERNAL_SERVER_ERROR.value(), e);
		}
	}
	
	@Override
	public boolean updateStudent(final long id, final String name) {
		try {
			return this.daoStudent.update(id, name) > 0;
		} catch (DataIntegrityViolationException e) {
			throw new NoAffectedRowsException(Message.NO_AFFECTED_ROWS, e.getMessage());
		} catch (DataAccessException e) {
			throw new DaoException(Message.DAO_EXCEPTION.value(), e);
		} catch (Exception e) {
			throw new InternalServerException(Message.INTERNAL_SERVER_ERROR.value(), e);
		}
	}

	@Override
	public boolean deleteStudentById(final long id) {
		try {
			return this.daoStudent.deleteById(id) > 0;
		} catch (DataIntegrityViolationException e) {
			throw new NoAffectedRowsException(Message.NO_AFFECTED_ROWS, e.getMessage());
		} catch (DataAccessException e) {
			throw new DaoException(Message.DAO_EXCEPTION.value(), e);
		} catch (Exception e) {
			throw new InternalServerException(Message.INTERNAL_SERVER_ERROR.value(), e);
		}
	}
	
	@Override
	public boolean deleteStudentByStudentId(final String studentId) {
		try {
			return this.daoStudent.deleteByStudentId(studentId) > 0;
		} catch (DataIntegrityViolationException e) {
			throw new NoAffectedRowsException(Message.NO_AFFECTED_ROWS, e.getMessage());
		} catch (DataAccessException e) {
			throw new DaoException(Message.DAO_EXCEPTION.value(), e);
		} catch (Exception e) {
			throw new InternalServerException(Message.INTERNAL_SERVER_ERROR.value(), e);
		}
	}

	@Override
	public Student findStudentById(final long id) {
		try {
			return this.daoStudent.findOneById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException(HttpStatus.NOT_FOUND, Message.STUDENT_NOT_FOUND, e.getMessage());
		} catch (DataAccessException e) {
			throw new DaoException(Message.DAO_EXCEPTION.value(), e);
		} catch (Exception e) {
			throw new InternalServerException(Message.INTERNAL_SERVER_ERROR.value(), e);
		}
	}
	
	@Override
	public Student findStudentByStudentId(final String studentId) {
		try {
			return this.daoStudent.findOneByStudentId(studentId);
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException(HttpStatus.NOT_FOUND, Message.STUDENT_NOT_FOUND, e.getMessage());
		} catch (DataAccessException e) {
			throw new DaoException(Message.DAO_EXCEPTION, e.getMessage());
		} catch (Exception e) {
			throw new InternalServerException(Message.INTERNAL_SERVER_ERROR.value(), e);
		}
	}

	@Override
	public List<Student> findAllStudents() {
		try {
			return this.daoStudent.findAll();
		} catch (EmptyResultDataAccessException e) {
			throw new NoRecordFoundException(HttpStatus.NOT_FOUND, Message.STUDENTS_NOT_FOUND, e.getMessage());
		} catch (DataAccessException e) {
			throw new DaoException(Message.DAO_EXCEPTION, e.getMessage());
		} catch (Exception e) {
			throw new InternalServerException(Message.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

}
