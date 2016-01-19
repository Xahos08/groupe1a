package com.helha.groupe1a.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.helha.groupe1a.entities.Project;
import com.helha.groupe1a.test.DAO;


@Path("/api")
public class RestProject {
	/*@EJB
	DAO bean;
	
	@Path("/selectAll")
	@GET
	public List<Project> selectAll() {
		return bean.selectAllProject();
	}
	@Path("/find/{name}")
	@GET
	public List<Project> find(@PathParam("name")String name) {
		return bean.getProject(name);
	}
	
	@Path("/delete")
	@DELETE
	public Project delete(Project p) {
		bean.deleteProject(p);
		return p;
	}
	
	@Path("/add")
	@POST
	public Project add(Project p) {
		bean.addProject(p);
		return p;
	}
*/
}