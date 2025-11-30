package com.nt.service;

import java.util.List;

import com.nt.entityDTO.AccountDTO;

public interface AccountService 
{
	
	//create Account
	public AccountDTO createAccount(AccountDTO accountdto);
	
	//get single Account
	public 	AccountDTO getAccountById(Long id);
	
	//Deposite Many
	public AccountDTO deposite(Long id,double amount);
	
	//withrow Many
	public AccountDTO withdraw(Long id,Double amount);
	
	//get All account
	public List<AccountDTO> getallAccounts();
	
	//delete Accounts
	public void delateAccount(Long id);
	
}
