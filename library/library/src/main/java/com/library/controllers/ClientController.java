package com.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.models.Client;
import com.library.services.ClientService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/rest/service"})
public class ClientController {
	
	@Autowired
	ClientService service;
	
	
	@GetMapping("/clients")
	public List<Client> listar(){
		return service.getAll();
		
	}
	
	@PostMapping(value ="/addClient")
	public Client add(@RequestBody Client user){
		return service.add(user);
		
	}
	
	@DeleteMapping( "/deleteClient/{id}")
	public void delete(@PathVariable int id) {
		service.delete(id);
	}
	
	@GetMapping("/client/{id}")
	public Client getUsuario(@PathVariable int id){
		return service.getById(id);
	}
	
	
	
	
	
	

}
