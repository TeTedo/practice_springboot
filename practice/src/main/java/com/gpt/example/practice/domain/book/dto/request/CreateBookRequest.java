package com.gpt.example.practice.domain.book.dto.request;

import jakarta.validation.constraints.NotNull;

public record CreateBookRequest(
                @NotNull String title,
                @NotNull String author,
                @NotNull int publicationYear) {

}
