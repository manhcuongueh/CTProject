package com.ctproject.service;

import java.util.List;

import com.ctproject.model.OrderDetail;

public interface OrderDetailService {
	
	void saveOrder(OrderDetail orderde);
	
	void deleteOrder(OrderDetail orderde);
	
	List<OrderDetail> getOrderDetail(String id);

}
