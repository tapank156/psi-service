package com.scholastic.scent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scholastic.scent.repository.LoginRepository;
import com.scholastic.scent.service.LoginService;
import com.scholastic.scent.model.AuthUser;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	public AuthUser verifyUser(String userName, String password) throws Exception {
		System.out.println("LoginServiceImpl...");
		return loginRepository.getAuthUser(userName, password);
	}
}
