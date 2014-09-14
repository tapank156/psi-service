package com.scholastic.scent.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scholastic.scent.model.Role;
import com.scholastic.scent.model.User;
import com.scholastic.scent.service.UserService;
import com.scholastic.scent.vo.AllUsersVO;
import com.scholastic.scent.vo.UserRolesVO;


/**
 * <p>
 * The controller exposes the RESTful APIs for the User service. In keeping with
 * best practices, the controller is a thin wrapper for the dependency injected
 * (DI) User.
 * </p>
 * 
 * @date Sep 12, 2014 5:08:44 PM
 * @author anantha
 * @filename UserController.java
 * 
 */
@Controller
@RequestMapping("/users")
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<AllUsersVO> getAllUsers() {
		if (log.isDebugEnabled()) {
			log.debug("Getting list for all: ");
		}
		List<User> users = userService.getUsers();
		if (users == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			AllUsersVO allUsers = new AllUsersVO();
			allUsers.setUser(users);
			return new ResponseEntity<AllUsersVO>(allUsers, HttpStatus.OK);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{userId}/profile")
	public ResponseEntity<User> getUserById(@PathVariable("userId") String userId) {
		if (log.isDebugEnabled()) {
			log.debug("Getting list by id: " + userId);
		}
		User user = userService.getUserByUserId(userId);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{userId}/role")
	public ResponseEntity<UserRolesVO> getRolesByUserId(@PathVariable("userId") String userId) {
		if (log.isDebugEnabled()) {
			log.debug("Getting list for all: ");
		}
		User user = userService.getUserByUserId(userId);
		//Set<Role> roles = userService.getUserRolesbyUserId(userId);
		Set<Role> roles = user.getUerRole();
		if (roles == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			UserRolesVO userroles = new UserRolesVO();
			userroles.setRole(roles);
			return new ResponseEntity<UserRolesVO>(userroles, HttpStatus.OK);
		}
	}
}
