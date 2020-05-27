package com.library.repositories;

import org.springframework.data.repository.CrudRepository;

import com.library.models.Loan;

public interface LoanRepository extends CrudRepository<Loan, Integer> {

}
