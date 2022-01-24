package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

  private BookRepository bookRepository;

  public BookServiceImpl(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public Book saveBook(Book book) {
    return bookRepository.save(book);
  }

  public Optional<Book> findById(Long id) {
    return bookRepository.findById(id);
  }

  @Override
  public Page<Book> findPaginated(Integer pageNo, Integer pageSize) {
    return bookRepository.findAll(PageRequest.of(pageNo, pageSize));
  }
}
