package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Category;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.UserRepository;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public BookServiceImpl(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Page<Book> findAllWithPagination(Pageable pageable) {
        return this.bookRepository.findAll(pageable);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }


	@Override
	public Optional<Book> findById(Long id) {
		// TODO Auto-generated method stub
		return this.bookRepository.findById(id);
	}

	@Override
	public Optional<Book> save(Book book) {
		// TODO Auto-generated method stub
		return Optional.of(this.bookRepository.save(new Book(book.getName(),book.getCategory(), book.getAuthor(), book.getAvaliable_copies())));
		//return null;
	}

	@Override
	public Optional<Book> edit(Long id) {
		// TODO Auto-generated method stub
		Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new BooktNotFoundException(id));
		return Optional.of(this.bookRepository.save(book));

	}

	@Override
	public Optional<Book> newADD(String name, Category category, Author author, int copies) {
		// TODO Auto-generated method stub
		return Optional.of(this.bookRepository.save(new Book(name, category, author, copies)));
	}
}

