package com.limits.surpass.export.model;

import java.util.Date;

public class Token {
	
	private String username;
	
	private String token;
	
	private Long generated;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the generated
	 */
	public Long getGenerated() {
		return generated;
	}

	/**
	 * @param generated the generated to set
	 */
	public void setGenerated(Long generated) {
		this.generated = generated;
	}
	
}
