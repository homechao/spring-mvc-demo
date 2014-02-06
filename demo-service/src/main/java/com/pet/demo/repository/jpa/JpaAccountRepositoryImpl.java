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
package com.pet.demo.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.pet.demo.model.Account;
import com.pet.demo.repository.AccountRepository;

@Repository
public class JpaAccountRepositoryImpl implements AccountRepository {

    @PersistenceContext
    private EntityManager em;


    public Account findById(int id) {
        // using 'join fetch' because a single query should load both owners and pets
        // using 'left join fetch' because it might happen that an owner does not have pets yet
        Query query = this.em.createQuery("SELECT account FROM Account account WHERE account.id =:id");
        query.setParameter("id", id);
        return (Account) query.getSingleResult();
    }

    public void save(Account account) {
    	if (account.getId() == null) {
    		this.em.persist(account);     		
    	}
    	else {
    		this.em.merge(account);    
    	}

    }

	public Account findByUsername(String username, String password) throws DataAccessException {
        Query query = this.em.createQuery("SELECT account FROM Account account WHERE account.userName =:username AND account.password =:password ");
        query.setParameter("username", username);
        query.setParameter("password", password);
        Collection<Account> results = query.getResultList();
        if(results.size() == 1){
        	return results.iterator().next();
        }
        return null;
	}
	

	public Account findByUsername(String username) throws DataAccessException {
        Query query = this.em.createQuery("SELECT account FROM Account account WHERE account.userName =:username ");
        query.setParameter("username", username);
        Collection<Account> results = query.getResultList();
        if(results.size() == 1){
        	return results.iterator().next();
        }
        return null;
	}

}
