package com.ctproject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctproject.dao.AccountDAO;
import com.ctproject.dao.OrderDAO;
import com.ctproject.model.Order;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDAO orderDAO;
	public Order findById(String id){
		return orderDAO.findById(id);
	}
	
	public void saveOrder(Order order){
		orderDAO.saveOrder(order);
	}
	
	public void deleteOrder(Order order){
		orderDAO.deleteOrder(order);
	}
	
	public List<Order> getAllOrder(){
		return orderDAO.getAllOrder();
	}
}
