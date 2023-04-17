package com.gpt.example.practice.domain.book.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gpt.example.practice.domain.book.dto.response.BookResponse;
import com.gpt.example.practice.domain.book.service.BookService;
import com.gpt.example.practice.global.common.dto.ApiResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BookController {

    private final BookService bookService;

    @GetMapping(value = "/books")
    public ResponseEntity<ApiResponse<List<BookResponse>>> getBooks() {
        List<BookResponse> books = bookService.getAllBooks();

        return ResponseEntity.ok().body(new ApiResponse<>(books));
    }

    @GetMapping(value = "/books/{id}")
    public ResponseEntity<ApiResponse<BookResponse>> getBookById(
            @PathVariable Long id) {
        BookResponse book = bookService.getBookById(id);

        return ResponseEntity.ok().body(new ApiResponse<>(book));
    }
}
