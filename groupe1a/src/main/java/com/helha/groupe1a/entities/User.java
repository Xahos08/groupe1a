package com.helha.groupe1a.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String firstname;
	private String password;
	private String birthDate;
	private int phone; 
	private String mail;
	private String street;
	private int number;
	private int postCode;
	private String city;
	
	public User()
	{
		
	}
	
	public User(String name, String firstname, String password, String birthDate, int phone, String mail, String street,
			int number, int postCode, String city) {
		super();
		this.name = name;
		this.firstname = firstname;
		this.password = password;
		this.birthDate = birthDate;
		this.phone = phone;
		this.mail = mail;
		this.street = street;
		this.number = number;
		this.postCode = postCode;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof User)
		{
			User u = (User) obj;
			return u.id == this.id;
		}
		return false;
	}
	
	
	
	
	
	
	
}
