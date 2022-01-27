package com.example.demo.controller;

import com.example.demo.dto.BookDto;
import com.example.demo.exception.BookNotFoundException;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping
    ResponseEntity<BookDto> createBook(@Valid @RequestBody BookDto newBook) {
        Book book = modelMapper.map(newBook, Book.class);
        Book createdBook = bookService.saveBook(book);
        BookDto mappedDto = modelMapper.map(createdBook, BookDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @GetMapping("/{id}")
    ResponseEntity<BookDto> findById(@PathVariable(value = "id") Long id) {
        Optional<Book> optionalBook = bookService.findById(id);
        if (optionalBook.isEmpty()) {
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            throw new BookNotFoundException(id);
        }
        BookDto mappedDto = modelMapper.map(optionalBook.get(), BookDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @GetMapping
    public Page<Book> getBooks(Pageable pageable) {
        return bookService.findAll(pageable);
    }
}
