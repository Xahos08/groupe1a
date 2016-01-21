package com.helha.groupe1a.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.helha.groupe1a.classesEJB.DAOProject;
import com.helha.groupe1a.entities.Project;

@Named
@ManagedBean(name = "ProjectController")
@RequestScoped
public class ProjectController {
	@EJB
	private DAOProject bean;
	
	private int id;
	
	private String category;
	private String name;
	private double amountExpected;
	private double amountEarned;
	private String dateBegin;
	private String dateEnd;
	
	//Argent payer par un utilisateur
	private double back;

	public ProjectController(){
		
	}
	public List<Project> doSelectAll(){
		return bean.selectAll();
	}
	public Project doFind() {
		id = 3;
		bean.find(id);
		System.out.println(bean.find(id).getName());
		return bean.find(id);
	}
	
	public void doAdd() {
		bean.add(new Project(category,name,amountExpected,amountEarned,dateBegin,dateEnd));
		name = "";
		category = "";
		dateBegin = null;
		dateEnd=null;
		amountExpected=0;
		amountEarned=0;
		id=0;
	}
	
	public String projectDetails(){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		id = Integer.parseInt(request.getParameter("id"));
		if(id>0){
			Project proj;
			proj = doFind();
			name = proj.getName();
			category = proj.getCategory();
			dateBegin = proj.getDateBegin();
			dateEnd = proj.getDateEnd();
			amountExpected = proj.getAmountExpected();
			amountEarned = proj.getAmountEarned();
		}else{
			name = "AUCUNE VALEUR";
			category = "AUCUNE VALEUR";
			dateBegin = "AUCUNE VALEUR";
			dateEnd = "AUCUNE VALEUR";
			amountExpected = 0;
			amountEarned = 0;
		}
		HttpSession session = request.getSession(true);
		System.out.println("ID SESSION AGAIN"+session.getAttribute("idUser"));
		return "projectDetails.xhtml";
	}
	
	public String backThisProject(){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String backStr = (String)request.getParameter("giveback:back");
		//System.out.println("************BACK_STR"+backStr);
		back = Integer.parseInt(backStr);
		Project proj = doFind();
		//System.out.println("*********************ID"+id);
		//System.out.println("*********************back"+back);
		//System.out.println("*********************ID"+nid);
		amountEarned = proj.getAmountEarned()+back;
		bean.setAmountEarned(id, amountEarned);
		return "projects.xhtml";
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAmountExpected() {
		return amountExpected;
	}
	public void setAmountExpected(double amountExpected) {
		this.amountExpected = amountExpected;
	}
	public double getAmountEarned() {
		return amountEarned;
	}
	public void setAmountEarned(double amountEarned) {
		this.amountEarned = amountEarned;
	}
	public String getDateBegin() {
		return dateBegin;
	}
	public void setDateBegin(String dateBegin) {
		this.dateBegin = dateBegin;
	}
	public String getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}
	public double getBack() {
		return back;
	}
	public void setBack(double back) {
		this.back = back;
	}
}