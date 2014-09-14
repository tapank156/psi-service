package com.scholastic.scent.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.scholastic.scent.model.User;

@XmlRootElement(name = "users")
public class AllUsersVO {
	List<User> user;

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

}
