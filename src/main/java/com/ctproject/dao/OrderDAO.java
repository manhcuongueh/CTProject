package com.ctproject.dao;

import java.util.List;

import com.ctproject.model.Order;


public interface OrderDAO {
	
	void getId();
	
	void updateStatus(int id, String status);
	
	Order findById(int id);
	
	void saveOrder(Order order);
	
	void deleteOrder(Order order);
	
	List<Order> getAllOrder();
	


}
