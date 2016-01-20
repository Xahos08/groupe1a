package com.helha.groupe1a.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("services")
public class ApplicationConfig extends ResourceConfig {

	public ApplicationConfig() {
		packages("com.helha.groupe1a.services");
	}	
}