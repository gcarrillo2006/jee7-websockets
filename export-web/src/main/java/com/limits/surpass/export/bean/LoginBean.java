package com.limits.surpass.export.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;

import com.limits.surpass.export.core.LoginFacade;
import com.limits.surpass.export.util.FacesUtil;

@ManagedBean
@SessionScoped
public class LoginBean {
	
	private boolean loggedIn;
	
	private String username;
	
	private String password;
	
	@Inject
	private LoginFacade loginSecurity;
	
	public String login() {
		String page = null;
		loggedIn = loginSecurity.validateAccess(username, password);
		if (loggedIn) {
			page = "productList";
			try {
				FacesUtil.getHttpServletRequest().login(username, password);
			} catch (ServletException e) {
				FacesUtil.addMessage(FacesMessage.SEVERITY_INFO, "Falló la authenticación");
			}
			if (username == "admin") {
				page = "inscriptionList";
			}
		}
		return page;
	}
	
	public String inscription() {
		return "inscription";
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
