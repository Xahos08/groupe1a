package com.helha.groupe1a.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.helha.groupe1a.classesEJB.DAOUser;
import com.helha.groupe1a.entities.User;


@Path("/api")
public class RestUser {
	@EJB
	DAOUser bean;
	
	@Path("/selectAll")
	@GET
	public List<User> selectAll() {
		return bean.selectAll();
	}
	
	@Path("/find/{id}")
	@GET
	public User find(@PathParam("id")int id) {
		return bean.find(id);
	}
	
	@Path("/delete/{id}")
	@DELETE
	public void delete(@PathParam("id")int id) {
		bean.delete(id);
	}
	
	@Path("/add")
	@POST
	public User add(User u) {
		bean.add(u);
		return u;
	}

}