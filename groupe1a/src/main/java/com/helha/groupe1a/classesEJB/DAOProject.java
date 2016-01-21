package com.helha.groupe1a.classesEJB;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
		try {
			return (Project) qFind.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
	
	public void delete(int id) {
		Query qDelete = em.createQuery("DELETE FROM Project p WHERE p.id = ?1");
		
		qDelete.setParameter(1, id);
		qDelete.executeUpdate();
	}
	
	public void setAmountEarned(int id, double amountEarned){
		System.out.println("YOLO"+id+"      "+amountEarned);
		Query qSetAmountEarned = em.createQuery("UPDATE Project p SET p.amountEarned = ?1 WHERE p.id = ?2 ");
		qSetAmountEarned.setParameter(1, amountEarned);
		qSetAmountEarned.setParameter(2, (Integer)id);
		qSetAmountEarned.executeUpdate();
	}
}