package com.gpt.example.practice.domain.book.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

    @Modifying
    @Query(value = """
            INSERT INTO book (title, author, publication_year)
            VALUES (:title, :author, :publication_year)
            """, nativeQuery = true)
    void addBook(
            @Param(value = "title") String title,
            @Param(value = "author") String author,
            @Param(value = "publication_year") int publicationYear);

    @Modifying
    @Query(value = """
            UPDATE Book
            SET title = :title, author = :author, publicationYear = :publicationYear
            WHERE id = :id
            """)
    void updateBook(
            @Param(value = "id") long id,
            @Param(value = "title") String title,
            @Param(value = "author") String author,
            @Param(value = "publicationYear") int publicationYear);
}
