package com.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.models.Admin;
import com.library.services.AdminService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/rest/service"})
public class AdminController {
	
	@Autowired
	AdminService service;
	
	
	@GetMapping("/admins")
	public List<Admin> listar(){
		return service.getAll();
		
	}

}
