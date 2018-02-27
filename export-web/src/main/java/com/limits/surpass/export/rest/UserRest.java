package com.limits.surpass.export.rest;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.limits.surpass.export.model.User;

@Path("/user")
public class UserRest {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed("admin")
	public User obtainGenericUser() {
		User user = new User();
		user.setUsername("ejemplo");
		user.setPassword("ejemplo");
		return user;
	}
}
