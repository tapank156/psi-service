package com.scholastic.scent.service;

import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scholastic.scent.model.Role;
import com.scholastic.scent.model.User;
import com.scholastic.scent.repository.RoleRepository;
import com.scholastic.scent.repository.UserRepository;

/**
 * 
 * @date Sep 12, 2014 5:12:13 PM
 * @author anantha
 * @filename UserServiceImpl.java
 *
 */
@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	public UserServiceImpl() {

	}

	@Override
	public List<User> getUsers() {
		return userRepository.getUsers();
	}
	
	@Override
	public User getUserByUserId(String userId) {	
		return userRepository.getUserByUserId(userId);
	}

//	@Override
//	public Set<Role> getUserRolesbyUserId(String userId) {
//		System.out.println("Userid=" + userId);
//		Set<Role> tls = userRepository.findOne(userId);
//		System.out.println(tls);
//		return tls;
//	}
}