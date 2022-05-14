package com.evaluacion.servidor.com.servicioSOAP;

import org.springframework.context.annotation.Configuration;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@Configuration
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
	/*
    public ValidarNitResponse getValidacion(String nit) {
        ValidarNit request = new ValidarNit();
        request.setNit(nit);

        ValidarNitResponse response = (ValidarNitResponse) getWebServiceTemplate()
          .marshalSendAndReceive(request);
        return response;
    }
	*/

}