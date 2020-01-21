package com.athena.boot;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import com.athena.boot.entity.Person;
import com.athena.boot.jdbc.PersonJdbcDao;

//@SpringBootApplication
public class JdbcJpaH2WebApplication implements CommandLineRunner {
	private Logger logger=LoggerFactory.getLogger(JdbcJpaH2WebApplication.class);
	
	@Autowired
	PersonJdbcDao dao;
	

	public static void main(String[] args) {
		SpringApplication.run(JdbcJpaH2WebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Person> allPersons = dao.getAllPersons();
		logger.info("Person Details -> {}",allPersons);
		
		Person findById = dao.findById(10001);
		logger.info("Person id:10001-> {}",findById);
		
		logger.info("Person Name: ->  {}",dao.findByName("suresh"));
		
		logger.info("person location:->  {}",dao.findByLocation("BBSR"));
		
		logger.info("Delete from Person : [10001]-> {} ",dao.deleteById(10001));
		
		logger.info("insert to person: -> {} ",dao.insertOne(new Person(10005, "Dinesh", "CHNI", new Date())));
		logger.info("update for 1002 -> {} ",dao.update(new Person(10002, "Samrat", "BBSR", new Date())));
	}

}
