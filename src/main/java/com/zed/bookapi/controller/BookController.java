package com.zed.bookapi.controller;

import com.zed.bookapi.model.BookResponse;
import com.zed.bookapi.model.Books;
import com.zed.bookapi.model.ListResponse;
import com.zed.bookapi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class BookController {

    @Autowired
    private BookService service;


    @GetMapping("/books")
    public ResponseEntity<BookResponse> GetAllBooks() {
        return new ResponseEntity<>(new BookResponse(service.getBooks()), HttpStatus.OK);
    }

    @GetMapping(value = "/books", params = {"query"})
    public ResponseEntity<BookResponse> GetBooksBySearchQuery(@RequestParam("query") String query) {
        return new ResponseEntity<>(new BookResponse(service.searchBooksByQuery(query)), HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<BookResponse> PostNewBook(@RequestBody Books book) {

        if (book == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new BookResponse(service.createBook(book)), HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<BookResponse> GetBookByID(@PathVariable int id) {
        var book = service.getBookByID(id);
        return book
                .map(books -> new ResponseEntity<>(new BookResponse(books), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(new BookResponse("No book found with that ID"), HttpStatus.NOT_FOUND));
    }

    /**
     * Deletes the book with the ID passed through the URI param
     *
     * @param id the id of the book to delete
     * @return a response entity
     */
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Object> DeleteBookByID(@PathVariable int id) {
        service.deleteBookByID(id);
        return new ResponseEntity<>(HttpStatus.OK);
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

    @GetMapping("/books/author")
    public ResponseEntity<BookResponse> GetBooksByAuthor(@RequestParam(name = "v") String author) {
        var authorBooks = service.getBooksByAuthor(author);
        return new ResponseEntity<>(new BookResponse(authorBooks), HttpStatus.OK);
    }

    @GetMapping(value = "/books/rating", params = {"gt"})
    public ResponseEntity<BookResponse> getBooksWithRatingGreaterThan(@RequestParam(name = "gt") double gt) {
        return new ResponseEntity<>(new BookResponse(service.getBooksWithRatingGreaterThan(gt)), HttpStatus.OK);
    }

    @GetMapping(value = "/books/rating", params = {"lt"})
    public ResponseEntity<BookResponse> getBooksWithRatingLessThan(@RequestParam(name = "lt") double lt) {
        return new ResponseEntity<>(new BookResponse(service.getBooksWithRatingLessThan(lt)), HttpStatus.OK);
    }

    @GetMapping("/books/publishers")
    public ResponseEntity<ListResponse> getAllPublishers() {
        return new ResponseEntity<>(new ListResponse(service.getPublishers()), HttpStatus.OK);
    }

    @GetMapping(value = "/books/published", params = {"by"})
    public ResponseEntity<BookResponse> getBooksPublished(@RequestParam(name = "by") String by) {
        return new ResponseEntity<>(new BookResponse(service.getBooksByPublisher(by)), HttpStatus.OK);
    }

    @GetMapping(value = "/books/published", params = {"before"})
    public BookResponse getBooksPublishedBefore(@RequestParam(name = "before") String publishedBefore) {
        LocalDate date = LocalDate.parse(publishedBefore);
        return new BookResponse(service.getBooksPublishedBefore(date));
    }

    @GetMapping(value = "/books/published", params = {"on"})
    public BookResponse getBooksPublishedOn(@RequestParam(name = "on") String publishedOn) {
        LocalDate date = LocalDate.parse(publishedOn);
        return new BookResponse(service.getBooksPublishedOn(date));
    }

    @GetMapping(value = "/books/published", params = {"after"})
    public BookResponse getBooksPublishedAfter(@RequestParam(name = "after") String publishedAfter) {
        LocalDate date = LocalDate.parse(publishedAfter);
        return new BookResponse(service.getBooksPublishedAfter(date));
    }

    @GetMapping("/books/languagecodes")
    public ResponseEntity<ListResponse> getLanguageCodes() {
        return new ResponseEntity<>(new ListResponse(service.getLanguageCodes()), HttpStatus.OK);
    }

    @GetMapping(value = "/books", params = {"language"})
    public ResponseEntity<BookResponse> getBooksByLanguage(@RequestParam(name = "language") String code) {
        return new ResponseEntity<>(new BookResponse(service.getBooksWithLanguageCode(code)), HttpStatus.OK);
    }

}
