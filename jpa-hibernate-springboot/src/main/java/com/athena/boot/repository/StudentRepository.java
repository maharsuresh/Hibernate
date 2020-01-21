package com.athena.boot.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.athena.boot.entity.Passport;
import com.athena.boot.entity.Student;

@Repository
@Transactional
public class StudentRepository {
	@Autowired
	EntityManager entityManager;

	public Student findById(Long id) {
		return entityManager.find(Student.class, id);
	}
	
	public void deleteById(Long id) {
		Student student = findById(id);
		entityManager.remove(student);
	}
	
	public Student save(Student student) {
		if(student.getId()!=null) {
			entityManager.persist(student);
		}else {
			entityManager.merge(student);
		}
		return student;
	}
	
	public void saveStudentPassport() {
		Passport passport=new Passport();
		passport.setNumber("IN10006");
		entityManager.persist(passport);
		
		Student student=new Student();
		student.setName("Harsha");
		student.setPassport(passport);
		entityManager.persist(student);
	}
	
}
