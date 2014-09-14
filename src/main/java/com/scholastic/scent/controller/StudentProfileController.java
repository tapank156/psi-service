package com.scholastic.scent.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scholastic.scent.model.Student;
import com.scholastic.scent.service.StudentProfileService;


@Controller
@RequestMapping("/students")
public class StudentProfileController {
	private static final Logger log = LoggerFactory.getLogger(StudentProfileController.class);
	
	@Autowired
	private StudentProfileService studentProfileService;
	
	public StudentProfileController() {
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{userId}/profile")
	public ResponseEntity<Student> getUserProfile(@PathVariable("userId") String userId){
		if( log.isDebugEnabled() ) {
			log.debug("Getting User by id: " + userId);
		}
		Student studentProfile = studentProfileService.getStudentProfile(userId);
		
		if( studentProfile != null ) {
			return new ResponseEntity<Student>(studentProfile, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
