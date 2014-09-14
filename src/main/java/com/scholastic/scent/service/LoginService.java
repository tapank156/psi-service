package com.scholastic.scent.service;

import com.scholastic.scent.model.AuthUser;

public interface LoginService {
	public AuthUser verifyUser(String un, String pwd) throws Exception;
}
