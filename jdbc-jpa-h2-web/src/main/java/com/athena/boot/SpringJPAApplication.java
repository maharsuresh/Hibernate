package com.athena.boot;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.athena.boot.entity.Person;
import com.athena.boot.jpa.PersonJpaRepository;

@SpringBootApplication
public class SpringJPAApplication implements CommandLineRunner {
	
	private Logger logger=LoggerFactory.getLogger(SpringJPAApplication.class);
	
	@Autowired
	private PersonJpaRepository jpaRepository;
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJPAApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Person findById = jpaRepository.findById(10001);
		
		logger.info("Person id: {} ",findById);
		
		Person update = jpaRepository.update(new Person(10003, "Saurabh", "DEL", new Date()));
		logger.info("Update 10003 -> {}",update);
		
		Person insert = jpaRepository.insert(new Person("Sailendra", "Mum", new Date()));
		
		logger.info("insert  without custom id - > {} ",insert);
		
		jpaRepository.deleteById(1);
		
		List<Person> findAll = jpaRepository.findAll();
		logger.info("Find all person- {} ",findAll);
	}
	

}
