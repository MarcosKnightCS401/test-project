package com.ovationtix.bank.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import com.ovationtix.bank.dao.model.Customer;

@Repository
public class CustomerDAO extends BaseDAO {

	public List<Customer> listCustomers() {
		return list(createQuery("from Customer"));
	}

	public Customer getCustomer(Long id) {
		Customer customer = get(Customer.class, id);
		if(customer != null) {
			Hibernate.initialize(customer.getAccounts());
		}
		return customer;
	}

}
