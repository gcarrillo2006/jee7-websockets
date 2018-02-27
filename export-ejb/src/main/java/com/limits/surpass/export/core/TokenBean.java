package com.limits.surpass.export.core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.Stateless;

import com.limits.surpass.export.model.Token;
import com.limits.surpass.export.model.TokenType;

@Stateless
public class TokenBean {
	
	private String generateToken(String val1, String val2) {
		char[] val1Char = val1.toCharArray();
		char[] resultChar = val1.toCharArray();
		Integer value = obtainValue(val2);
		int i = 0;
		for (char character : val1Char) {
			if (i%2 == 0) {
				resultChar[i] = (char)(Integer.parseInt(String.format("%04x", (int)character), 16) + value);
			} else {
				resultChar[i] = (char)(Integer.parseInt(String.format("%04x", (int)character), 16) + i%2);
			}
			i++;
		}
		return new String(resultChar);
	}

	private Integer obtainValue(String val2) {
		Integer value = 0;
		for(char character : val2.toCharArray()) {
			value = value + Character.getNumericValue(character);
		}
		return value;
	}
	
	public Token obtainToken(String username, String password) {
		//TODO validate login
		Token token = new Token();
		token.setUsername(username);
		DateFormat df = new SimpleDateFormat("HHmm");
		token.setGenerated(new Date().getTime());
		token.setToken(generateToken(username, df.format(new Date(token.getGenerated()))));
		return token;
	}
	
	public TokenType validateToken(Token token) {
		DateFormat df = new SimpleDateFormat("HH");
		TokenType flag; 
		if (df.format(new Date(token.getGenerated())).compareTo(df.format(new Date())) == 0) {
			flag = checkToken(token);
		} else {
			flag = checkToken(token);
			if (flag == TokenType.VALID)
				flag = TokenType.EXPIRED;
		}
		return flag;
	}

	private TokenType checkToken(Token token) {
		DateFormat df;
		TokenType flag;
		df = new SimpleDateFormat("HHmm");
		Integer value = obtainValue(df.format(new Date(token.getGenerated())));
		char[] resultChar = token.getToken().toCharArray();
		char[] originalChar =  token.getToken().toCharArray();
		int i = 0;
		for (char character : resultChar) {
			if (i%2 == 0) {
				originalChar[i] = (char)(Integer.parseInt(String.format("%04x", (int)character), 16) - value);
			} else {
				originalChar[i] = (char)(Integer.parseInt(String.format("%04x", (int)character), 16) - i%2);
			}
			i++;
		}
		if (token.getUsername().equals(new String(originalChar)))
			flag = TokenType.VALID;
		else 
			flag = TokenType.INVALID;
		return flag;
	}

}
