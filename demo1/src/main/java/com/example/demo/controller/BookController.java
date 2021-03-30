package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Category;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.*;
@RestController
@RequestMapping ("/api/books/")
public class BookController {
	  private final BookService bookService;

	    public BookController(BookService bookService) {
	        this.bookService = bookService;
	    }

	    @GetMapping
	    public List<Book> findAll() {
	        return this.bookService.findAll();
	    }

	    @GetMapping("/pagination")
	    public List<Book> findAllWithPagination(Pageable pageable) {
	        return this.bookService.findAllWithPagination(pageable).getContent();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Book> findById(@PathVariable Long id) {
	        return this.bookService.findById(id)
	                .map(book -> ResponseEntity.ok().body(book))
	                .orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @PostMapping("/add")
	    public ResponseEntity<Book> save(@RequestBody Book book) {
	        return this.bookService.save(book)
	                .map(newbook -> ResponseEntity.ok().body(newbook))
	                .orElseGet(() -> ResponseEntity.badRequest().build());
	    }

	    @PutMapping("/edit/{id}")
	    public ResponseEntity<Book> edit(@PathVariable Long id, @RequestBody Book book) {
	        return this.bookService.edit(id)
	                .map(newbook -> ResponseEntity.ok().body(newbook))
	                .orElseGet(() -> ResponseEntity.badRequest().build());
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity deleteById(@PathVariable Long id) {
	        this.bookService.deleteById(id);
	        if(this.bookService.findById(id).empty() != null)
	            return ResponseEntity.ok().build();
	        return ResponseEntity.badRequest().build();
	    }

	    @PostMapping("/assign/{id}")
	    public ResponseEntity<Book> assignDiscount(@RequestParam String name,@RequestParam Category category, @RequestParam Author author, @RequestParam int copies) {
	        return this.bookService.newADD(name, category,author,copies)
	                .map(book -> ResponseEntity.ok().body(book))
	                .orElseGet(() -> ResponseEntity.badRequest().build());
	    }
}


