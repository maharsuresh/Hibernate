package com.athena.boot.repository;




import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.athena.boot.JpaHibernateSpringbootApplication;
import com.athena.boot.entity.Passport;
import com.athena.boot.entity.Student;

@SpringBootTest(classes =JpaHibernateSpringbootApplication.class )
@RunWith(SpringRunner.class)
public class StudentRepositoryTest {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	 StudentRepository repository;
	
	@Autowired
	EntityManager em;
	
	
	@Test
	public void ContextLoad() {
		logger.info(":::::::::ContextLoad start :::::::::");
	}
	
	@Test
	@Transactional
	public void retriveStudentPassport() {
		Student student = em.find(Student.class, 20001L);
		logger.info("student-> {} ",student);
		
		logger.info("Passport -> {} ",student.getPassport());
		
	}
	
	@Test
	@Transactional
	public void retrivePassportStudent() {
		Passport passport = em.find(Passport.class, 30001L);
		logger.info("passport-> {} ",passport);
		logger.info("student name -> {} ",passport.getStudent());
	}
	


}
