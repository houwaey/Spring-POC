package com.local.springjdbc.layer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.springjdbc.dto.Student;
import com.local.springjdbc.dto.request.NewStudent;
import com.local.springjdbc.layer.dao.StudentDao;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao daoStudent;
	
	@Override
	public boolean addStudent(final String studentId, final String name) {
		return this.daoStudent.insert(studentId, name) > 0;
	}
	
	@Override
	public boolean addStudents(List<NewStudent> students) {
		return this.daoStudent.batchInsert(students).length > 0;
	}
	
	@Override
	public boolean updateStudent(final long id, final String name) {
		return this.daoStudent.update(id, name) > 0;
	}

	@Override
	public boolean deleteStudentById(final long id) {
		return this.daoStudent.deleteById(id) > 0;
	}
	
	@Override
	public boolean deleteStudentByStudentId(final String studentId) {
		return this.daoStudent.deleteByStudentId(studentId) > 0;
	}

	@Override
	public Student findStudentById(final long id) {
		return this.daoStudent.findOneById(id);
	}
	
	@Override
	public Student findStudentByStudentId(final String studentId) {
		return this.daoStudent.findOneByStudentId(studentId);
	}

	@Override
	public List<Student> findAllStudents() {
		return this.daoStudent.findAll();
	}

}
