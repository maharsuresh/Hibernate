package com.athena.boot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athena.boot.bean.Book;

@RestController
public class BookController {
	
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		return Arrays.asList(new Book(1,"Java","Durga"),new Book(2, ".net", "Mahesh"),new Book(3,"php","Akash"), new Book(4, "angular", "Bikahs"));
	}

}
