package com.zed.bookapi.controller;

import com.zed.bookapi.model.BookResponse;
import com.zed.bookapi.model.Books;
import com.zed.bookapi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class BookController {

    @Autowired
    private BookService service;


    @GetMapping("/")
    public Books HelloWorld() {
        return service.getBooks().get(0);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<BookResponse> GetBookByID(@PathVariable int id) {
        var book = service.getBookByID(id);
        return book
                .map(books -> new ResponseEntity<>(new BookResponse(books), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(new BookResponse("No book found with that ID"), HttpStatus.NOT_FOUND));
    }

    @GetMapping("/books/isbn/{isbn}")
    public ResponseEntity<BookResponse> GetBookByISBN(@PathVariable String isbn) {
        var book = service.getBookByISBN(isbn);
        if (book == null) {
            return new ResponseEntity<>(new BookResponse("No book found with that ISBN"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new BookResponse(book), HttpStatus.OK);
    }

    @GetMapping("/books/isbn13/{isbn}")
    public ResponseEntity<BookResponse> GetBookByISBN13(@PathVariable String isbn) {
        var book = service.getBookByISBN13(isbn);
        if (book == null) {
            return new ResponseEntity<>(new BookResponse("No book found with that ISBN13"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new BookResponse(book), HttpStatus.OK);
    }
}
