package com.zed.bookapi.services;

import com.zed.bookapi.repository.BookRepository;
import com.zed.bookapi.model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    /*
        GET
     */

    public List<Books> getBooks() {
        return (List<Books>) repository.findAll();
    }

    /**
     * Returns the book with the corresponding ID
     *
     * @param id the booksID
     * @return Optional book, value will be null if book not found
     */
    public Optional<Books> getBookByID(int id) {
        return repository.findById(id);
    }


    public List<Books> searchBooksByQuery(String query) {
        return (List<Books>) repository.searchBooks(query);
    }

    public List<Books> getBooksByAuthor(String author) {
        return (List<Books>) repository.getBooksByAuthor(author);
    }

    public Books getBookByISBN(String isbn) {
        return repository.getBookByISBN(isbn);
    }

    public Books getBookByISBN13(String isbn) {
        return repository.getBookByISBN13(isbn);
    }

    public List<Books> getBooksWithRatingGreaterThan(double rating) {
        return (List<Books>) repository.getBooksWithRatingGreaterThan(rating);
    }

    public List<Books> getBooksWithRatingLessThan(double rating) {
        return (List<Books>) repository.getBooksWithRatingLessThan(rating);
    }

    public List<String> getLanguageCodes() {
        return (List<String>) repository.getLanguageCodes();
    }

    public List<Books> getBooksWithLanguageCode(String code) {
        return (List<Books>) repository.getBooksByLanguageCode(code);
    }

    public List<String> getPublishers() {
        return (List<String>) repository.getPublishers();
    }

    public List<Books> getBooksByPublisher(String publisher) {
        return (List<Books>) repository.getBooksByPublisher(publisher);
    }


    public List<Books> getBooksPublishedBefore(LocalDate date) {
        return (List<Books>) repository.getBooksPublishedBefore(date);
    }

    public List<Books> getBooksPublishedOn(LocalDate date) {
        return (List<Books>) repository.getBooksPublishedOn(date);
    }

    public List<Books> getBooksPublishedAfter(LocalDate date) {
        return (List<Books>) repository.getBooksPublishedAfter(date);
    }

    /*
     * DELETE
     */
    public void deleteBookByID(int id) {
        repository.deleteById(id);
    }

    /*
        POST
     */
    public Books createBook(Books b) {
        /*
        this is not the ideal way to do this as it requires an extra DB call
        but h2 will not update the sequence variable after inserting the data from the csv
         */
        var lastID = repository.getMaxBookID();
        b.setBookID(lastID + 1);
        return repository.save(b);
    }

    /*
       PUT
    */
    public Books updateBook(Books with, int id) {
        var toUpdate = repository.findById(id);
        if (toUpdate.isPresent()) {
            // get value from optional
            var book = toUpdate.get();
            // update class
            book.UpdateDetails(with);
            // save
            return repository.save(book);
        } else {
            // if book doesn't exist then it will be created
            return createBook(with);
        }
    }

}
