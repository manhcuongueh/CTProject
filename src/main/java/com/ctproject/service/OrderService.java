package com.ctproject.service;

import java.util.List;

import com.ctproject.dao.OrderDAO;
import com.ctproject.model.Order;

public interface OrderService {
	
	Order findById(String id);
	
	void saveOrder(Order order);
	
	void deleteOrder(Order order);
	
	List<Order> getAllOrder();

}
