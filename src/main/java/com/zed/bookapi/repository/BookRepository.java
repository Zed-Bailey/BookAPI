package com.zed.bookapi.repository;

import com.zed.bookapi.model.Books;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Collection;

public interface BookRepository extends CrudRepository<Books, Integer> {
    /*
        Get books by ISBN
     */
    @Query("select b from Books b where b.isbn = ?1")
    Books getBookByISBN(String isbn);

    @Query("select b from Books b where b.isbn13 = ?1")
    Books getBookByISBN13(String isbn);

    /*
        Get books by author
     */
    @Query("select b from Books b where b.authors like %?1%")
    Collection<Books> getBooksByAuthor(String author);

    /*
        Get books by rating
     */
    @Query("SELECT b from Books b where b.average_rating > ?1")
    Collection<Books> getBooksWithRatingGreaterThan(double rating);

    @Query("SELECT b from Books b where b.average_rating < ?1")
    Collection<Books> getBooksWithRatingLessThan(double rating);

    /*
        Get books by language code
     */
    @Query("select distinct b.language_code from Books b")
    Collection<String> getLanguageCodes();

    @Query("select b from Books b where b.language_code = ?1")
    Collection<Books> getBooksByLanguageCode(String code);


    /*
        Get books by publisher
     */
    @Query("select distinct b.publisher from Books b")
    Collection<String> getPublishers();

    @Query("select b from Books b where b.publisher = ?1")
    Collection<Books> getBooksByPublisher(String publisher);

    /*
        Get books by publication date
     */
    @Query("select b from Books b where b.publication_date < ?1")
    Collection<Books> getBooksPublishedBefore(LocalDate date);

    @Query("select b from Books b where b.publication_date = ?1")
    Collection<Books> getBooksPublishedOn(LocalDate date);

    @Query("select b from Books b where b.publication_date > ?1")
    Collection<Books> getBooksPublishedAfter(LocalDate date);

}
