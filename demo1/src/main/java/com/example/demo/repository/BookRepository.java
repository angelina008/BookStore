package com.example.demo.repository;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	Page<Book> findAll(Pageable pageable);

}
