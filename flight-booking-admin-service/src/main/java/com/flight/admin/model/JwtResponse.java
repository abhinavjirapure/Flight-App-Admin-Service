package com.flight.admin.model;

import java.io.Serializable;

public class JwtResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	private String jwttoken;

	public JwtResponse(String token) {
		// TODO Auto-generated constructor stub
	}
	public String getJwttoken() {
		return jwttoken;
	}
	public void setJwttoken(String jwttoken) {
		this.jwttoken = jwttoken;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
