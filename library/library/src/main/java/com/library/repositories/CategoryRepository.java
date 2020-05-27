package com.library.repositories;

import org.springframework.data.repository.CrudRepository;

import com.library.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
