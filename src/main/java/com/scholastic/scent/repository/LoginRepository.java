package com.scholastic.scent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scholastic.scent.model.AuthUser;

@Repository
public interface LoginRepository extends JpaRepository<AuthUser, Long>{
	
	@Query("SELECT au from AuthUser au WHERE au.userName = :userName AND au.password = :password")
	public  AuthUser getAuthUser(@Param("userName") String userName, @Param("password") String password);
}
