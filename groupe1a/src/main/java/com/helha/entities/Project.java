package com.helha.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String category;
	private String name;
	private double amountExpected;
	private double amountEarned;
	private Date dateBegin;
	private Date dateEnd;
	
	public Project() {
		
	}

	public Project(String category, String name, double amountExpected,double amountEarned,Date dateBegin,Date dateEnd)
	{
		this.category = category;
		this.name = name;
		this.amountExpected = amountExpected;
		this.amountEarned = amountEarned;
		this.dateBegin = dateBegin;
		this.dateEnd = dateEnd;
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

	public Date getDateBegin() {
		return dateBegin;
	}

	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public int getId() {
		return id;
	}
	
	public String toString()
	{
		return "Project [id=" + id + ", name=" + name + ", category=" + category + ", amountExpected=" + amountExpected + ", amountEarned=" + amountEarned +",dateBegin="+dateBegin+",dateEnd="+dateEnd+"]";
	}
}
