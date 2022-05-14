package com.evaluacion.servidor.servicioSOAP;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class coneccionClienteSOAP extends WebServiceGatewaySupport {
	/**
	 * Calling services of Endpoint SOAP
	 * 
	 * @param url
	 * @param request
	 * @return Object
	 */
	public Object callWebServices(String url, Object request) {
		return getWebServiceTemplate().marshalSendAndReceive(url, request);
	}

}