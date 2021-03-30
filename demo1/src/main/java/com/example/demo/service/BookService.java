package com.example.demo.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.Book;
import com.example.demo.model.Author;
import com.example.demo.model.Category;
import java.util.List;
import java.util.Optional;
public interface BookService {


	    List<Book> findAll();

	    Page<Book> findAllWithPagination(Pageable pageable);

	    Optional<Book> findById(Long id);

	    Optional<Book> save(Book book);

	    Optional<Book> edit(Long id);

	    void deleteById(Long id);

	    Optional<Book> newADD(String name, Category category, Author author, int copies);

}
