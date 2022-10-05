package com.zed.bookapi.services;

import com.zed.bookapi.BookRepository;
import com.zed.bookapi.model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public List<Books> getBooks() {
//        var i = repository.findAll();
//        return i;
        return (List<Books>) repository.findAll();
    }
}
