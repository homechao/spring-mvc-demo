package com.pet.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


/**
 * The persistent class for the accounts database table.
 * 
 */
@Entity
@Table(name="accounts")
//默认的缓存策略.
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Account extends BaseEntity {

	@Column(length=128)
	private String email;

	@Column(length=64)
	private String name;

	@Column(length=255)
	private String password;

	@Column(length=64)
	private String salt;

	@Column(length=32)
	private String status;

	@Column(name="user_name", nullable=false, length=255)
	private String userName;

	//bi-directional many-to-many association to Role
	@ManyToMany
	@JoinTable(name="account_role", joinColumns={@JoinColumn(name="user_id", nullable=false)}, inverseJoinColumns={	@JoinColumn(name="role_id", nullable=false)	})
	// Fecth策略定义
	@Fetch(FetchMode.JOIN)
	// 集合按id排序
	@OrderBy("id ASC")
	// 缓存策略
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private List<Role> roles = new ArrayList<Role>();

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}