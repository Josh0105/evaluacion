package com.evaluacion.servidor.servicioSOAP;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;



public class configuracionSOAP {
	
	@Value("${WSDL.ClientEndpoint}")
	private String clientEndpoint;

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.evaluacion.servidor.com.claro");
		return marshaller;
	}

	@Bean
	public coneccionClienteSOAP soapconnector(Jaxb2Marshaller marshaller) {
		coneccionClienteSOAP client = new coneccionClienteSOAP();
		client.setDefaultUri(clientEndpoint);
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}