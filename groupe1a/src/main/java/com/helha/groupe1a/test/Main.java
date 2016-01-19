package com.helha.groupe1a.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.helha.groupe1a.entities.Project;

public class Main
{
	
	public static void main(String[] args)
	{
		
		
		
		
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("groupe1Local");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
	
		Project p1 = new Project("Categorie","nom",5.,5., new Date(), new Date());
				
		em.persist(p1);
	
	
		tx.commit();
		
		emf.close();
	}
		
	
		
	

}

