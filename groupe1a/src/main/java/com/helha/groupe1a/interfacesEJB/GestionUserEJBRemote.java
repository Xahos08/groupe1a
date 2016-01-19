package com.helha.groupe1a.interfacesEJB;

import javax.ejb.Remote;

import com.helha.groupe1a.entities.User;

@Remote
public interface GestionUserEJBRemote {
	public void addUser(User u);
}
