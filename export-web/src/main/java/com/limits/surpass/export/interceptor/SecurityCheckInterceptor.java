package com.limits.surpass.export.interceptor;

import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

import com.limits.surpass.export.annotation.SecurityChecked;
import com.limits.surpass.export.core.TokenBean;
import com.limits.surpass.export.model.Token;
import com.limits.surpass.export.model.TokenType;

@SecurityChecked
@Provider
public class SecurityCheckInterceptor implements ContainerRequestFilter {

	@Inject
	private TokenBean tokenBean;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		Token headerToken = new Token();
		if (requestContext.getHeaderString("generated") == null)
			throw new NotAuthorizedException(TokenType.INVALID);
		headerToken.setGenerated(new Long(requestContext.getHeaderString("generated")));
		headerToken.setToken(requestContext.getHeaderString("token"));
		headerToken.setUsername(requestContext.getHeaderString("username"));
		if (TokenType.INVALID == tokenBean.validateToken(headerToken))
			throw new NotAuthorizedException(TokenType.INVALID);
	}

}
