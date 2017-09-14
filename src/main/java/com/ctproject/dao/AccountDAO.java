package com.ctproject.dao;
import java.util.List;
import com.ctproject.model.Account;
	public interface AccountDAO {

		Account findById(int id);
		
		int isAccountExist(String email);
		
		void saveAccount(Account account);
		
		void updateAccount(Account account);
		
		void deleteAccount(int accId);
		
		List<Account> getAllAccount();
		
		int login(String email, String password);
	
}
