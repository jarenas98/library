package com.library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.library.generic.servicesImpl.GenericServiceImpl;
import com.library.models.Admin;
import com.library.repositories.AdminRepository;

@Service
public class AdminService extends GenericServiceImpl<Admin, Integer> {

	@Autowired
	AdminRepository adminRepository;
	
	@Override
	public CrudRepository<Admin, Integer> getCrudRepository() {
		
		return this.adminRepository;
	}

}
