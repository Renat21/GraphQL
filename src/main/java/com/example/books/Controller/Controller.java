package com.example.books.Controller;


import com.example.books.entity.Book;
import com.example.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private BookRepository bookRepository;

    @QueryMapping
    Iterable<Book> books(){
        return bookRepository.findAll();
    }

    @QueryMapping
    Iterable<Book> findBookByAuthor(@Argument String author){
        return bookRepository.findBooksByAuthor(author);
    }
}

