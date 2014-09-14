package com.scholastic.scent.vo;

import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import com.scholastic.scent.model.Role;

@XmlRootElement(name="roles")
public class UserRolesVO {
	private Set<Role> role;

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}
}
