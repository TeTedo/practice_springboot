package com.gpt.example.practice.domain.book.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Book {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String title;

    @Column
    private String author;

    @Column
    private int publicationYear;
}
