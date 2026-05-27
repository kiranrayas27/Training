package com.msedcl.bean;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="login_details")
public class LoginDTO {
	@Id
	private int login_id; 
	
	private String password;
	private int invalid_login_count;
	private String status;
	
	
	public LoginDTO() {
		// TODO Auto-generated constructor stub
	}


	public LoginDTO(int login_id, String password, int invalid_login_count, String status) {
		super();
		this.login_id = login_id;
		this.password = password;
		this.invalid_login_count = invalid_login_count;
		this.status = status;
	}


	public int getLogin_id() {
		return login_id;
	}


	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getInvalid_login_count() {
		return invalid_login_count;
	}


	public void setInvalid_login_count(int invalid_login_count) {
		this.invalid_login_count = invalid_login_count;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "LoginDTO [login_id=" + login_id + ", password=" + password + ", invalid_login_count="
				+ invalid_login_count + ", status=" + status + "]";
	}
	
	
}
