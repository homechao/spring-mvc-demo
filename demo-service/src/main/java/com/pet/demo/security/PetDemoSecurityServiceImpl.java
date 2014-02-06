package com.pet.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.pet.demo.model.Account;
import com.pet.demo.repository.AccountRepository;

@Component
public class PetDemoSecurityServiceImpl implements PetDemoSecurityService {

	private AccountRepository accountRepository;
	
	@Autowired
	public PetDemoSecurityServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public Account findAccountByUsername(String username)
			throws DataAccessException {
		return accountRepository.findByUsername(username);
	}

}
