package com.example.books.Controller;


import com.example.books.entity.Author;
import com.example.books.entity.Book;
import com.example.books.repository.BookRepository;
import com.example.books.repository.authorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import java.util.Optional;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private authorRepository authorRepository;

    @QueryMapping
    Iterable<Book> books(){
        return bookRepository.findAll();
    }

    @QueryMapping
    Iterable<Book> findBookByAuthor(@Argument String name){
        return bookRepository.findBooksByAuthor_Name(name);
    }

    @MutationMapping
    Book addBook(@Argument BookInput bookInput){
        Optional<Author> author = authorRepository.findById(bookInput.authorId);
        Book book = new Book(bookInput.name, bookInput.genre, author.get());
        return bookRepository.save(book);
    }

    record BookInput(String name, String genre, Long authorId){}
}

