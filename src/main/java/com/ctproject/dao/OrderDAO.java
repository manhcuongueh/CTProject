package com.ctproject.dao;

import java.util.List;

import com.ctproject.model.Order;


public interface OrderDAO {
	
	Order findById(String id);
	
	void saveOrder(Order order);
	
	void deleteOrder(Order order);
	
	List<Order> getAllOrder();
	


}
