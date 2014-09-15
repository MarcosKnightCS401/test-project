package com.ovationtix.bank.dao.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = -1473886859781280688L;

	@Id
	@Column(name="id", unique=true, nullable=false)
	@GeneratedValue
	private Long id;

	@Column(name="name", nullable=false)
	private String name;

	@OneToMany(targetEntity=Account.class, cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="customer")
	private Set<Account> accounts;

	public Customer() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

}
