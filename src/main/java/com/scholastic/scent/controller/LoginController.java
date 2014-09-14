package com.scholastic.scent.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scholastic.scent.model.AuthUser;
import com.scholastic.scent.model.User;
import com.scholastic.scent.service.LoginService;
import com.scholastic.scent.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
@RequestMapping("/login")
public class LoginController {
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired private LoginService loginService;
	@Autowired private UserService userService;

	@RequestMapping(method=RequestMethod.GET)
	public String loginForm(ModelMap modelMap) throws Exception {
		System.out.println("Loading form ....");
		modelMap.addAttribute("user", new AuthUser(0L, "", "", ""));
		return "login";
	}

	@RequestMapping(method=RequestMethod.POST, value="/verify")
	public ResponseEntity<AuthUser> verifyUser(@Valid @RequestBody  AuthUser user) throws Exception {
		AuthUser ausr = loginService.verifyUser(user.getUserName(), user.getPassword());
		if(ausr != null){
	    	return new ResponseEntity<AuthUser>(ausr, HttpStatus.OK);    	
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
//	@RequestMapping(method=RequestMethod.POST, value="/verify")
//	public ResponseEntity<User> verifyUser(@Valid @RequestBody  AuthUser user) throws Exception {
//		if(user != null)
//			System.out.println("Received form ...." + user.toString());
//		else
//			System.out.println("Not Received form ....");
//		
//		AuthUser ausr = loginService.verifyUser(user.getUserName(), user.getPassword());
//		User usr = null;
//		if(ausr != null){
//			usr = userService.getUserByUserId(ausr.getUserId());
//		}
//    	HttpHeaders httpHeaders = new HttpHeaders();
//    	httpHeaders.add("Access-Control-Allow-Origin", "*");
//    	System.out.println("User Details ...." + usr.toString());
//    	return new ResponseEntity<User>(usr, httpHeaders, HttpStatus.OK);    	
//	}

	
}
