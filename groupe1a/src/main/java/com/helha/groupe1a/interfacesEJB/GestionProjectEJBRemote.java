package com.helha.groupe1a.interfacesEJB;

import javax.ejb.Remote;

import com.helha.groupe1a.entities.Project;

@Remote
public interface GestionProjectEJBRemote {
	public void add(Project p);
}
