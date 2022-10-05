package com.zed.bookapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Books {
    @Id
    @Column
    private int bookID;
    @Column
    private String title;
    @Column
    private String authors;
    @Column
    private double average_rating;
    @Column
    private String isbn;
    @Column
    private String isbn13;
    @Column
    private String language_code;
    @Column
    private int num_pages;
    @Column
    private int ratings_count;
    @Column
    private int text_reviews_count;
    @Column
    private String publication_date;
    @Column
    private String publisher;

    /*
     *   GENERATED GETTERS
     */

    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthors() {
        return authors;
    }

    public double getAverage_rating() {
        return average_rating;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public String getLanguage_code() {
        return language_code;
    }

    public int getNum_pages() {
        return num_pages;
    }

    public int getRatings_count() {
        return ratings_count;
    }

    public int getText_reviews_count() {
        return text_reviews_count;
    }

    public String getPublication_date() {
        return publication_date;
    }

    public String getPublisher() {
        return publisher;
    }


}
