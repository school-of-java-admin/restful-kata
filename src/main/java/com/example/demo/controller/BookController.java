package com.example.demo.controller;

import com.example.demo.controller.dto.BookDto;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController         // very important for injection
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    private ModelMapper modelMapper = new ModelMapper();

    public BookController(BookService bookService) {
      this.bookService = bookService;
    }

    @PostMapping
    ResponseEntity<BookDto> createBook(@Valid @RequestBody BookDto newBook) {
      Book book = modelMapper.map(newBook, Book.class);
      BookDto mappedDto = modelMapper.map(bookService.saveBook(book), BookDto.class);
      return ResponseEntity.ok(mappedDto);
    }

    ResponseEntity<BookDto> findById(Long id) {
      Optional<Book> optionalBook = bookService.findById(id);
      if(!optionalBook.isPresent()) {
      
      }

      return null;
    }

    @GetMapping("/page/{pageNo}")
    public Page<BookDto> booksPaginated(@PathVariable (value = "pageNo") Integer pageNo) {
      Integer pageSize = 5;
      Page<Book> booksPage = bookService.findPaginated(pageNo, pageSize);

      System.out.println("Current Page" + pageNo);
      System.out.println("======================== TOTAL PAGES ======================");
      System.out.println(booksPage.getTotalPages());
      System.out.println("======================== TOTAL ELEMENTS ======================");
      System.out.println(booksPage.getTotalElements());
      System.out.println("======================== TOTAL PAGE CONTENT ======================");
      System.out.println(booksPage.getContent());



      return null;
    }


}
