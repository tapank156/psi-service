package com.scholastic.scent.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="t_student")
@PrimaryKeyJoinColumn(name="id")
@XmlRootElement(name="student")
public class Student extends User {
	@Column(name="grade")
	private Integer grade;	
	
	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}
}
