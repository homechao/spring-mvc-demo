package com.pet.demo.security;

import org.springframework.dao.DataAccessException;

import com.pet.demo.model.Account;

public interface PetDemoSecurityService {
    
    public Account findAccountByUsername(String username) throws DataAccessException;
	
}
