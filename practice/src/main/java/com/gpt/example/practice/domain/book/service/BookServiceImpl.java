package com.gpt.example.practice.domain.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gpt.example.practice.domain.book.dto.response.BookResponse;
import com.gpt.example.practice.domain.book.exception.BookNotFoundException;
import com.gpt.example.practice.domain.book.mapper.BookMapper;
import com.gpt.example.practice.domain.book.model.Book;
import com.gpt.example.practice.domain.book.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public List<BookResponse> getAllBooks() {
        List<Book> books = bookRepository.findAllBooks();
        return toBookResponseList(books);
    }

    private List<BookResponse> toBookResponseList(List<Book> books) {
        return bookMapper.toBookResponseList(books.stream().toList());
    }

    @Override
    public BookResponse getBookById(long id) {
        Optional<Book> book = bookRepository.findBookById(id);
        if (book.isPresent()) {
            return toBookResponse(book.get());
        } else {
            throw new BookNotFoundException(id);
        }
    }

    private BookResponse toBookResponse(Book book) {
        return bookMapper.toBookResponse(book);
    }
}