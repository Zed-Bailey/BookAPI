package com.zed.bookapi.model;

import java.util.ArrayList;
import java.util.List;

public class BookResponse {
    public int count;
    public List<Books> results;
    public String error;

    public BookResponse(List<Books> booksList) {
        this.count = booksList.size();
        this.results = booksList;
        this.error = "";
    }

    public BookResponse(String error) {
        this.error = error;
        this.count = 0;
        this.results = new ArrayList<>();
    }

    public BookResponse(Books book) {
        this.count = 1;
        this.error = "";
        this.results = List.of(book);
    }
}
