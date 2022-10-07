package com.zed.bookapi.model;

import java.util.List;

public class CategoryResponse {
    public int count;
    public List<String> results;

    public CategoryResponse(List<String> results) {
        this.count = results.size();
        this.results = results;
    }

}
