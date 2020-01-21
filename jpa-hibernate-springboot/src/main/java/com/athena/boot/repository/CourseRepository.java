package com.athena.boot.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.athena.boot.entity.Course;
import com.athena.boot.entity.Review;

@Repository
@Transactional
public class CourseRepository {
	private static Logger logger=LoggerFactory.getLogger(CourseRepository.class);
	@Autowired
	EntityManager entityManager;

	public Course findById(Long id) {
		return entityManager.find(Course.class, id);
	}
	
	public void deleteById(Long id) {
		Course course = findById(id);
		entityManager.remove(course);
	}
	
	public Course save(Course course) {
		if(course.getId()!=null) {
			entityManager.persist(course);
		}else {
			entityManager.merge(course);
		}
		return course;
	}

	public void addReviewWithCourse() {
		
		Course course=findById(10001L);
		logger.info("course with getReview -> {}",course.getReviews());
		
		Review review1=new Review("5", "Good");
		Review review2=new Review("5", "Good-One");
		
		course.addReviews(review1);
		review1.setCourse(course);
		
		
		course.addReviews(review2);
		review2.setCourse(course);
		
		entityManager.persist(review1);
		entityManager.persist(review2);
		
	}
	
	public void addReviewWithCourse(Long courseId,List<Review> reviews) {
		Course course=findById(courseId);
		
		for (Review review : reviews) {
			course.addReviews(review);
			review.setCourse(course);
			entityManager.persist(review);
		}
		
	}
	
}
