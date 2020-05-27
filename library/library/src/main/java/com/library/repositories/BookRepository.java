package com.library.repositories;

import org.springframework.data.repository.CrudRepository;

import com.library.models.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

}
