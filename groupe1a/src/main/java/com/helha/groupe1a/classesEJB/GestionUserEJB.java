package com.helha.groupe1a.classesEJB;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.helha.groupe1a.entities.User;
import com.helha.groupe1a.interfacesEJB.GestionUserEJBRemote;
import com.helha.groupe1a.test.DAO;

@Stateless
public class GestionUserEJB implements GestionUserEJBRemote{

	@EJB
	DAO bean;
	
	@Override
	public void add(User u) {
		bean.addUser(u);
	}
}
