package com.zed.bookapi.model;

import java.util.List;

public class CategoryResponse {
    public List<String> results;
    public int count;

    public CategoryResponse(List<String> results) {
        this.count = results.size();
        this.results = results;
    }

}
