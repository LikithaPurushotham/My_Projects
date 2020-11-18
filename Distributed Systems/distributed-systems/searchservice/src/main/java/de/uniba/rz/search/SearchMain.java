package de.uniba.rz.search;

import javax.xml.ws.Endpoint;

import de.uniba.rz.entities.Constants;

public class SearchMain {

	public static void main(String[] args){
		
		initializeSearchWebService();
		
	}
	
	private static void initializeSearchWebService(){
		Endpoint endpoint = Endpoint.create(new SearchWebServiceImpl());
		endpoint.publish(Constants.SEARCH_WEB_SERVICE_URL+"?wsdl");
		System.out.println("Server ready to serve your JAX-WS requests...");
	}
	
	
	
}
