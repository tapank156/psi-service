package com.scholastic.scent.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.scholastic.scent.util.JsonDateSerializer;
import com.scholastic.scent.vo.UserRolesVO;

@Entity
@Table(name = "t_user", uniqueConstraints=@UniqueConstraint(columnNames={"user_id"}))
@Inheritance(strategy=InheritanceType.JOINED)
@XmlRootElement(name="user")
@XmlAccessorType ( XmlAccessType.FIELD )
public class User{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	//(ID from ForgeRock, some sort of GUID format)
	@Column(name="user_id", length=40)
	private String userId;
	
	@Column(name="first_name", length=20)
	private String firstName;
	
	@Column(name="middle_initial", length=1)
	private String middleInitial;

	@Column(name="last_name", length=30)
	private String lastName;

	@Column(name="suffix", length=1)
	private String suffix;

	@JsonSerialize(using=JsonDateSerializer.class)
	@Column(name="date_of_birth")
	private Date dateOfBirth;

	@Column(name="gender", length=1)
	private String gender;
	
	@XmlElementWrapper(name = "roles")
    @XmlElement(name = "role")
	@ManyToMany ( cascade = { CascadeType.ALL }, fetch = FetchType.EAGER) 
	@JoinTable (name = "t_user_role", joinColumns = { @JoinColumn (name = "usr_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })  
	private Set<Role> userRole;
	
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Set<Role> getUerRole() {
		return userRole;
	}

	public void setUerRole(Set<Role> userRole) {
		this.userRole = userRole;
	}
}
