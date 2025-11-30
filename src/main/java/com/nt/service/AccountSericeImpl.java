package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.sql.ast.tree.expression.Collation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Account;
import com.nt.entityDTO.AccountDTO;
import com.nt.mapper.AccountMapper;
import com.nt.repositary.AccountRepository;

@Service
public class AccountSericeImpl implements AccountService {

	
	@Autowired
	private AccountRepository repository;

	

	//create Account bisiness logic
	@Override
	public AccountDTO createAccount(AccountDTO accountdto) {
		
		Account account = AccountMapper.mapToAccount(accountdto);
		Account savedAccount = repository.save(account);
		return AccountMapper.mapToAccountDTO(savedAccount);
	}

	//find by Account Logic
	@Override
	public AccountDTO getAccountById(Long id) {
		
		Account account = repository.findById(id).orElseThrow(() -> new RuntimeException()); 
		return AccountMapper.mapToAccountDTO(account);
	}

	//deposite many in Account logic
	@Override
	public AccountDTO deposite(Long id, double amount) {
	
			Account account = repository.findById(id).orElseThrow(()-> new RuntimeException());
			double total  = account.getBalance()+amount;
			account.setBalance(total);
			Account savedAccount= repository.save(account);
		return AccountMapper.mapToAccountDTO(savedAccount);
	}
	
	@Override
	public AccountDTO withdraw(Long id, Double amount) {
		
		Account account = repository.findById(id).orElseThrow(() -> new RuntimeException("Account Does Not Exist"));
		
		if(account.getBalance()<amount)
		{
			throw new RuntimeException("Insuffecient Amount");
		}
		
		Double total = account.getBalance()-amount;
			account.setBalance(total);
			Account savedaccount = repository.save(account);
		
		return AccountMapper.mapToAccountDTO(savedaccount);
	}
	
	//get all acounts
	@Override
	public List<AccountDTO>  getallAccounts() {
		List<Account> accounts = repository.findAll();
		return accounts.stream().map((account) -> AccountMapper.mapToAccountDTO(account)).collect(Collectors.toList());
	}
	
	//delate Account
	@Override
	public void delateAccount(Long id) {
		
		Account account = repository.findById(id).orElseThrow(()-> new RuntimeException("Account Does Not Exist"));
	
		repository.deleteById(id);
	}
	
}
