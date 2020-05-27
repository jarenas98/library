package com.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.models.Book;
import com.library.models.Category;
import com.library.models.Client;
import com.library.services.CategoryService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/rest/service"})
public class CategoryController {
	
	 @Autowired
	 CategoryService service;
	
	@GetMapping("/categories")
	public List<Category> listar(){
		return service.getAll();
		
	}
	
	@PostMapping(value ="/addCategory")
	public ResponseEntity<Category> add(@RequestBody Category category){
		service.add(category);
		return new ResponseEntity<Category>(category, HttpStatus.CREATED);
		
	}

}
