package com.example.library.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Titlul este obligatoriu")
    @Size(max = 255)
    private String title;

    @NotNull(message = "Autorul este obligatoriu")
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @NotBlank(message = "isbn este obligatoriu")
    @Size(min = 5, max = 255)
    private String isbn;

    @Min(value = 1000, message = "Anul trebuie sa fie cel putin 1000")
    @Max(value = 2100, message = "Anul trebuie sa fie cel mult 2100")
    private int publicationYear;

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
}
