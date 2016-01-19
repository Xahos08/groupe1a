<<<<<<< HEAD
package com.helha.groupe1a.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import com.helha.groupe1a.classesEJB.DAOUser;
import com.helha.groupe1a.entities.User;
import com.helha.groupe1a.test.DAO;

@Named
@ManagedBean(name = "UserController")
@RequestScoped
public class UserController {
	@EJB
	private DAOUser bean;
	
	private int id;
	private String name;
	private String firstname;
	private String password;
	private Date birthDate;
	private int phone; 
	private String mail;
	private String street;
	private int number;
	private int postCode;
	private String city;
	
	public UserController(){
		
	}

	public List<User> doSelectAll() {
		return bean.selectAll();
	}
	
	public User doFind() {
		return bean.find(id);
	}
	
	public void doAdd() {
		bean.add(new User(name, firstname, password, birthDate, phone, mail, street, number, postCode, city));
		name="";
		firstname="";
		password="";
		birthDate=null;
		phone=0; 
		mail="";
		street="";
		number=0;
		postCode=0;
		city="";
	}
	
	public void doDelete() {
		bean.delete(id);
		id = 0;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getFirstname(){
		return firstname;
	}
	
	public void setFirstname(String firstname){
		this.firstname = firstname;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getBirthDate(){
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate){
		this.birthDate = birthDate;
	}
	
	public int getPhone(){
		return phone;
	}
	
	public void setPhone(int phone){
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public int getNumber(){
		return number;
	}
	
	public void setNumber(int number){
		this.number = number;
	}
	
	public int getPostCode(){
		return postCode;
	}
	
	public void setPostCode(int postCode){
		this.postCode = postCode;
	}
	
	public String getCity(){
		return city;
	}
	
	public void setCity(String city){
		this.city = city;
	}
}
=======
package com.helha.groupe1a.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import com.helha.groupe1a.entities.User;
import com.helha.groupe1a.test.DAO;

@Named
@ManagedBean(name = "UserController")
@RequestScoped
public class UserController {
	@EJB
	private DAO bean;
	
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
	
	public UserController(){
		
	}

/*	public List<User> doSelectAll() {
		return bean.getUsersList();
	}
	
	public User doFind() {
		return bean.getUserById(id);
	}*/
	
	public void doAdd() {
		bean.addUser(new User(name, firstname, password, birthDate, phone, mail, street, number, postCode, city));
	}
	
	public void doDelete() {
		//bean.deleteUser(id);
		id = 0;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getFirstname(){
		return firstname;
	}
	
	public void setFirstname(String firstname){
		this.firstname = firstname;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getBirthDate(){
		return birthDate;
	}
	
	public void setBirthDate(String birthDate){
		this.birthDate = birthDate;
	}
	
	public int getPhone(){
		return phone;
	}
	
	public void setPhone(int phone){
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public int getNumber(){
		return number;
	}
	
	public void setNumber(int number){
		this.number = number;
	}
	
	public int getPostCode(){
		return postCode;
	}
	
	public void setPostCode(int postCode){
		this.postCode = postCode;
	}
	
	public String getCity(){
		return city;
	}
	
	public void setCity(String city){
		this.city = city;
	}
}
>>>>>>> branch 'master' of https://github.com/Xahos08/groupe1a.git
