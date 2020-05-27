package com.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.models.Book;
import com.library.models.Category;
import com.library.models.Loan;
import com.library.models.Client;
import com.library.services.BookService;
import com.library.services.CategoryService;
import com.library.services.LoanService;
import com.library.services.ClientService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({ "/rest/service" })
public class BookController {

	@Autowired
	BookService bookService;

	@Autowired
	LoanService loanService;

	@Autowired
	ClientService userService;
	
	@Autowired
	CategoryService categoryService;

	@GetMapping("/books")
	public List<Book> listar() {
		return bookService.getAll();

	}

	@PostMapping(value = "/addBook")
	public ResponseEntity<Book> add(@RequestBody Book book,
			@RequestParam(name = "idcategory", required = false, defaultValue = "null") Integer idcategory) {
		
		Category category= categoryService.getById(idcategory);
		
		book.setCategory(category);
		
		Book bookg=bookService.add(book);
		return new ResponseEntity<Book>(bookg, HttpStatus.CREATED);

	}

	@DeleteMapping("/deleteBook/{id}")
	public void delete(@PathVariable int id) {
		bookService.delete(id);
	}

	@GetMapping("/book/{id}")
	public Book getUsuario(@PathVariable int id) {
		return bookService.getById(id);
	}

	@GetMapping("/addLoan")
	public ResponseEntity<Loan> addLoan(
			@RequestParam(name = "idclient", required = false, defaultValue = "null") Integer iduser,
			@RequestParam(name = "idbook", defaultValue = "null") Integer idbook,
			@RequestParam(name = "loand", defaultValue = "null") String loand) {

		Book book = bookService.getById(idbook);
		Client client = userService.getById(iduser);
	

		if (!book.getState() && client.getAge()>=book.getId()) {
			book.setState(true);

			Loan loan = new Loan();
			loan.setBook(book);
			loan.setUser(client);
			loan.setLoanDate(loand);

			loanService.add(loan);
			bookService.add(book);

			return new ResponseEntity<Loan>(loan, HttpStatus.CREATED);

		}
		return new ResponseEntity<Loan>(new Loan(), HttpStatus.NOT_MODIFIED);

	}

	@GetMapping("/deliveryLoan")
	public ResponseEntity<Loan> deliveryLoan(
			@RequestParam(name = "idLoan", required = false, defaultValue = "null") Integer idLoan,
			@RequestParam(name = "deliveryd", required = false, defaultValue = "null") String deliveryd) {

		Loan loan = loanService.getById(idLoan);

		if (loan.getBook().getState()) {
			Book book = loan.getBook();
			book.setState(false);

			loan.setDeliveryDate(deliveryd);

			bookService.add(book);
			loanService.add(loan);

			return new ResponseEntity<Loan>(loan, HttpStatus.OK);

		}
		return new ResponseEntity<Loan>(loan, HttpStatus.NOT_MODIFIED);
	}

}
