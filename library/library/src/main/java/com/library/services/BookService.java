package com.library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.library.generic.servicesImpl.GenericServiceImpl;
import com.library.models.Book;
import com.library.repositories.BookRepository;

@Service
public class BookService extends GenericServiceImpl<Book, Integer>{

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public CrudRepository<Book, Integer> getCrudRepository() {
				return this.bookRepository;
	}

}
