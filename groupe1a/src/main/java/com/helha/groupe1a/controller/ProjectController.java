package com.helha.groupe1a.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

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
	
	public ProjectController(){
		
	}
	public List<Project> doSelectAll(){
		return bean.selectAll();
	}
	public Project doFind() {
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
}