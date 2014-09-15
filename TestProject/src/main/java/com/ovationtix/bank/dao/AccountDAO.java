package com.ovationtix.bank.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ovationtix.bank.dao.model.Account;

@Repository
public class AccountDAO extends BaseDAO {

	public List<Account> listAccounts() {
		return list(createQuery("from Account"));
	}

	public Account getAccount(Long id) {
		return get(Account.class, id);
	}

}
