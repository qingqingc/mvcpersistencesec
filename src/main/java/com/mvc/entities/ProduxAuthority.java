package com.mvc.entities;

import org.springframework.security.core.GrantedAuthority;

public class ProduxAuthority implements GrantedAuthority{
	/**
	 * 
	 */
	private static final long serialVersionUID = 98097739773863580L;

	public ProduxAuthority(String str) {
		System.out.println(str);
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return null;
	}
}
