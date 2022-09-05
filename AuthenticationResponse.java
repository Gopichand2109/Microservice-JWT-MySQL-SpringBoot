package com.appointment.microservice.model;

public class AuthenticationResponse {
	private final String jwt;

	public String getJwt() {
		return jwt;
	}

	public AuthenticationResponse(String jwt) {
		super();
		this.jwt = jwt;
	}
	
}
