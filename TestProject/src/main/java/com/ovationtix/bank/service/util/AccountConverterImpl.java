package com.ovationtix.bank.service.util;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import com.ovationtix.bank.dao.model.Account;
import com.ovationtix.bank.dao.model.Customer;
import com.ovationtix.bank.service.model.AccountOutput;
import com.ovationtix.bank.service.model.CustomerOutput;


public class AccountConverterImpl implements Converter<AccountOutput, Account> {

	public List<AccountOutput> convert(Collection<Account> dataSet,
			boolean deepCopy) {
		
		List<AccountOutput> dataSetOutput = new ArrayList<AccountOutput>();
		
		for (Account account : dataSet) {
            AccountOutput accountOutput = new AccountOutput();
            
            accountOutput.setAccountId(account.getId().toString());
            accountOutput.setBalance(NumberFormat.getCurrencyInstance(Locale.US)
            		.format(account.getBalance()));
            accountOutput.setCreateDate(DateFormat
            		.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.US)
            		.format(account.getCreateDate()));
            accountOutput.setUpdateDate(DateFormat
            		.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.US)
            		.format(account.getCreateDate()));
			
			Customer customer = account.getCustomer();		
			CustomerOutput customerOutput = new CustomerOutput();
			customerOutput.setCustomerId(customer.getId());
			customerOutput.setName(customer.getName());
			
			List<AccountOutput> customerAccountOutputs = new ArrayList<AccountOutput>();
			Set<Account> customerAccounts = customer.getAccounts();
			for (Account customerAccount : customerAccounts) {
				AccountOutput customerAccountOutput = new AccountOutput();
				
				customerAccountOutput.setAccountId(customerAccount.getId().toString());
				customerAccountOutput.setBalance(NumberFormat.getCurrencyInstance(Locale.US)
	            		.format(customerAccount.getBalance()));
				customerAccountOutput.setCreateDate(DateFormat
						.getDateInstance(DateFormat.SHORT, Locale.US)
	            		.format(customerAccount.getCreateDate()));
				customerAccountOutput.setUpdateDate(DateFormat
						.getDateInstance(DateFormat.SHORT, Locale.US)
	            		.format(customerAccount.getCreateDate()));
				
				customerAccountOutputs.add(customerAccountOutput);
			}
			customerOutput.setAccountOutputs(customerAccountOutputs);
			
			accountOutput.setCustomerOutput(customerOutput);
            
			dataSetOutput.add(accountOutput);
        }
		
		if(deepCopy) {
			return dataSetOutput;
		} else {
			List<AccountOutput> dataSetOutputShallow = dataSetOutput;
			return dataSetOutputShallow;			
		}
	}

	public AccountOutput convert(Account dataObject, boolean deepCopy) {
		
		AccountOutput dataObjectOutput = new AccountOutput();
        
		dataObjectOutput.setAccountId(dataObject.getId().toString());
		dataObjectOutput.setBalance(NumberFormat.getCurrencyInstance(Locale.US)
        		.format(dataObject.getBalance()));
		dataObjectOutput.setCreateDate(DateFormat
				.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.US)
        		.format(dataObject.getCreateDate()));
		dataObjectOutput.setUpdateDate(DateFormat
				.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.US)
        		.format(dataObject.getCreateDate()));
		
		Customer customer = dataObject.getCustomer();		
		CustomerOutput customerOutput = new CustomerOutput();
		customerOutput.setCustomerId(customer.getId());
		customerOutput.setName(customer.getName());
		
		List<AccountOutput> customerAccountOutputs = new ArrayList<AccountOutput>();
		Set<Account> customerAccounts = customer.getAccounts();
		for (Account customerAccount : customerAccounts) {
			AccountOutput customerAccountOutput = new AccountOutput();
			
			customerAccountOutput.setAccountId(dataObject.getId().toString());
			customerAccountOutput.setBalance(NumberFormat.getCurrencyInstance(Locale.US)
            		.format(customerAccount.getBalance()));
			customerAccountOutput.setCreateDate(DateFormat
					.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.US)
	        		.format(customerAccount.getCreateDate()));
			customerAccountOutput.setUpdateDate(DateFormat
					.getDateInstance(DateFormat.SHORT, Locale.US)
            		.format(customerAccount.getCreateDate()));
			
			customerAccountOutputs.add(customerAccountOutput);
		}
		customerOutput.setAccountOutputs(customerAccountOutputs);
		
		dataObjectOutput.setCustomerOutput(customerOutput);
		
		if(deepCopy) {
			return dataObjectOutput;
		} else {
			AccountOutput dataObjectOutputShallow = dataObjectOutput;
			return dataObjectOutputShallow;			
		}
		
	}

}
