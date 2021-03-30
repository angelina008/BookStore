package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Country {
		@Id 
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		private long id;
		private String name;
		private String continent;
		
		public Country() {}
		
		public Country(String name, String continent) {
			super();
			this.name = name;
			this.continent = continent;
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

		public String getContinent() {
			return continent;
		}

		public void setContinent(String continent) {
			this.continent = continent;
		}
		
		
}
