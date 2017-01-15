package com.client;
 
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
//make sure tomcat is running and run as java application and should see an output in console 
//made this class to show how to use Jersey client APIs to create a RESTful Java client to perform GET requests to REST service.

public class RESTJerseyClient {
 
	public static void main(String[] args) {
 
		RESTJerseyClient restclient = new RESTJerseyClient();
		restclient.getCtoFResponse();
		restclient.getFtoCResponse();
		
	}
 
	private void getFtoCResponse() {
		try {
 
			Client client = Client.create();
			WebResource webResource2 = client.resource("http://localhost:8080/RESTfulJerseyExample/crunch/ftocservice/90");
			ClientResponse response2 = webResource2.accept("application/json").get(ClientResponse.class);
			
			if (response2.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response2.getStatus());
			}
 
			String output2 = response2.getEntity(String.class);
			System.out.println("\n============getFtoCResponse============");
			System.out.println(output2);
 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
 
	private void getCtoFResponse() {
		try {
 
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/RESTfulJerseyExample/crunch/ctofservice/40");
			ClientResponse response = webResource.accept("application/xml").get(ClientResponse.class);
			
			
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}
 
			String output = response.getEntity(String.class);
			System.out.println("============getCtoFResponse============");
			System.out.println(output);
 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}