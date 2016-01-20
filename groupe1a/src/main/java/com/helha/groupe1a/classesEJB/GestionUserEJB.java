package com.helha.groupe1a.classesEJB;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.helha.groupe1a.entities.User;
import com.helha.groupe1a.interfacesEJB.GestionUserEJBRemote;

@Stateless
public class GestionUserEJB implements GestionUserEJBRemote{

	@EJB
	DAOUser bean;
	
	@Override
	public void add(User u) {
		bean.add(u);
	}
}