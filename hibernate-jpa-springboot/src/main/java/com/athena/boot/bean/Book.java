package com.athena.boot.bean;

public class Book {
	private int id;
	private String name;
	private String auther;
	public Book(int id, String name, String auther) {
		super();
		this.id = id;
		this.name = name;
		this.auther = auther;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAuther() {
		return auther;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", auther=" + auther + "]";
	}
	
	//this is a test.

}
