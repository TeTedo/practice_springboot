package com.gpt.example.practice.domain.book.dto.response;

public record BookResponse(Long id,
                String title,
                String author,
                Integer publicationYear) {
}
