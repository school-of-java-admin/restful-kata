package com.example.demo.service;

import com.example.demo.model.Book;
import java.util.Optional;
import org.springframework.data.domain.Page;

public interface BookService {
  Book saveBook(Book book);
  Optional<Book> findById(Long id);
  Page<Book> findPaginated(Integer pageNo, Integer pageSize);
}
