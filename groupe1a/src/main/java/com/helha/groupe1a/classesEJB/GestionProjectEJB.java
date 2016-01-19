package com.helha.groupe1a.classesEJB;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.helha.groupe1a.entities.Project;
import com.helha.groupe1a.entities.User;
import com.helha.groupe1a.interfacesEJB.GestionProjectEJBRemote;
import com.helha.groupe1a.interfacesEJB.GestionUserEJBRemote;

@Stateless
public class GestionProjectEJB implements GestionProjectEJBRemote{

	@EJB
	DAOProject bean;
	
	@Override
	public void add(Project p) {
		bean.add(p);
	}
}