package com.ovationtix.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ovationtix.bank.dao.AccountDAO;
import com.ovationtix.bank.dao.CustomerDAO;
import com.ovationtix.bank.dao.model.Account;
import com.ovationtix.bank.dao.model.Customer;
import com.ovationtix.bank.service.model.AccountOutput;
import com.ovationtix.bank.service.model.CustomerOutput;
import com.ovationtix.bank.service.util.AccountConverterImpl;
import com.ovationtix.bank.service.util.Converter;
import com.ovationtix.bank.service.util.CustomerConverterImpl;

@Service
@Transactional
public class AccountService {

	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private AccountDAO accountDAO;

	public List<AccountOutput> listCustomerAccounts() {
		List<Account> accounts = accountDAO.listAccounts();
		Converter<AccountOutput, Account> accountConverter = new AccountConverterImpl();
		return accountConverter.convert(accounts, true);
	}

	public AccountOutput getAccount(Long id) {
		Account account = accountDAO.getAccount(id);
		Converter<AccountOutput, Account> accountConverter = new AccountConverterImpl();
		return accountConverter.convert(account, true);
	}

	public List<CustomerOutput> listCustomers() {
		List<Customer> customers = customerDAO.listCustomers();
		Converter<CustomerOutput, Customer> customerConverter = new CustomerConverterImpl();
		return customerConverter.convert(customers, true);
	}

	public CustomerOutput getCustomer(Long id) {
		if(id == null) {
			throw new RuntimeException("Invalid input");
		}
		Customer customer = customerDAO.getCustomer(id);
		Converter<CustomerOutput, Customer> customerConverter = new CustomerConverterImpl();
		return customerConverter.convert(customer, true);
	}

}
