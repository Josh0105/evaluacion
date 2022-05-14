package com.evaluacion.servidor.com.servicioSOAP;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;


//@Configuration
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
	
	/*
	@Bean
	public Jaxb2Marshaller marchaller(){
			Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
			marshaller.setContextPath("com.evaluacion.servidor.com.claro");
			return marshaller;
	}

	@Bean
	public coneccionClienteSOAP ConeccionClienteSOAP(Jaxb2Marshaller marshaller){
		coneccionClienteSOAP client = new coneccionClienteSOAP();
		client.setDefaultUri("http://c24d-143-208-56-89.ngrok.io/ValidarNitService");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
	*/
}