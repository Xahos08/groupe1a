package com.helha.groupe1a.entities;

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
	private String dateBegin;
	private String dateEnd;
	
	public Project() {
		
	}

	public Project(String category, String name, double amountExpected,double amountEarned,String dateBegin,String dateEnd)
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

	public int getId() {
		return id;
	}
	
	public String toString()
	{
		return "Project [id=" + id + ", name=" + name + ", category=" + category + ", amountExpected=" + amountExpected + ", amountEarned=" + amountEarned +",dateBegin="+dateBegin+",dateEnd="+dateEnd+"]";
	}
	
	
	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof Project)
		{
			Project p = (Project) obj;
			return p.id == this.id;
		}
		return false;
	}
}
