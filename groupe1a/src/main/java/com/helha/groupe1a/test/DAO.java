
package com.helha.groupe1a.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.helha.groupe1a.entities.Project;
import com.helha.groupe1a.entities.User;

public class DAO 
{
	private EntityManagerFactory emf;
	private EntityManager em;
	private static DAO instance = null;
	
	private DAO()
	{
		emf = Persistence.createEntityManagerFactory("groupe1Local");
		em = emf.createEntityManager();
		
	}
	
	public static DAO getInstance()
	{
		if(instance == null)
			instance = new DAO();
		return instance;
	}
	
	
	
	/**
	 * Return projects list from database
	 * @return List<Project>
	 */
	public List<Project> getProjectsList()
	{
		Query query = em.createQuery("select p from Project p "); 
		return query.getResultList();
		
	}
	
	
	
	/**
	 * Search a project with its name and return the selected list
	 * @param string nom
	 * @return List<Project>
	 */
	public List<Project> getProject(String name)
	{
		//j'obtiens tous mes publications
		List<Project> projects = getProjectsList();
		List<Project> projectsCopy = new ArrayList<Project>(projects.size());
		
		//tester si le nom contient la chaine de caractere name 
		//TODO 
		for(int i=0;i<projects.size();i++)
		{

			if(projects.get(i).getName().equals(name))
				projectsCopy.add(projects.get(i));	

		}	
		return projectsCopy;
	}
	
	
	/**
	 * Search a project by id
	 * @param int id
	 * @return Project
	 */
	public Project getProjectById(int id)
	{
		Query query = em.createQuery("select p from Project p where p.id ='"+id+"'"); 
		
		return (Project) query.getSingleResult();
	}
	
	
	
	
	/**
	 * Search projects with same category
	 * @param string category
	 * @return List<Project>
	 */
	public List<Project> getCategoryProjects(String category)
	{
		//j'obtiens tous mes publications
		List<Project> projects = getProjectsList();
		List<Project> projectsCopy = new ArrayList<Project>(projects.size());
		
		//tester si la categorie est celle recherchee
		for(int i=0;i<projects.size();i++)
		{
			if(projects.get(i).getCategory().equals(category))
				projectsCopy.add(projects.get(i));	
		}	
		return projectsCopy;
	}
	
	
	
	
	/**
	 * Add a projetct to database
	 * @param Project p
	 * @return true if the project is added, false is not
	 */
	public boolean addProject(Project p)
	{
		EntityTransaction tx = em.getTransaction();				
		tx.begin();
		
		
		
		em.persist(p);
		tx.commit();
		return true;
		

	}
	
	
	
	/**
	 * Delete a project from database
	 * @param Project p
	 * @return true if project is deleted, false is not
	 */
	public boolean deleteProject(Project p)
	{
		EntityTransaction tx = em.getTransaction();	
		tx.begin();
		
		if(p != null)
		{
			em.remove(p);
			tx.commit();
			return true;
		}
		return false;
	}
	
	// ************************************************************** Users methods ***********************************************************************************//
	
	
	/**
	 * Return users list from database
	 * @return List<User>
	 */
	public List<User> getUsersList()
	{
		Query query = em.createQuery("select u from User u");
		return query.getResultList();
	}
	
	
	/**
	 * Add a user to database
	 * @param User u
	 * @return true if the user is added, false is not
	 */
	public boolean addUser(User u)
	{
		EntityTransaction tx = em.getTransaction();				
		tx.begin();
		
		em.persist(u);
		tx.commit();
		return true;
		

	}
	
	
	/**
	 * Research a user by name
	 * @param String name
	 * @return User user
	 */
	public User getUser(String name)
	{
		//une seule occurence possible 
		Query query = em.createQuery("select u from User u where u.nom='"+ name + "'");
						
		User user = (User) query.getSingleResult();
						
		return user;
	}
	
	
	
	/**
	 * Replace name's user 
	 * @param String name1, user'name
	 * @param String name2, replace name
	 * @return true if name has replaced, false if not
	 */
	public boolean replaceUserName(String name1,String name2)
	{
		User user = getUser(name1);
		
		if(user != null)
		{
			em.merge(user);
			user.setName(name2);
			return true;
		}
		return false;
	}
	
	
	/**
	 * Delete a user from database
	 * @param User u
	 * @return true if user is deleted, false is not
	 */
	public boolean deleteUser(User u)
	{
		EntityTransaction tx = em.getTransaction();	
		tx.begin();
		
		if(u != null)
		{
			em.remove(u);
			tx.commit();
			return true;
		}
		return false;
	}
	
	/**
	 * Search a user by id
	 * @param int id
	 * @return User
	 */
	public User getUserById(int id)
	{
		Query query = em.createQuery("select u from User u where u.id ='"+id+"'"); 
		
		return (User) query.getSingleResult();
	}
	
}




