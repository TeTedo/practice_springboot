package com.gpt.example.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
	}

}

// class Book {
// private long id;
// private String title;
// private String author;
// private int publicationYear;

// public Book(long id, String title, String author, int publicationYear) {
// this.id = id;
// this.title = title;
// this.author = author;
// this.publicationYear = publicationYear;
// }

// public long getId() {
// return id;
// }

// public void setId(long id) {
// this.id = id;
// }

// public String getTitle() {
// return title;
// }

// public void setTitle(String title) {
// this.title = title;
// }

// public String getAuthor() {
// return author;
// }

// public void setAuthor(String author) {
// this.author = author;
// }

// public int getPublicationYear() {
// return publicationYear;
// }

// public void setPublicationYear(int publicationYear) {
// this.publicationYear = publicationYear;
// }

// }
