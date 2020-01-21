package com.athena.boot;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.athena.boot.entity.Review;
import com.athena.boot.repository.CourseRepository;
import com.athena.boot.repository.StudentRepository;

@SpringBootApplication
public class JpaHibernateSpringbootApplication implements CommandLineRunner{
	private Logger logger=LoggerFactory.getLogger(JpaHibernateSpringbootApplication.class);
	
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateSpringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Course course = courseRepository.findById(10001L);
		//logger.info("Course for 10001-> {}",course);
		
		//courseRepository.deleteById(10001L);
		
		///courseRepository.save(new Course(".net"));
		
	//	studentRepository.saveStudentPassport();
		
		courseRepository.addReviewWithCourse();
		courseRepository.addReviewWithCourse(10002L,
				Arrays.asList(
						new Review("4", "Ok"),new Review("5", "Awsom"),new Review("1", "Bad"),new Review("3", "Average")));
		
	}

}
