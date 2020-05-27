package com.library.repositories;

import org.springframework.data.repository.CrudRepository;

import com.library.models.Client;

public interface ClientRepository extends CrudRepository<Client, Integer>{

}
