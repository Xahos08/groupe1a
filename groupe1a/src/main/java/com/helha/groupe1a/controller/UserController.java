package com.helha.groupe1a.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.helha.groupe1a.classesEJB.DAOUser;
import com.helha.groupe1a.entities.User;

@Named
@ManagedBean(name = "UserController")
@RequestScoped
public class UserController {
	@EJB
	private DAOUser bean;
	private User userConnected;
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
	
	public boolean isConnect(){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session = request.getSession(true);
		System.out.println("PRESET ID"+session.getAttribute("idUser"));
		if(session.getAttribute("idUser")!=null){
			int userID = (int)session.getAttribute("idUser");
			if(userID > 0){
				return true;
			}else{
				return false;
			}
		}else return false;
	}
	public String connect(){
		//Récupération des informations login, mot de passe et confirmation du mot de passe
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		String rEmail    = (String)request.getParameter("loginUser:email");
		String rPassword = (String)request.getParameter("loginUser:password");

		userConnected = bean.find(rEmail);
		
		if(userConnected != null){
			HttpSession session = request.getSession(true);
			session.setAttribute("idUser",userConnected.getId());
			System.out.println("ID SESSION"+session.getAttribute("idUser"));
		}else{
			System.out.println("L'utilisateur n'existe pas");
		}
		return "index.xhtml";
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
	
	public String getStreet(){
		return street;
	}
	public void setStreet(String street){
		this.street = street;
	}
}
