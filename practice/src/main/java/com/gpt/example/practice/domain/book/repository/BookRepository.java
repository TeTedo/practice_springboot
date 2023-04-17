package com.gpt.example.practice.domain.book.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gpt.example.practice.domain.book.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = """
                SELECT b
                FROM Book b
            """)
    List<Book> findAllBooks();

    @Query(value = """
            SELECT b
            FROM Book b
            WHERE b.id = :id
            """)
    Optional<Book> findBookById(@Param(value = "id") Long id);
}
