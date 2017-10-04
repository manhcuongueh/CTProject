package com.ctproject.dao;

import java.util.List;

import com.ctproject.model.OrderDetail;


public interface OrderDetailDAO {

	void saveOrder(OrderDetail orderde);
	
	void deleteOrder(OrderDetail orderde);
	
	List<OrderDetail> getOrderDetail(int id);
}
