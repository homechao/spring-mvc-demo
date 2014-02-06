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
package com.pet.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;

import com.pet.demo.model.Account;
import com.pet.demo.model.Owner;
import com.pet.demo.model.Pet;
import com.pet.demo.model.PetType;
import com.pet.demo.model.Vet;
import com.pet.demo.model.Visit;
import com.pet.demo.repository.AccountRepository;
import com.pet.demo.repository.OwnerRepository;
import com.pet.demo.repository.PetRepository;
import com.pet.demo.repository.VetRepository;
import com.pet.demo.repository.VisitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Mostly used as a facade for all Petclinic controllers Also a placeholder for @Transactional
 * and @Cacheable annotations
 * 
 * @author Michael Isvy
 */
@Service
public class PetDemoServiceImpl implements PetDemoService {

	private PetRepository petRepository;
	private VetRepository vetRepository;
	private OwnerRepository ownerRepository;
	private VisitRepository visitRepository;
	// wangchao
	private AccountRepository accountRepository;

	@Autowired
	public PetDemoServiceImpl(PetRepository petRepository,
			VetRepository vetRepository, OwnerRepository ownerRepository,
			VisitRepository visitRepository, AccountRepository accountRepository) {
		this.petRepository = petRepository;
		this.vetRepository = vetRepository;
		this.ownerRepository = ownerRepository;
		this.visitRepository = visitRepository;
		this.accountRepository = accountRepository;
	}

	@Transactional(readOnly = true)
	public Collection<PetType> findPetTypes() throws DataAccessException {
		return petRepository.findPetTypes();
	}

	@Transactional(readOnly = true)
	public Owner findOwnerById(int id) throws DataAccessException {
		return ownerRepository.findById(id);
	}

	@Transactional(readOnly = true)
	public Collection<Owner> findOwnerByLastName(String lastName)
			throws DataAccessException {
		return ownerRepository.findByLastName(lastName);
	}

	@Transactional
	public void saveOwner(Owner owner) throws DataAccessException {
		ownerRepository.save(owner);
	}

	@Transactional
	public void saveVisit(Visit visit) throws DataAccessException {
		visitRepository.save(visit);
	}

	@Transactional(readOnly = true)
	public Pet findPetById(int id) throws DataAccessException {
		return petRepository.findById(id);
	}

	@Transactional
	public void savePet(Pet pet) throws DataAccessException {
		petRepository.save(pet);
	}

	@Transactional(readOnly = true)
	@Cacheable(value = "vets")
	public Collection<Vet> findVets() throws DataAccessException {
		return vetRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Account findAccountById(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		return accountRepository.findById(id);
	}

	@Transactional
	public void saveAccount(Account account) throws DataAccessException {
		accountRepository.save(account);
	}

	@Transactional(readOnly = true)
	public Account findAccountByUsername(String username, String password)
			throws DataAccessException {
		return accountRepository.findByUsername(username, password);
	}

}
