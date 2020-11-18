package de.uniba.rz.entities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TicketSearch")
public class TicketSearch implements Serializable {
	
	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = -6967050030159944655L;

	@XmlElement(name = "searchString")
	private String searchString;
	
	@XmlElement(name = "searchType")
	private Type searchType;
	
	public TicketSearch() {
		
	}
	
	public TicketSearch(String searchString, Type searchType) {
		this.searchString = searchString;
		this.searchType = searchType;
	}
	
	
	public String getSearchString() {
		return searchString;
	}
	
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
	
	public Type getSearchType() {
		return searchType;
	}
	
	public void setSearchType(Type searchType) {
		this.searchType = searchType;
	}
	
	

}
