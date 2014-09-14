package com.scholastic.scent.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

//Temporary class to test application
@Entity
@Table(name="t_Auth_User", uniqueConstraints=@UniqueConstraint(columnNames={"user_id"}))
public class AuthUser {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	//(ID from ForgeRock, some sort of GUID format)
	@Column(name="user_id", length=40)
	private String userId;
	
	@Column(name="user_name", length=20)
	private String userName;
	
	@Column(name="password", length=30)
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public AuthUser() {
		super();
	}

	public AuthUser(Long id, String userId, String userName, String password) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}

	@Override
	public String toString() {
		return "AuthUser [id=" + id + ", userId=" + userId + ", userName="
				+ userName + ", password=" + password + "]";
	}
}
