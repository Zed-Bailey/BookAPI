package com.zed.bookapi.model;

import java.util.List;

/**
 * List response for the language codes and publishers endpoints
 */
public class ListResponse {
    public int count;
    public List<String> results;

    public ListResponse(List<String> results) {
        this.count = results.size();
        this.results = results;
    }

}
