package com.athena.boot.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Course {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;

	@OneToMany(mappedBy = "course")
	private List<Review> reviews=new ArrayList<>();
	
	@ManyToMany(mappedBy = "courses")
	private List<Student> students=new ArrayList<>();
	

	public Course() {
		super();
	}

	public Course(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	
	
	

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReviews(Review review) {
		this.reviews.add(review);
	}
	
	public void deleteReviews(Review review) {
		this.reviews.remove(review);
	}
	
	

	public List<Student> getStudents() {
		return students;
	}

	public void addStudents(Student students) {
		this.students.add(students);
	}

	@Override
	public String toString() {
		return "\nCourse [id=" + id + ", name=" + name + "]";
	}
	
	
	 
	

}
