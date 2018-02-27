package com.limits.surpass.export.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import org.primefaces.event.FlowEvent;

import com.limits.surpass.export.core.InscriptionFacade;
import com.limits.surpass.export.core.LoginFacade;
import com.limits.surpass.export.model.Gender;
import com.limits.surpass.export.model.Inscription;
import com.limits.surpass.export.model.Login;
import com.limits.surpass.export.util.FacesUtil;

@ManagedBean
@ViewScoped
public class InscriptionBean {

	private Inscription inscription;
	
	private List<SelectItem> genderItems = new ArrayList<SelectItem>();

	private Login login;
	
	@Inject
	private LoginFacade loginSecure;

	@Inject
	private InscriptionFacade inscriptionApp;
	
	@PostConstruct
	public void init() {
		inscription = new Inscription();
		login = new Login();
		genderItems.add(new SelectItem(Gender.MALE));
		genderItems.add(new SelectItem(Gender.FEMALE));
	}
	
	public String onFlowProcess(FlowEvent event) {
		return event.getNewStep();
	}
	

	public void save() {
		try {
			inscription.setInscriptionDate(new Date());
			login.setInscription(inscription);
			loginSecure.save(login);
			FacesUtil.addMessage(FacesMessage.SEVERITY_INFO, "La inscripción fue realizada exitosamente");
		} catch (Exception e) {
			FacesUtil.addMessage(FacesMessage.SEVERITY_ERROR, "No se pudo almacenar la inscripción" + e.getMessage());
		}
	}
	
	public void update() {
		
	}

	public Inscription getInscription() {
		return inscription;
	}

	public Login getLogin() {
		return login;
	}

	public List<SelectItem> getGenderItems() {
		return genderItems;
	}

	public List<Inscription> getInscriptionList() throws Exception {
		return inscriptionApp.findAll();
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public void setGenderItems(List<SelectItem> genderItems) {
		this.genderItems = genderItems;
	}

}
