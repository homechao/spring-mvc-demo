package com.pet.demo.repository;

import org.springframework.dao.DataAccessException;

import com.pet.demo.model.Account;

public interface AccountRepository {

    Account findById(int id) throws DataAccessException;
    void save(Account account) throws DataAccessException;
    Account findByUsername(String username, String password) throws DataAccessException;
    Account findByUsername(String username) throws DataAccessException;
}
