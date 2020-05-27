package com.library.repositories;

import org.springframework.data.repository.CrudRepository;

import com.library.models.Admin;

public interface AdminRepository extends CrudRepository<Admin, Integer> {

}
