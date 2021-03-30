package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Author {
		@Id 
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		private long id;
		private String name;
		private String surname;
		private Country country;
		
		public Author() {}
		
		public Author(String name, String surname, Country country) {
			super();
			this.name = name;
			this.surname = surname;
			this.country = country;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSurname() {
			return surname;
		}

		public void setSurname(String surname) {
			this.surname = surname;
		}

		public Country getCountry() {
			return country;
		}

		public void setCountry(Country country) {
			this.country = country;
		}
		
		
		
}
