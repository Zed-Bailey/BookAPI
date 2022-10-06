package com.zed.bookapi.services;

import com.zed.bookapi.repository.BookRepository;
import com.zed.bookapi.model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public List<Books> getBooks() {
        return (List<Books>) repository.findAll();
    }


    public Books getBookByISBN(String isbn) {
        return repository.getBookByISBN(isbn);
    }

    public Books getBookByISBN13(String isbn) {
        return repository.getBookByISBN13(isbn);
    }


    /**
     * Returns the book with the corresponding ID or null if not found
     *
     * @param id the booksID
     * @return returns Books model if ID is found else null
     */
    public Optional<Books> getBookByID(int id) {
        return repository.findById(id);
    }
}
