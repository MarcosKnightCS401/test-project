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

public class CustomerConverterImpl implements Converter<CustomerOutput, Customer> {

	public List<CustomerOutput> convert(Collection<Customer> dataSet,
			boolean deepCopy) {
		
		List<CustomerOutput> dataSetOutput = new ArrayList<CustomerOutput>();
		
		for (Customer customer : dataSet) {
			CustomerOutput customerOutput = new CustomerOutput();
            
			customerOutput.setCustomerId(customer.getId());
            customerOutput.setName(customer.getName());
			
			Set<Account> accounts = customer.getAccounts();			
			List<AccountOutput> customerAccountOutputs = new ArrayList<AccountOutput>();
			for (Account customerAccount : accounts) {
				AccountOutput accountOutput = new AccountOutput();
				
				accountOutput.setAccountId(customerAccount.getId().toString());
				accountOutput.setBalance(NumberFormat.getCurrencyInstance(Locale.US)
	            		.format(customerAccount.getBalance()));
				accountOutput.setCreateDate(DateFormat
						.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.US)
	            		.format(customerAccount.getCreateDate()));
				accountOutput.setUpdateDate(DateFormat
						.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.US)
	            		.format(customerAccount.getCreateDate()));
				
				customerAccountOutputs.add(accountOutput);
			}
			customerOutput.setAccountOutputs(customerAccountOutputs);
			            
			dataSetOutput.add(customerOutput);
        }
		
		if(deepCopy) {
			return dataSetOutput;
		} else {
			List<CustomerOutput> dataSetOutputShallow = dataSetOutput;
			return dataSetOutputShallow;			
		}
	}

	public CustomerOutput convert(Customer dataObject, boolean deepCopy) {
		
		CustomerOutput dataObjectOutput = new CustomerOutput();
        
		dataObjectOutput.setCustomerId(dataObject.getId());
		dataObjectOutput.setName(dataObject.getName());
		
		Set<Account> accounts = dataObject.getAccounts();			
		List<AccountOutput> customerAccountOutputs = new ArrayList<AccountOutput>();
		for (Account customerAccount : accounts) {
			AccountOutput accountOutput = new AccountOutput();
			
			accountOutput.setAccountId(customerAccount.getId().toString());
			accountOutput.setBalance(NumberFormat.getCurrencyInstance(Locale.US)
            		.format(customerAccount.getBalance()));
			accountOutput.setCreateDate(DateFormat
					.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.US)
            		.format(customerAccount.getCreateDate()));
			accountOutput.setUpdateDate(DateFormat
					.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.US)
            		.format(customerAccount.getCreateDate()));
			
			customerAccountOutputs.add(accountOutput);
		}
		dataObjectOutput.setAccountOutputs(customerAccountOutputs);
		
		if(deepCopy) {
			return dataObjectOutput;
		} else {
			CustomerOutput dataObjectOutputShallow = dataObjectOutput;
			return dataObjectOutputShallow;			
		}
		
	}

}
