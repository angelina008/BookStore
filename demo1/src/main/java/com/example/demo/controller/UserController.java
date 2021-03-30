package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.*;
import com.example.demo.model.*;
@RestController
@RequestMapping ("api/")
public class UserController {
	@Autowired
	private UserRepository UserRepository;
	
	@GetMapping ("users")
	public List<User> getUsers(){
		return this.UserRepository.findAll();
	}

}
