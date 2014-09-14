package com.scholastic.scent.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.scholastic.scent.model.Student;

@Component
public class StudentProfileServiceImpl implements StudentProfileService {
	
	static final Map<String, Student> studentProfiles = new HashMap<>();	
	static {
		for(int i=0; i<=10; i++){
			Student student = new Student();
			student.setUserId("student"+i);
			student.setFirstName("student_firstName_"+i);
			student.setMiddleInitial("");
			student.setLastName("student_lastName_"+i);
			student.setDateOfBirth(new Date());
			student.setGender("M");
			student.setGrade(6+i);
			student.setId(1l);
			student.setSuffix("Jr"+i);
			studentProfiles.put("student"+i, student);
		}
	}
	
	@Override
	public Student getStudentProfile(String userId){		
		return studentProfiles.get(userId);
	}

}