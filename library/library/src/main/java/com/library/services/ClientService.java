package com.library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.library.generic.servicesImpl.GenericServiceImpl;
import com.library.models.Client;
import com.library.repositories.ClientRepository;

@Service
public class ClientService extends GenericServiceImpl<Client, Integer>{

	@Autowired
	ClientRepository clientRepository;
	
	
	@Override
	public CrudRepository<Client, Integer> getCrudRepository() {
				return this.clientRepository;
	}

}
