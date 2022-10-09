package com.zed.bookapi.model;

import javax.persistence.*;
import java.time.LocalDate;

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
    private LocalDate publication_date;
    @Column
    private String publisher;


    public Books() {

    }

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

    public LocalDate getPublication_date() {
        return publication_date;
    }

    public String getPublisher() {
        return publisher;
    }

    /*
        SETTERS
     */
    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public void setAverage_rating(double average_rating) {
        this.average_rating = average_rating;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public void setLanguage_code(String language_code) {
        this.language_code = language_code;
    }

    public void setNum_pages(int num_pages) {
        this.num_pages = num_pages;
    }

    public void setRatings_count(int ratings_count) {
        this.ratings_count = ratings_count;
    }

    public void setText_reviews_count(int text_reviews_count) {
        this.text_reviews_count = text_reviews_count;
    }

    public void setPublication_date(LocalDate publication_date) {
        this.publication_date = publication_date;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
