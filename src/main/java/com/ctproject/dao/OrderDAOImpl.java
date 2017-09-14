package com.ctproject.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ctproject.model.Order;

@Repository("orderDAO")
public class OrderDAOImpl extends AbstractDao<Integer, Order> implements OrderDAO {
	
	public Order findById(String id){
		return getByCode(id);
		
	}
	
	public void saveOrder(Order order){
		persist(order);
	}
	
	public void deleteOrder(Order order){
		delete(order);
	}
	
	
	@SuppressWarnings("unchecked")
	public  List<Order> getAllOrder(){
		return  getSession().createQuery("from Order").list();
		
	}
	

}
