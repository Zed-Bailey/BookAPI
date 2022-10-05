package com.zed.bookapi.controller;

import com.zed.bookapi.model.Books;
import com.zed.bookapi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("/")
    public Books HelloWorld() {
        return service.getBooks().get(0);
    }
}
