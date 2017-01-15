package com.restjersey;

	import javax.ws.rs.GET;
	import javax.ws.rs.Path;
	import javax.ws.rs.PathParam;
	import javax.ws.rs.Produces;
	 
	
	@Path("/ctofservice")
	public class CtoFService {
		
		
		@GET
		@Produces("application/xml")
		public String convertCtoF() {
	 
			Double fahrenheit;
			Double celsius = 36.8;
			
			fahrenheit = ((celsius * 9) / 5) + 32;
	 
			String result = "@Produces(\"application/xml\") Output Celsius to F Converter \n\n Output: " + fahrenheit;
			return "<ctofservice>" + "<celsius>" + celsius + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>" + "</ctofservice>";
		}
	 
		//add this to end of url crunch/ctofservice/
		//run this url http://localhost:8080/RESTfulJerseyExample/crunch/ctofservice/
		
		
		
		
		@Path("{c}")
		@GET
		@Produces("application/xml")
		public String convertCtoFfromInput(@PathParam("c") Double c) {
			
			Double fahrenheit;
			Double celsius = c;
			fahrenheit = ((celsius * 9) / 5) + 32;
	 
			
			String result = "@Produces(\"application/xml\") Output: \n\n C to F Converter Output: \n\n" + fahrenheit;
			return "<ctofservice>" + "<celsius>" + celsius + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>" + "</ctofservice>";
		}
		
		
		//add this to end of url crunch/ctofservice/35    <--or any number it will convert to fahrenheit
		//use this url http://localhost:8080/RESTfulJerseyExample/crunch/ctofservice/35 <--enter any value at the end
	
	}