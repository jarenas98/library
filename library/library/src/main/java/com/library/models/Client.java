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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;


/**
 * 
 * @author jaren
 *
 */
@Data
@Entity(name ="CLIENT")
@Table(name = "CLIENT", schema = "library")
public class Client implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private int id;
		
	@Column(name="AGE")
	private int age;
	
	@Column(name="NAME", length=200)
	private String name;
	
	@Column(name="PHONE")
	private long phone;
	
	
	
	/** Prestamos */
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Loan> loans = new ArrayList<Loan>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}
	
	

}
