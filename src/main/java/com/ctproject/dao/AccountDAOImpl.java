package com.ctproject.dao;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ctproject.model.Account;


	@Repository("accountDAO")
	public class AccountDAOImpl extends AbstractDao<Integer, Account>implements AccountDAO  {
	
	public Account findById(int id) {
			return getByKey(id);
		}
	
	public void saveAccount(Account account){
		persist(account);
	}
	
	public void updateAccount(Account account){
		update(account);
		
	}

	public void deleteAccount(int accId){
		Query query = getSession().createSQLQuery("DELETE FROM Account WHERE accId LIKE '"+accId+"'");
		query.executeUpdate();
	}
		
	@SuppressWarnings("unchecked")
	public int isAccountExist(String email){
		List<Account> infoList = getSession().createQuery("FROM Account WHERE email LIKE '"+email+"'").list();
		if (infoList.size()>=1){
			int id=infoList.get(0).getAccId();
			return id;}
		return 0;
	}
	
	@SuppressWarnings("unchecked")
	public  List<Account> getAllAccount(){
		return  getSession().createQuery("from Account").list();
		
	}
	@SuppressWarnings("unchecked")
	public int login(String email, String password){
		String Que="FROM Account WHERE email LIKE '"+email+"' AND password LIKE'"+password+"'";
		List<Account> list = getSession().createQuery(Que).list();
		if(list.size()>0){
			int id=list.get(0).getAccId();
			return id;
		}
		return 0;
	}


}
