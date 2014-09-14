package com.scholastic.scent.service;

import java.util.List;
import java.util.Set;

import com.scholastic.scent.model.Role;
import com.scholastic.scent.model.User;

public interface UserService {

	public List<User> getUsers();

	public User getUserByUserId(String userId);
}
