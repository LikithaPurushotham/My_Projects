package de.uniba.rz.app.exceptions;

public class WebServiceNotAvailableException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1993502969458505808L;


	public WebServiceNotAvailableException(){
		
	}
	
	
	public WebServiceNotAvailableException(String message){
		super(message);
	}
}
