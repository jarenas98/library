package com.library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.library.generic.servicesImpl.GenericServiceImpl;
import com.library.models.Loan;
import com.library.repositories.LoanRepository;

@Service
public class LoanService extends GenericServiceImpl<Loan, Integer> {

	
	@Autowired
	LoanRepository loanRepository;
	
	@Override
	public CrudRepository<Loan, Integer> getCrudRepository() {
			return this.loanRepository;
	}

}
