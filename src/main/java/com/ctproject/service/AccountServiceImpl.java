package com.ctproject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctproject.model.Account;
import com.ctproject.dao.AccountDAO;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDAO accountDAO;
	
	public Account findById(int id) {
		return accountDAO.findById(id);
	}
	
	public int isAccountExist(String email) {
		return accountDAO.isAccountExist(email);
	}
	
	
	public void saveAccount(Account account) {
		accountDAO.saveAccount(account);

	}
	
	
	public void updateAccount(Account account) {
		accountDAO.updateAccount(account);
	}

	
	public void deleteAccount(int accId) {
		accountDAO.deleteAccount(accId);

	}
	
	
	public List<Account> getAllAccount() {
		return accountDAO.getAllAccount();
	}
	
	public int login(String email, String password){
		return accountDAO.login(email, password);
	}
	public boolean adminLogin(String email, String password){
		if(email.equals("admin@ctproject.com") && password.equals("123456")){
			return true;
		}
		return false;
	}

}
