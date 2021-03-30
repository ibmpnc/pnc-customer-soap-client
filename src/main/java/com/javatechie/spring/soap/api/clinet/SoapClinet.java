package com.javatechie.spring.soap.api.clinet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.pnc.customer.soap.ws.customer.CustomerDetailsRequest;
import com.pnc.customer.soap.ws.customer.CustomerDetailsResponse;

@Service
public class SoapClinet {

	@Autowired
	private Jaxb2Marshaller marshaller;

	private WebServiceTemplate template;

	public CustomerDetailsResponse getCustomerDetails(CustomerDetailsRequest request) {
		template = new WebServiceTemplate(marshaller);
		CustomerDetailsResponse response = (CustomerDetailsResponse) template.marshalSendAndReceive("http://localhost:8080/ws",
				request);
		return response;
	}

}
