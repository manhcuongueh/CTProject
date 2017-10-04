package com.ctproject.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ctproject.model.Account;
import com.ctproject.model.Order;

@Repository("orderDAO")
public class OrderDAOImpl extends AbstractDao<Integer, Order> implements OrderDAO {
	public void getId(){
		
	}
	
	public Order findById(int id){
		//Order order = (Order) getSession().createQuery("FROM order WHERE id LIKE '"+id+"'");
		return getByKey(id);
		
	}
	
	public void saveOrder(Order order){
		persist(order);
	}
	
	public void deleteOrder(Order order){
		delete(order);
	}
	public void updateStatus(int id, String status){
		Query query = getSession().createSQLQuery("update Orders set status='"+status+"'"+" WHERE orderId="+id);
		query.executeUpdate();
	}
	
	
	@SuppressWarnings("unchecked")
	public  List<Order> getAllOrder(){
		return  getSession().createQuery("from Order").list();
		
	}
	

}
