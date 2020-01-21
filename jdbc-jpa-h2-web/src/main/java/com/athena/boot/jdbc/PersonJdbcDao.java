package com.athena.boot.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.athena.boot.entity.Person;

@Repository
public class PersonJdbcDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	class CustomRowMapper implements RowMapper<Person>{

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person  person=new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirth_date(rs.getTimestamp("birth_date"));
			return person;
		}
		
	}
	
	//@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Person> getAllPersons(){
		//return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper(Person.class));
		return jdbcTemplate.query("select * from person", new CustomRowMapper());
	}

	
	public Person findById(int id) {
		return jdbcTemplate.queryForObject
				("select * from person where id=?",new Object[] {id}, 
						new BeanPropertyRowMapper<>(Person.class));
	}
	
	public Person findByName(String name) {
		return jdbcTemplate.queryForObject
		("select * from person where name=?",new Object[] {name}, 
				new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public Person findByLocation(String location) {
		return jdbcTemplate.queryForObject
		("select * from person where location=?",new Object[] {location}, 
				new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public int deleteById(int id) {
		return jdbcTemplate.update("delete from person where id=?",new Object[] {id});
	}
	
	public int insertOne(Person person) {
		return jdbcTemplate.update
				("insert into person values(?,?,?,?)",
						new Object[] {
								person.getId(),
								person.getName(),
								person.getLocation(),
								new Date(person.getBirth_date().getTime())});
	}
	
	public int update(Person person) {
		return jdbcTemplate.update
				("update person "
				 + " set name=?,location=?,birth_date=? "
				 + " where id=?",new Object[] {
						 person.getName(),
						 person.getLocation(),
						 new Timestamp(person.getBirth_date().getTime()),
						 person.getId()});
	}
}

