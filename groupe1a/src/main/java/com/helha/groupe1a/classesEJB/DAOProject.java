package com.helha.groupe1a.classesEJB;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.helha.groupe1a.entities.Project;

@Stateless
@LocalBean
public class DAOProject {
	
	@PersistenceContext(unitName = "groupe1")
	private EntityManager em;
	
	public void add(Project p) {
		em.persist(p);
	}
	
	public List<Project> selectAll() {
		Query qSelectAll = em.createQuery("SELECT p FROM Project p");
		
		return qSelectAll.getResultList();
	}
	
	public Project find(int id) {
		Query qFind = em.createQuery("SELECT p FROM Project p WHERE p.id = ?1");
		
		qFind.setParameter(1, id);
		
		return (Project) qFind.getSingleResult();
	}
	
	public void delete(int id) {
		Query qDelete = em.createQuery("DELETE FROM Project p WHERE p.id = ?1");
		
		qDelete.setParameter(1, id);
		qDelete.executeUpdate();
	}
}