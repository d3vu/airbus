package com.telusko;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class userData {
	
	@Override
	public String toString() {
		return "userData [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public userData(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public userData() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	

}
