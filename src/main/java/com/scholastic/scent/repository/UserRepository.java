package com.scholastic.scent.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scholastic.scent.model.Role;
import com.scholastic.scent.model.Student;
import com.scholastic.scent.model.User;

/**
 * 
 * @date Sep 12, 2014
 * @author anantha
 * @filename UserRepository.java
 *
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	@Query("SELECT u from User u WHERE u.userId = :userId")
	public  User getUserByUserId(@Param("userId") String userId);

	@Query("SELECT u from User u")
	public List<User> getUsers();
	
	
	//need to do work
//	@Query("SELECT u.roles from User u WHERE u.userId = :userId")
//	public Set<Role> findOne(String userId);
}