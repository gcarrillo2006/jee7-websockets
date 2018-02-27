package com.limits.surpass.export.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Utilitarios de JSF
 * 
 * @author german
 *
 */
public class FacesUtil {

	private static FacesMessage message;
	
	/**
	 * Obtener el servlet request
	 * 
	 * @return
	 */
	public static HttpServletRequest getHttpServletRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	/**
	 * Obtener el contexto de un servlet
	 * 
	 * @return
	 */
	public static ExternalContext getExternalContext() {
		return FacesContext.getCurrentInstance().getExternalContext();
	}

	/**
	 * Registrar un mensaje para presentarlo en pantalla
	 * 
	 * @param severity
	 * @param text
	 */
	public static void addMessage(Severity severity, String text) {
		message = new FacesMessage();
		message.setSeverity(severity);
		message.setSummary(text);
		
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	/**
	 * Recupera un parameto de un session bean
	 * 
	 * @param bean
	 * @return
	 */
	public static Object recoverParameterSessionBean(String bean) {
		return getExternalContext().getSessionMap().get(bean);
	}

	/**
	 * Recupera un parametro al utilizar f:param
	 * 
	 * @param string
	 * @return
	 */
	public static String recoverParameter(String string) {
		return getExternalContext().getRequestParameterMap().get(string);
	}

}
