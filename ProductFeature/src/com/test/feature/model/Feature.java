package com.test.feature.model;

public class Feature {
	
	private String fromEmail;
	private String description;
	
	public Feature (String fromEmail, String description){
		this.fromEmail = fromEmail;
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFromEmail() {
		return fromEmail;
	}
	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}
	
	
	@Override
	public String toString(){
		return getFromEmail() + ", " + getDescription();
	}
}
