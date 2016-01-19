package com.helha.groupe1a.classesEJB;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.helha.groupe1a.entities.User;
import com.helha.groupe1a.interfacesEJB.GestionUserEJBRemote;

@Stateless
public class GestionUserEJB implements GestionUserEJBRemote{

	@EJB
	DAO bean;
	
	@Override
	public void addUser(User u) {
		bean.addUser(u);
	}
}
