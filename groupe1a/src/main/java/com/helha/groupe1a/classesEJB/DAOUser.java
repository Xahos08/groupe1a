package com.helha.groupe1a.classesEJB;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.helha.groupe1a.entities.User;

@Stateless
@LocalBean
public class DAOUser {
	
	@PersistenceContext(unitName = "groupe1")
	private EntityManager em;
	
	public void add(User u) {
		em.persist(u);
	}
	
	public List<User> selectAll() {
		Query qSelectAll = em.createQuery("SELECT u FROM User u");
		
		return qSelectAll.getResultList();
	}
	
	public User find(int id) {
		Query qFind = em.createQuery("SELECT u FROM User u WHERE u.id = ?1");
		
		qFind.setParameter(1, id);
		
		return (User) qFind.getSingleResult();
	}
	
	public void delete(int id) {
		Query qDelete = em.createQuery("DELETE FROM User u WHERE u.id = ?1");
		
		qDelete.setParameter(1, id);
		qDelete.executeUpdate();
	}
}