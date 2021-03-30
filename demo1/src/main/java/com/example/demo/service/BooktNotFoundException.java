package com.example.demo.service;

public class BooktNotFoundException extends RuntimeException {

	public BooktNotFoundException(Long id) {
		// TODO Auto-generated constructor stub
		super(String.format("Book with id" + id +  "doesn't exist"));
	}

}
