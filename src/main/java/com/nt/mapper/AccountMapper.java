package com.nt.mapper;

import com.nt.entity.Account;
import com.nt.entityDTO.AccountDTO;

public class AccountMapper {

	
	public static Account mapToAccount(AccountDTO  accountdto)
	{
		Account account = new Account(
				accountdto.getId(),
				accountdto.getAccountHolderName(),
				accountdto.getBalance());
		
		return account;
	}
	
	public static AccountDTO mapToAccountDTO(Account account)
	{
		AccountDTO accountdto= new AccountDTO(
				account.getId(),
				account.getAccountHolderName(),
				account.getBalance());
		
		return accountdto;
	}
	
}
