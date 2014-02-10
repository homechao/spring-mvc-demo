package com.pet.demo.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pet.demo.core.util.Digests;
import com.pet.demo.core.util.Encodes;
import com.pet.demo.model.Account;
import com.pet.demo.repository.AccountRepository;

@Service
public class PetDemoSecurityServiceImpl implements PetDemoSecurityService {

	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;
	
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
	

	/**
	 * 在保存用户时,发送用户修改通知消息, 由消息接收者异步进行较为耗时的通知邮件发送.
	 * 
	 * 如果企图修改超级用户,取出当前操作员用户,打印其信息然后抛出异常.
	 * 
	 */
	@Override
	@Transactional
	public void saveUser(Account account) throws DataAccessException {
		// 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
		if (StringUtils.isNotBlank(account.getPassword())) {
			byte[] salt = Digests.generateSalt(SALT_SIZE);
			account.setSalt(Encodes.encodeHex(salt));

			byte[] plainPassword = account.getPassword().getBytes();
			byte[] hashPassword = Digests.sha1(plainPassword, salt, HASH_INTERATIONS);
			account.setPassword(Encodes.encodeHex(hashPassword));
		}
		accountRepository.save(account);
	}
	

}
