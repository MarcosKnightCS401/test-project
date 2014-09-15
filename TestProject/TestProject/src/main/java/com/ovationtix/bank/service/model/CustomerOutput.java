package com.ovationtix.bank.service.model;

import java.util.List;

public class CustomerOutput {

	private Long customerId;
	private String name;
	private List<AccountOutput> accountOutputs;

	public List<AccountOutput> getAccountOutputs() {
		return accountOutputs;
	}

	public void setAccountOutputs(List<AccountOutput> accountOutputs) {
		this.accountOutputs = accountOutputs;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
