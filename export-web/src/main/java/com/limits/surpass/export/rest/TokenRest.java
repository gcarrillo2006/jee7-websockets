package com.limits.surpass.export.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.limits.surpass.export.core.TokenBean;
import com.limits.surpass.export.model.Token;
import com.limits.surpass.export.model.TokenType;
import com.limits.surpass.export.model.User;

@Path("/token")
public class TokenRest {
	
	@Inject
	private TokenBean tokenBean;

	@PUT
	@Path("/generate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Token obtainToken(User user) {
		return tokenBean.obtainToken(user.getUsername(), user.getPassword());
	}
	
	@PUT
	@Path("/validate")
	@Produces(MediaType.APPLICATION_JSON)
	public TokenType validateToken(@HeaderParam("token")String token, @HeaderParam("username")String username, @HeaderParam("generated")Long generated) {
		Token headerToken = new Token();
		headerToken.setGenerated(generated);
		headerToken.setToken(token);
		headerToken.setUsername(username);
		return tokenBean.validateToken(headerToken);
	}
	
}
