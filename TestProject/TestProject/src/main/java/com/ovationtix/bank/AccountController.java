package com.ovationtix.bank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ovationtix.bank.service.AccountService;
import com.ovationtix.bank.service.model.AccountOutput;
import com.ovationtix.bank.service.model.CustomerOutput;

@Controller
public class AccountController {

	@Autowired
	AccountService accountService;

	@RequestMapping(value="index")
	public String listCustomers(ModelMap model) {
		List<AccountOutput> accounts = accountService.listCustomerAccounts();
		model.addAttribute("customerAccounts", accounts);
		List<CustomerOutput> customers = accountService.listCustomers();
		model.addAttribute("customers", customers);
		return "accounts";
	}

	@RequestMapping(value="customer")
	public String getCustomer(ModelMap model, Long id) {
		CustomerOutput customer = accountService.getCustomer(id);
		model.addAttribute("theCustomer", customer);
		return "customer";
	}

	@RequestMapping(value="account")
	public String getAccount(ModelMap model, Long id) {
		AccountOutput account = accountService.getAccount(id);
		model.addAttribute("account", account);
		return "account";
	}

}
