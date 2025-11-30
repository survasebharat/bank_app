package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entityDTO.AccountDTO;
import com.nt.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	
	@Autowired
	private AccountService service;
	
	
	//add the Account
	@PostMapping("/save")
	public ResponseEntity<AccountDTO> addAccount(@RequestBody AccountDTO accountdto)
	{
		return new ResponseEntity<AccountDTO>(service.createAccount(accountdto),HttpStatus.CREATED);
	}
	
	//getMEthod
	@GetMapping("/{id}")
	public ResponseEntity<AccountDTO> getAccountById(@PathVariable Long id)
	{
		AccountDTO accountdto = service.getAccountById(id);
		return ResponseEntity.ok(accountdto); 
	}
	
	
	
	//deposite Rest api
	@PutMapping("{id}/deposite")
	public ResponseEntity<AccountDTO> deposite(@PathVariable Long id,@RequestBody Map<String,Double> request)
	{
		Double amount =request.get("amount");
		AccountDTO accountDTO = service.deposite(id, amount);
		return ResponseEntity.ok(accountDTO);
	}
	
	//withdrow MEthod
	@PutMapping("{id}/withdraw")
	public ResponseEntity<AccountDTO> withdraw(@PathVariable Long id,@RequestBody Map<String,Double>request)
	{
		Double amount=request.get("amount");
		AccountDTO accountDTO =service.withdraw(id, amount);
		return ResponseEntity.ok(accountDTO);
	}
	
	//getAll Accounts
	@GetMapping("/")
	public ResponseEntity<List<AccountDTO>> getAllAccounts()
	{
		List<AccountDTO> accounts = service.getallAccounts();
		return ResponseEntity.ok(accounts);
	}
	
	//delete By Id
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long id)
	{
		service.delateAccount(id);
		return ResponseEntity.ok("Account is Deleted Succesfully");
	}
}
