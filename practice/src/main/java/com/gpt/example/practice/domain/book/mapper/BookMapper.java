package com.gpt.example.practice.domain.book.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.gpt.example.practice.domain.book.dto.response.BookResponse;
import com.gpt.example.practice.domain.book.model.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "author", target = "author")
    @Mapping(source = "publicationYear", target = "publicationYear")

    BookResponse toBookResponse(Book book);

    List<BookResponse> toBookResponseList(List<Book> books);
}
