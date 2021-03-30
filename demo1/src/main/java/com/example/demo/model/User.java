package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "users")
public class User {
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	@Column (name = "first_name")
	private String FirstName;
	@Column (name = "last_name")
	private String LastName;
	
	private String email;
	
	public User() {}
	
	public User(String firstName, String lastName, String email) {
		super();
		FirstName = firstName;
		LastName = lastName;
		this.email = email;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
