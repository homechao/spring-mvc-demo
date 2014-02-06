/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pet.demo.repository.springdatajpa;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.pet.demo.model.Account;
import com.pet.demo.repository.AccountRepository;

/**
 * Spring Data JPA specialization of the {@link AccountRepository} interface
 *
 * @author Michael Isvy
 * @since 15.1.2013
 */
public interface SpringDataAccountRepository extends AccountRepository, Repository<Account, Integer> {
	
    @Override
    @Query("SELECT account FROM Account account WHERE account.userName=:username AND account.password=:password")
    Account findByUsername(@Param("username") String username,@Param("password") String password) throws DataAccessException;

    @Override
    @Query("SELECT account FROM Account account WHERE account.userName=:username")
    Account findByUsername(@Param("username") String username) throws DataAccessException;
}
