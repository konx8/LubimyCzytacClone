package com.Clone.LubimyCzytacClone.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Table(name = "books")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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


    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<BookRate> bookRates;

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

    public Book() {
    }
}
