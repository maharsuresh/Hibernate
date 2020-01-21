package com.athena.boot.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.athena.boot.JpaHibernateSpringbootApplication;
import com.athena.boot.entity.Course;

@RunWith(value = SpringRunner.class)
@SpringBootTest(classes = JpaHibernateSpringbootApplication.class)
public class NativeQueryTest {
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	EntityManager em;
	
	@Test
	public void nativeQuery() {
		
		Query createNativeQuery = em.createNativeQuery("select * from course",Course.class);
		@SuppressWarnings("unchecked")
		List<Course> resultList = createNativeQuery.getResultList();
		logger.info("result: {} ",resultList);
	}
	
	@Test
	public void NativeQueryId() {
		
		Query createNativeQuery = em.createNativeQuery("select * from course where id=?",Course.class);
		createNativeQuery.setParameter(1, 10001L);
		@SuppressWarnings("unchecked")
		List<Course> resultList = createNativeQuery.getResultList();
		logger.info("Based  on Result Id:10001L -> {} ",resultList);
	}
	
	@Test
	public void NativeQueryNamedParameter() {
		
		Query createNativeQuery = em.createNativeQuery("select * from course where id=:id",Course.class);
		createNativeQuery.setParameter("id", 10002L);
		@SuppressWarnings("unchecked")
		List<Course> resultList = createNativeQuery.getResultList();
		logger.info("id with named parameter id: 10002L -> {} ",resultList);
		
	}
	
	
	
	

}
