package com.mindtree.mcse.mobilemall.domain.hibernateannotation;

import java.io.Serializable;


public class Signon implements Serializable {

	public Signon(String username, String password, boolean admin,
			HAccount account) {
		super();
		this.username = username;
		this.password = password;
		this.admin = admin;
		this.account = account;
	}

	private static final long serialVersionUID = -2564201233114314076L;
	private String username;
	private String password;
	private boolean admin;

	private HAccount account;
	
	public Signon() {
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String newUsername) {
		this.username = newUsername;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String newPassword) {
		this.password = newPassword;
	}
	
	public HAccount getAccount() {
		return this.account;
	}
	
	public void setAccount(HAccount newAccount) {
		this.account = newAccount;
	}
	
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean isAdmin) {
		this.admin = isAdmin;
	}
}
