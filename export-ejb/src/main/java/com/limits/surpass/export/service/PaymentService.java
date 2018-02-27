package com.limits.surpass.export.service;

import java.io.File;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import com.paypal.api.payments.Invoice;
import com.paypal.api.payments.Invoices;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;

@Stateless
public class PaymentService {
	
	private Invoice invoice = null;
	
	private String accessToken = null;
	
	@PostConstruct
	public void init() throws PayPalRESTException {
		OAuthTokenCredential tokenCredential = Payment.initConfig(new File("../sdk_config.properties"));
		this.accessToken = tokenCredential.getAccessToken();
	}
	
	/**
	 * Método encargado de crear una factura
	 * @return
	 * @throws PayPalRESTException
	 */
	public Invoice create() throws PayPalRESTException {
		this.invoice = new Invoice();
		this.invoice.create(accessToken);
		return invoice;
	}
	
	/**
	 * Método que obtiene una factura
	 * @return
	 * @throws PayPalRESTException
	 */
	public Invoice retrieve() throws PayPalRESTException {
		this.invoice = Invoice.get(accessToken, this.invoice.getId());
		return invoice;
	}
	
	/**
	 * Método que obtiene todas las facturas
	 * @return
	 * @throws PayPalRESTException
	 */
	public Invoices getMerchantInvoices() throws PayPalRESTException {
		return Invoice.getAll(accessToken);
	}

}
