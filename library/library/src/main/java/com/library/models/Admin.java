package com.library.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name ="ADMIN")
@Table(name = "ADMIN", schema = "library")
public class Admin {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="PASSWORD")
	private int paassword;
	
	@Column(name="USERNAME")
	private int username;

	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPaassword() {
		return paassword;
	}

	public void setPaassword(int paassword) {
		this.paassword = paassword;
	}

	public int getUsername() {
		return username;
	}

	public void setUsername(int username) {
		this.username = username;
	}
	
	
	
	
	
	

}
