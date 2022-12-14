package com.example.books.entity;


import javax.persistence.*;

@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;


    private String name;

    private String genre;

    @ManyToOne(fetch = FetchType.EAGER)
    private Author author;

    public Book(String name, String genre, Author author) {
        this.name = name;
        this.genre = genre;
        this.author = author;
    }

    public Book() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
