package com.javatechie.spring.soap.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.spring.soap.api.clinet.SoapClinet;
import com.pnc.customer.soap.ws.customer.CustomerDetailsRequest;
import com.pnc.customer.soap.ws.customer.CustomerDetailsResponse;

@SpringBootApplication
@RestController
public class SpringBootSopaWsClientApplication {
	
	@Autowired
	private SoapClinet clinet;
	
	@PostMapping("/getCustomerDetail")
	public CustomerDetailsResponse invokeSoapClientToGetLoanStatus(@RequestBody CustomerDetailsRequest request) {
		return clinet.getCustomerDetails(request);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSopaWsClientApplication.class, args);
	}

}
