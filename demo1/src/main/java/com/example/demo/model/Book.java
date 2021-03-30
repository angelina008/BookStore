package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.model.Author;
@Entity
@Table (name = "books")
public class Book {
			@Id 
			@GeneratedValue (strategy = GenerationType.IDENTITY)
			private long id;
			@Column (name = "Name")
			private String name;
			@Column (name = "Category")
			@Enumerated(value = EnumType.STRING)
			private Category category;
			@Column (name = "Author")
			private Author author;
			@Column (name = "Avaliable Copies")
			private Integer avaliable_copies;
			
			public Book() {}
			
			public Book(String name, Category category, Author author, Integer avaliable_copies) {
				super();
				this.name = name;
				this.category = category;
				this.author = author;
				this.avaliable_copies = avaliable_copies;
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

			public Category getCategory() {
				return category;
			}

			public void setCategory(Category category) {
				this.category = category;
			}

			public Author getAuthor() {
				return author;
			}

			public void setAuthor(Author author) {
				this.author = author;
			}

			public Integer getAvaliable_copies() {
				return avaliable_copies;
			}

			public void setAvaliable_copies(Integer avaliable_copies) {
				this.avaliable_copies = avaliable_copies;
			}
			
			
}
