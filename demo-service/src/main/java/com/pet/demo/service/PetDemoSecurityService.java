package com.pet.demo.service;

import org.springframework.dao.DataAccessException;

import com.pet.demo.model.Account;

public interface PetDemoSecurityService {
    
    public Account findAccountByUsername(String username) throws DataAccessException;
    
    public void saveUser(Account account) throws DataAccessException;
	
}
