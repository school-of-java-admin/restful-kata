package com.example.demo.service;

import com.example.demo.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BookService {
    Book saveBook(Book book);

    Optional<Book> findById(Long id);

    Page<Book> findAll(Pageable pageable);
}
