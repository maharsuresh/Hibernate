package com.athena.boot.repository;




import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.athena.boot.JpaHibernateSpringbootApplication;
import com.athena.boot.entity.Course;

@SpringBootTest(classes =JpaHibernateSpringbootApplication.class )
@RunWith(SpringRunner.class)
public class CourseRepositoryTest {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	 CourseRepository repository;
	
	
	
	@Test
	public void ContextLoad() {
		logger.info(":::::::::ContextLoad start :::::::::");
	}
	
	@Test
	public void findByIdTest() {
		Course course = repository.findById(10001L);
		logger.info("course-> {} ",course );
		assertEquals(10001L, course.getId());
		
		
	}
	
	@Test
	@DirtiesContext
	public void deleteById() {
		repository.deleteById(10002L);
		assertNull(repository.findById(10002L));
	}
	
	@Test
	@DirtiesContext
	public void save() {
		Course course = repository.findById(10001L);
		assertEquals("Hibernate 5.0.0", course.getName());
		
		course.setName("Hibernate 5.0.4");
		
		repository.save(course);
		
		Course course1 = repository.findById(10001L);
		assertEquals("Hibernate 5.0.4", course1.getName());
	}

}
