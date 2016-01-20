package com.helha.groupe1a.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.helha.groupe1a.classesEJB.DAOProject;
import com.helha.groupe1a.classesEJB.DAOUser;
import com.helha.groupe1a.entities.Project;
import com.helha.groupe1a.entities.User;

@Path("/api")
public class RestServices {
	
	@EJB
	DAOUser beanUser;
	
	@EJB
	DAOProject beanProject;
	

	/* ***************************************************** REST USER ***************************************** */
	
	
	@Path("/selectAllUsers")
	@GET
	public List<User> selectAllUsers() {
		return beanUser.selectAll();
	}
	
	@Path("/findUser/{id}")
	@GET
	public User findUser(@PathParam("id")int id) {
		return beanUser.find(id);
	}
	
	@Path("/deleteUser/{id}")
	@DELETE
	public void deleteUser(@PathParam("id")int id) {
		beanUser.delete(id);
	}
	
	@Path("/addUser")
	@POST
	public User addUser(User u) {
		beanUser.add(u);
		return u;
	}
	
	
	/* ***************************************************** REST PROJECT ***************************************** */
	
	
	@Path("/selectAllProjects")
	@GET
	public List<Project> selectAllProjects() {
		return beanProject.selectAll();
	}
	
	@Path("/findProject/{id}")
	@GET
	public Project findProject(@PathParam("id")int id) {
		return beanProject.find(id);
	}
	
	@Path("/deleteProject/{id}")
	@DELETE
	public void deleteProject(@PathParam("id")int id) {
		beanProject.delete(id);
	}
	
	@Path("/addProject")
	@POST
	public Project addProject(Project p) {
		beanProject.add(p);
		return p;
	}
}
