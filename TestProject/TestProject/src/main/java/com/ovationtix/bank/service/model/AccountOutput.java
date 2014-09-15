package com.ovationtix.bank.service.model;

public class AccountOutput {

	private String accountId;
	private String balance;
	private String createDate;
	private String updateDate;
	private CustomerOutput customerOutput;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public CustomerOutput getCustomerOutput() {
		return customerOutput;
	}

	public void setCustomerOutput(CustomerOutput customerOutput) {
		this.customerOutput = customerOutput;
	}


}
