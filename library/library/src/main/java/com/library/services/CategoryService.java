package com.library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.library.generic.servicesImpl.GenericServiceImpl;
import com.library.models.Category;
import com.library.repositories.CategoryRepository;

@Service
public class CategoryService extends GenericServiceImpl<Category, Integer> {

	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public CrudRepository<Category, Integer> getCrudRepository() {
		
		return this.categoryRepository;
		
	}

}
