package com.gpt.example.practice.domain.book.service;

import java.util.List;

import com.gpt.example.practice.domain.book.dto.response.BookResponse;

public interface BookService {
    List<BookResponse> getAllBooks();

    BookResponse getBookById(long id);

}
