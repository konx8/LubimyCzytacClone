package com.Clone.LubimyCzytacClone.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "books")
public class Book {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private int releaseYear;
    @Column
    private String author;

    public Book(String title, int releaseYear, String author) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.author = author;
    }

    public Book(Long id, String title, int releaseYear, String author) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.author = author;
    }
}
