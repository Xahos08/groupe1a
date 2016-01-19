<<<<<<< HEAD
package com.helha.groupe1a.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.helha.groupe1a.classesEJB.DAOProject;
import com.helha.groupe1a.entities.Project;


@Path("/api")
public class RestProject {
	@EJB
	DAOProject bean;
	
	@Path("/selectAll")
	@GET
	public List<Project> selectAll() {
		return bean.selectAll();
	}
	
	@Path("/find/{id}")
	@GET
	public Project find(@PathParam("id")int id) {
		return bean.find(id);
	}
	
	@Path("/delete/{id}")
	@DELETE
	public void delete(@PathParam("id")int id) {
		bean.delete(id);
	}
	
	@Path("/add")
	@POST
	public Project add(Project p) {
		bean.add(p);
		return p;
	}

=======
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
>>>>>>> branch 'master' of https://github.com/Xahos08/groupe1a.git
}