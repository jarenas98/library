package com.library.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity(name = "BOOK")
@Table(name = "BOOK", schema = "library")
public class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="PORTADA")
	private String portada;
	
	@Column(name="REQUIRED_AGE")
	private int requiredAge;
	
	@Column(name="STATE")
	private Boolean state;
	
	
	/** the Loans */
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
	private List<Loan> loans = new ArrayList<Loan>();
	
	
	/** The category. */
	@ManyToOne
	@JsonIgnore
	private Category category;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getRequiredAge() {
		return requiredAge;
	}


	public void setRequiredAge(int requiredAge) {
		this.requiredAge = requiredAge;
	}


	public Boolean getState() {
		return state;
	}


	public void setState(Boolean state) {
		this.state = state;
	}


	public List<Loan> getLoans() {
		return loans;
	}


	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public String getPortada() {
		return portada;
	}


	public void setPortada(String portada) {
		this.portada = portada;
	}
	
	
	
	
	
}
