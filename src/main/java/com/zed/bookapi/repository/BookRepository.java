package com.zed.bookapi.repository;

import com.zed.bookapi.model.Books;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Books, Integer> {
    @Query("select b from Books b where b.isbn = ?1")
    Books getBookByISBN(String isbn);

    @Query("select b from Books b where b.isbn13 = ?1")
    Books getBookByISBN13(String isbn);
}
