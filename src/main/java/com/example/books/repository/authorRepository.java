package com.example.books.repository;

import com.example.books.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface authorRepository extends JpaRepository<Author, Long> {

    Author findAuthorById(Long id);
}
