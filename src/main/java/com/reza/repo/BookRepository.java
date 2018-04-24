package com.reza.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.reza.model.Book;



public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByTitle(String title);

    Optional<Book> findOne(long id);
}
